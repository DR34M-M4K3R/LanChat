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


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {




        Scanner sc = new Scanner(System.in);
        IPAddressReader.main();


        System.out.println(" _____________\n| LOCAL CHAT |\n _____________\n[1] - Join Server   |   [2] - Start Server");

        if (sc.nextLine().equals("1")){

            System.out.print("_________________\n\n>Host : 192.168.1.");
            String addr = sc.nextLine();
            addr = "192.168.1."+addr;
            System.out.println(">Port : ");
            int port = sc.nextInt();
            sc.nextLine();
            System.out.print(">ID : ");
            String id = sc.nextLine();
            System.out.print(">Passphrase : ");
            String pass = sc.nextLine();

            Client.main(addr, port, pass, id);


        }else{
            System.out.print("_________________\n\n>Port : ");
            int port = sc.nextInt();
            sc.nextLine();
            System.out.println(">Set passphrase : ");
            String pass = sc.nextLine();
            System.out.print(">ID : ");
            String id = sc.nextLine();

            Server.main(port, pass, id);

        }

    }

}
