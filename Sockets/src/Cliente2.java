import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Socket cliente2 = new Socket("localhost", 12345);

            ClienteThread clienteThread = new ClienteThread(cliente2);
            clienteThread.start();
            PrintStream saida = new PrintStream(cliente2.getOutputStream());

            while (true) {
                saida.println(sc.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

