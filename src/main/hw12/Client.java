package hw12;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        try (
                Socket socket = new Socket("localhost",9191);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                ) {
            System.out.println("Введмте действие над числами(+,-,*,/): ");
            out.write(scanner.nextLine() + "\n");
            out.flush();
            System.out.println("Введмте первое число: ");
            out.write(String.valueOf(scanner.nextFloat() + "\n"));
            out.flush();
            System.out.println("Введмте второе число: ");
            out.write(String.valueOf(scanner.nextFloat() + "\n"));
            out.flush();
            System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}