import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Введите n:");
            int n = scanner.nextInt();
            System.out.println("Введите k:");
            int k = scanner.nextInt();
            if (k <= 0 || n <= 0)
                System.out.println("Некорректный ввод");
            if (k < n) {
                writer.write(n);
                writer.write(k);
            } else {
                writer.write(k);
                writer.write(n);
            }
            writer.flush();
            String res = reader.readLine();
            System.out.println("Cnk = " + res);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
