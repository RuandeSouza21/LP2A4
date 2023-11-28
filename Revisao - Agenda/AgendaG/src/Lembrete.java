import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lembrete extends Padrao{
    private static Long idBase = 0L;
    private Long id;

    private List<Lembrete> listaLembretes = new ArrayList<>();
    Scanner sc1 = new Scanner(System.in);

    //-------------------------------------------------------------------------

    public Lembrete() {
    }

    public Lembrete(String titulo, LocalDate data, LocalTime hora, boolean repetir) {
        super(titulo, data, hora, repetir);
        this.id = idBase++;
    }

    //---------------------------------------------------------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //-------------------------------------------------------------------------

    public void criarLembrete(){
        System.out.println("Digite o título do lembrete: ");
        titulo = sc1.nextLine();

        boolean correta = false;
        boolean correta2 = false;

        do {
            try {
                System.out.println("Digite a data do lembrete (dd/MM/yyyy): ");
                String d1 = sc1.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                data = LocalDate.parse(d1, dtf);
                correta = true;
            } catch (Exception e) {
                System.out.println("Digite uma data no formato indicado");
            }
        } while(correta == false);

        do {
            try {
                System.out.println("Digite a hora do lembrete (HH:mm): ");
                String h1 = sc1.nextLine();
                DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
                hora = LocalTime.parse(h1, dtf2);
                correta2 = true;
            } catch (Exception e) {
                System.out.println("Digite uma hora no formato indicado");
            }
        } while (correta2 == false);

        System.out.println("O lembrete será repetido? ('s' ou 'n'): ");
        boolean correta3 = false;

        while (correta3 == false) {
            String resposta = sc1.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                repetir = true;
                System.out.println("O lembrete será repetido");
                correta3 = true;
            } else if (resposta.equalsIgnoreCase("n")) {
                System.out.println("O lembrete não será repetido");
                correta3 = true;
            } else {
                System.out.println("A resposta precisa ser sim(s) ou não(n)");
            }
        }

        System.out.println("Lembrete criado!");
        listaLembretes.add(new Lembrete(titulo, data, hora, repetir));
    }

    public void mostrarLembretes(){
        System.out.println("Sua Lista de Lembretes: \n");
        for(Lembrete cada: listaLembretes){
            System.out.println("Id: " + cada.getId());
            System.out.println("Título: " + cada.getTitulo());
            System.out.println("Data: " +cada.getData());
            System.out.println("Hora: " + cada.getHora());
            System.out.println("-----------------------------------");
        }
    }

    public void deletarLembrete(){
        mostrarLembretes();

        System.out.println("Digite o Id do Lembrete que será excluído: ");
        Long num1 = sc1.nextLong();
        int num2 = Math.toIntExact(num1);
        sc1.nextLine();

        if (listaLembretes.isEmpty()){
            System.out.println("Não existem lembretes no momento.");
            return;
        }

        if (num1 > listaLembretes.size() || num1 < 0) {
            System.out.println("Digite um id valido.");
            return;
        }

        Lembrete lembrete = listaLembretes.get(num2);
        listaLembretes.remove(lembrete);
        System.out.println("Lembrete excluido com sucesso");

    }

    public void editarLembrete(){
        mostrarLembretes();
        System.out.println("Digite o Id do Lembrete que será alterado: ");
        Long num = sc1.nextLong();
        sc1.nextLine();

        for (Lembrete l : listaLembretes){
            if (l.getId().equals(num)){
                System.out.println("Digite o título: ");
                String nome1 = sc1.nextLine();

                boolean correta = false;
                boolean correta2 = false;

                do {
                    try {
                        System.out.println("Digite a data do lembrete (dd/MM/yyyy): ");
                        String d1 = sc1.nextLine();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        data = LocalDate.parse(d1, dtf);
                        correta = true;
                    } catch (Exception e) {
                        System.out.println("Digite uma data no formato indicado");
                    }
                } while(correta == false);

                do {
                    try {
                        System.out.println("Digite a hora do lembrete (HH:mm): ");
                        String h1 = sc1.nextLine();
                        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
                        hora = LocalTime.parse(h1, dtf2);
                        correta2 = true;
                    } catch (Exception e) {
                        System.out.println("Digite uma hora no formato indicado");
                    }
                } while (correta2 == false);

                System.out.println("O lembrete será repetido? ('s' ou 'n'): ");
                boolean correta3 = false;

                while (correta3 == false) {
                    String resposta = sc1.nextLine();
                    if (resposta.equalsIgnoreCase("s")) {
                        repetir = true;
                        System.out.println("O lembrete será repetido");
                        correta3 = true;
                    } else if (resposta.equalsIgnoreCase("n")) {
                        System.out.println("O lembrete não será repetido");
                        correta3 = true;
                    } else {
                        System.out.println("A resposta precisa ser sim(s) ou não(n)");
                    }
                }

                l.setTitulo(nome1);
                l.setData(data);
                l.setHora(hora);
                l.setRepetir(repetir);

                System.out.println("Lembrete alterado com sucesso!");

            }
        }
    }
}
