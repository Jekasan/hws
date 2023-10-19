package hw12;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws InterruptedException, IOException {
        try (ServerSocket serverSocket = new ServerSocket(9191)) {
            Socket client = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            while (!client.isClosed()) {
                String z = in.readLine();
                System.out.println(z);
                float x = Float.valueOf(in.readLine());
                System.out.println(x);
                float y = Float.valueOf(in.readLine());
                System.out.println(y);

                if (z.equals("+")) {
                    float result = x + y;
                    out.write("Result: " + result + "\n");
                    out.flush();
                }
                if (z.equals("-")) {
                    float result = x - y;
                    out.write("Result: " + result + "\n");
                    out.flush();
                }
                if (z.equals("/")) {
                    float result = x / y;
                    out.write("Result: " + result + "\n");
                    out.flush();
                }
                if (z.equals("*")) {
                    float result = x * y;
                    out.write("Result: " + result + "\n");
                    out.flush();
                }
                return;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

