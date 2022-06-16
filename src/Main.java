import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
            System.out.println("Set passphrase : ");
            String pass = sc.nextLine();
            System.out.print(">ID : ");
            String id = sc.nextLine();

            Server.main(port, pass, id);

        }

    }

}
