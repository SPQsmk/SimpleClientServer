import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket client = serverSocket.accept();
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            int n = reader.read();
            System.out.println("n = " + n);
            int k = reader.read();
            System.out.println("k = " + k);
            int nk = n - k;
            double res = 1;
            while ((n > k) || nk > 1) {
                if (n > k)
                    res *= n--;
                if (nk > 1)
                    res /= nk--;
            }
            writer.write(res + "");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
