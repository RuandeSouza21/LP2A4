import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            ServerSocket socket = new ServerSocket(12345);
            System.out.println("Servidor ativo ouvindo a porta 12345!");

            Socket cliente = socket.accept();
            System.out.println("Cliente conectado!");

            Socket cliente2 = socket.accept();
            System.out.println("Cliente 2 conectado!");

            ServidorThread servidorThread = new ServidorThread(cliente, cliente2);
            servidorThread.start();

            ServidorThread servidorThread2 = new ServidorThread(cliente2, cliente);
            servidorThread2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}