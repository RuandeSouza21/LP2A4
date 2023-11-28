import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Socket cliente = new Socket("localhost", 12345);

            ClienteThread clienteThread = new ClienteThread(cliente);
            clienteThread.start();
            PrintStream saida = new PrintStream(cliente.getOutputStream());

            while (true) {
                saida.println(sc.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

