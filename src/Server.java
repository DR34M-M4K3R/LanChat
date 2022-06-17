/*MIT License

Copyright (c) 2022 DR34M-M4K3R

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/


import java.io.*;
import java.net.*;

public class Server extends Thread{
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;

    // constructor with port
    public Server(int port, String pass, String id) {


        String IP = IPAddressReader.main();


        System.out.println("\n\n[*] Starting Server...\n\n" +
                "\n_____________________________________" +
                "\n-Socket     :  "+IP+":"+port +
                "\n-Passphrase :  "+pass +
                "\n-Your id    :  "+id +
                "\n_____________________________________");

        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);

            System.out.println("\n\n[*] Server started. Waiting for clients ...\n");

            socket = server.accept();
            System.out.println("[*] Client connected, waiting for passphrase verification ...\n");

            // to send data to the client
            PrintStream out = new PrintStream(socket.getOutputStream());

            // to read data coming from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            // to read data from the keyboard
            BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));


            String str, str1;

            str = reader.readLine();
            if (str.equals(pass)) {
                System.out.println("[*] Passphrase verified\n");
                out.println("pass ok");


            } else {
                System.out.println("[*] Wrong passphrase from client\n");
                out.println("bad pass");
                System.out.println("Closing connection");

            }

            // server executes continuously
            while (true) {

                // repeat as long as the client
                // does not send a null string

                Thread t = new Thread(new Runnable() {
                    public void run() {
                        while(true) {
                            String str1 = "";
                            try {
                                str1 = kb.readLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            // send to client
                            out.println(id + ": " + str1);
                        }
                    }
                });
                t.start();


                // read from client
                while ((str = reader.readLine()) != null) {
                    System.out.println(str);

                }

                // close connection
                out.close();
                reader.close();
                kb.close();
                server.close();
                socket.close();

                // terminate application
                System.exit(0);

            } // end of while




        } catch (IOException i) {
            System.out.println(i);
        }

    }

    public static void main(int port, String passphrase, String id) {
        Server server = new Server(port, passphrase, id);
    }

}