import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tarefa extends Padrao{
    private static Long idBase = 0L;
    private Long id;
    String descricao;

    private List<Tarefa> listaTarefas = new ArrayList<>();
    Scanner sc2 = new Scanner(System.in);

    //-------------------------------------------------------------------


    public Tarefa() {
    }

    public Tarefa(String titulo, LocalDate data, LocalTime hora, boolean repetir, String descricao) {
        super(titulo, data, hora, repetir);
        this.descricao = descricao;
        this.id = idBase++;
    }

    //-------------------------------------------------------------------

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //-------------------------------------------------------------------

    public void criarTarefa(){
        System.out.println("Digite o título da tarefa: ");
        titulo = sc2.nextLine();

        System.out.println("Digite a descrição da tarefa: ");
        descricao = sc2.nextLine();

        boolean correta = false;
        boolean correta2 = false;

        do {
            try {
                System.out.println("Digite a data da tarefa (dd/MM/yyyy): ");
                String d1 = sc2.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                data = LocalDate.parse(d1, dtf);
                correta = true;
            } catch (Exception e) {
                System.out.println("Digite uma data no formato indicado");
            }
        } while(correta == false);

        do {
            try {
                System.out.println("Digite a hora da tarefa (HH:mm): ");
                String h1 = sc2.nextLine();
                DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
                hora = LocalTime.parse(h1, dtf2);
                correta2 = true;
            } catch (Exception e) {
                System.out.println("Digite uma hora no formato indicado");
            }
        } while (correta2 == false);

        System.out.println("A tarefa será repetido? ('s' ou 'n'): ");
        boolean correta3 = false;

        while (correta3 == false) {
            String resposta = sc2.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                repetir = true;
                System.out.println("A tarefa será repetida");
                correta3 = true;
            } else if (resposta.equalsIgnoreCase("n")) {
                System.out.println("A tarefa não será repetida");
                correta3 = true;
            } else {
                System.out.println("A resposta precisa ser sim(s) ou não(n)");
            }
        }

        System.out.println("Tarefa criada!");
        listaTarefas.add(new Tarefa(titulo, data, hora, repetir, descricao));
    }

    //-----------------------------------------------------------------------------------------

    public void mostrarTarefas(){
        System.out.println("Sua Lista de Tarefas: \n");
        for(Tarefa cada: listaTarefas){
            System.out.println("Id: " + cada.getId());
            System.out.println("Título: " + cada.getTitulo());
            System.out.println("Título: " + cada.getDescricao());
            System.out.println("Data: " +cada.getData());
            System.out.println("Hora: " + cada.getHora());
            System.out.println("Há repetição?: " + cada.isRepetir());
            System.out.println("-----------------------------------");
        }
    }

    //------------------------------------------------------------------------------------------

    public void deletarTarefa(){
        mostrarTarefas();

        System.out.println("Digite o Id da Tarefa que será excluída: ");
        Long num1 = sc2.nextLong();
        int num2 = Math.toIntExact(num1);
        sc2.nextLine();

        if (listaTarefas.isEmpty()){
            System.out.println("Não existem tarefas no momento.");
            return;
        }

        if (num1 > listaTarefas.size() || num1 < 0) {
            System.out.println("Digite um id valido.");
            return;
        }

        Tarefa tarefa = listaTarefas.get(num2);
        listaTarefas.remove(tarefa);
        System.out.println("Tarefa excluida com sucesso");
    }

    //------------------------------------------------------------------------------

    public void editarTarefa(){
        mostrarTarefas();
        System.out.println("Digite o Id da Tarefa que será alterada: ");
        Long num = sc2.nextLong();
        sc2.nextLine();

        for (Tarefa t : listaTarefas){
            if (t.getId().equals(num)){
                System.out.println("Digite o título da tarefa: ");
                titulo = sc2.nextLine();

                System.out.println("Digite a descrição da tarefa: ");
                descricao = sc2.nextLine();

                boolean correta = false;
                boolean correta2 = false;

                do {
                    try {
                        System.out.println("Digite a data da tarefa (dd/MM/yyyy): ");
                        String d1 = sc2.nextLine();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        data = LocalDate.parse(d1, dtf);
                        correta = true;
                    } catch (Exception e) {
                        System.out.println("Digite uma data no formato indicado");
                    }
                } while(correta == false);

                do {
                    try {
                        System.out.println("Digite a hora da tarefa (HH:mm): ");
                        String h1 = sc2.nextLine();
                        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
                        hora = LocalTime.parse(h1, dtf2);
                        correta2 = true;
                    } catch (Exception e) {
                        System.out.println("Digite uma hora no formato indicado");
                    }
                } while (correta2 == false);

                System.out.println("A tarefa será repetido? ('s' ou 'n'): ");
                boolean correta3 = false;

                while (correta3 == false) {
                    String resposta = sc2.nextLine();
                    if (resposta.equalsIgnoreCase("s")) {
                        repetir = true;
                        System.out.println("A tarefa será repetida");
                        correta3 = true;
                    } else if (resposta.equalsIgnoreCase("n")) {
                        System.out.println("A tarefa não será repetida");
                        correta3 = true;
                    } else {
                        System.out.println("A resposta precisa ser sim(s) ou não(n)");
                    }
                }

                t.setTitulo(titulo);
                t.setDescricao(descricao);
                t.setData(data);
                t.setHora(hora);
                t.setRepetir(repetir);

                System.out.println("Tarefa alterada com sucesso!");
            }
        }
    }

}
