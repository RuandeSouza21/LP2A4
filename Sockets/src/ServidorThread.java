import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServidorThread extends Thread{
    private Socket cliente;
    private Socket cliente2;

    public ServidorThread(Socket cliente, Socket cliente2){
        this.cliente = cliente;
        this.cliente2 = cliente2;
    }

    @Override
    public void run() {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader= new InputStreamReader(cliente.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            PrintStream saida2 = new PrintStream(cliente2.getOutputStream());
            String x;
            do {
                x = reader.readLine();
                //System.out.println("Cliente: " + x);
                saida2.println(x);
            } while (x != null);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

