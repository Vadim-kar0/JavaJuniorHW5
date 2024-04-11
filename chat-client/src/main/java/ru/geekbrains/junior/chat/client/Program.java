package ru.geekbrains.junior.chat.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        // Для удобства ожидания инициализации серверной части
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите своё имя: ");
        // Укажем свое имя
        String name = scanner.nextLine();

        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Connect To: " + address + ":" + 1300);
            Socket socket = new Socket(address, 1300);
            Client client = new Client(socket, name);
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: " + inetAddress);
            String remoteIp = inetAddress.getHostAddress();
            System.out.println("Remote IP: " + remoteIp);
            System.out.println("LocalPort:" + socket.getLocalPort());
            client.listenForMessage();
            client.sendMessage();
        }
        catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
