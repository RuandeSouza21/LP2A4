import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evento extends Padrao{
    private static Long idBase = 0L;
    private Long id;
    String descricao;
    LocalDate dataFim;
    LocalTime horaFim;
    String local;

    private List<Evento> listaEventos = new ArrayList<>();
    Scanner sc3 = new Scanner(System.in);

    //-------------------------------------------------------------------


    public Evento() {}

    public Evento(String titulo, LocalDate data, LocalTime hora, boolean repetir, String descricao, LocalDate dataFim, LocalTime horaFim, String local) {
        super(titulo, data, hora, repetir);
        this.id = idBase++;
        this.descricao = descricao;
        this.dataFim = dataFim;
        this.horaFim = horaFim;
        this.local = local;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }

    //-------------------------------------------------------------------

    public void criarEvento(){
        System.out.println("Digite o título do evento: ");
        titulo = sc3.nextLine();

        System.out.println("Digite a descrição do evento: ");
        descricao = sc3.nextLine();

        boolean correta = false;
        boolean correta2 = false;
        boolean correta3 = false;
        boolean correta4 = false;

        do {
            try {
                System.out.println("Digite a data de inicio do evento (dd/MM/yyyy): ");
                String d1 = sc3.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                data = LocalDate.parse(d1, dtf);
                correta = true;
            } catch (Exception e) {
                System.out.println("Digite uma data no formato indicado");
            }
        } while(correta == false);

        do {
            try {
                System.out.println("Digite a data de termino do evento (dd/MM/yyyy): ");
                String d2 = sc3.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataFim = LocalDate.parse(d2, dtf);
                correta3 = true;
            } catch (Exception e) {
                System.out.println("Digite uma data no formato indicado");
            }
        } while(correta3 == false);

        do {
            try {
                System.out.println("Digite a hora de inicio do evento (HH:mm): ");
                String h1 = sc3.nextLine();
                DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
                hora = LocalTime.parse(h1, dtf2);
                correta2 = true;
            } catch (Exception e) {
                System.out.println("Digite uma hora no formato indicado");
            }
        } while (correta2 == false);

        do {
            try {
                System.out.println("Digite a hora de termino do evento (HH:mm): ");
                String h2 = sc3.nextLine();
                DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
                horaFim = LocalTime.parse(h2, dtf2);
                correta4 = true;
            } catch (Exception e) {
                System.out.println("Digite uma hora no formato indicado");
            }
        } while (correta4 == false);

        System.out.println("O evento será repetido? ('s' ou 'n'): ");
        boolean correta5 = false;

        while (correta5 == false) {
            String resposta = sc3.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                repetir = true;
                System.out.println("O evento será repetido");
                correta5 = true;
            } else if (resposta.equalsIgnoreCase("n")) {
                System.out.println("O evento não será repetido");
                correta5 = true;
            } else {
                System.out.println("A resposta precisa ser sim(s) ou não(n)");
            }
        }

        System.out.println("Digite o local do evento: ");
        local = sc3.nextLine();

        System.out.println("Evento criado!");
        listaEventos.add(new Evento(titulo, data, hora, repetir, descricao, dataFim, horaFim, local));
    }

    //-------------------------------------------------------------------

    public void mostrarEventos(){
        System.out.println("Sua Lista de Eventos: \n");
        for(Evento cada: listaEventos){
            System.out.println("Id: " + cada.getId());
            System.out.println("Título: " + cada.getTitulo());
            System.out.println("Título: " + cada.getDescricao());
            System.out.println("Data de inicio: " +cada.getData());
            System.out.println("Data do termino: " +cada.getDataFim());
            System.out.println("Hora do inicio: " + cada.getHora());
            System.out.println("Hora do termino: " + cada.getHoraFim());
            System.out.println("Local: " + cada.getLocal());
            System.out.println("Há repetição?: " + cada.isRepetir());
            System.out.println("-----------------------------------");
        }
    }

    //-------------------------------------------------------------------

    public void deletarEvento(){
        mostrarEventos();

        System.out.println("Digite o Id do Evento que será excluído: ");
        Long num1 = sc3.nextLong();
        int num2 = Math.toIntExact(num1);
        sc3.nextLine();

        if (listaEventos.isEmpty()){
            System.out.println("Não existem eventos no momento.");
            return;
        }

        if (num1 > listaEventos.size() || num1 < 0) {
            System.out.println("Digite um id valido.");
            return;
        }

        Evento evento = listaEventos.get(num2);
        listaEventos.remove(evento);
        System.out.println("Evento excluido com sucesso");
    }

    //------------------------------------------------------------------------------

    public void editarEvento(){
        mostrarEventos();
        System.out.println("Digite o Id do Evento que será alterado: ");
        Long num = sc3.nextLong();
        sc3.nextLine();

        for (Evento ev : listaEventos){
            if (ev.getId().equals(num)){
                System.out.println("Digite o título do evento: ");
                titulo = sc3.nextLine();

                System.out.println("Digite a descrição do evento: ");
                descricao = sc3.nextLine();

                boolean correta = false;
                boolean correta2 = false;
                boolean correta3 = false;
                boolean correta4 = false;

                do {
                    try {
                        System.out.println("Digite a data de inicio do evento (dd/MM/yyyy): ");
                        String d1 = sc3.nextLine();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        data = LocalDate.parse(d1, dtf);
                        correta = true;
                    } catch (Exception e) {
                        System.out.println("Digite uma data no formato indicado");
                    }
                } while(correta == false);

                do {
                    try {
                        System.out.println("Digite a data de termino do evento (dd/MM/yyyy): ");
                        String d2 = sc3.nextLine();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        dataFim = LocalDate.parse(d2, dtf);
                        correta3 = true;
                    } catch (Exception e) {
                        System.out.println("Digite uma data no formato indicado");
                    }
                } while(correta3 == false);

                do {
                    try {
                        System.out.println("Digite a hora de inicio do evento (HH:mm): ");
                        String h1 = sc3.nextLine();
                        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
                        hora = LocalTime.parse(h1, dtf2);
                        correta2 = true;
                    } catch (Exception e) {
                        System.out.println("Digite uma hora no formato indicado");
                    }
                } while (correta2 == false);

                do {
                    try {
                        System.out.println("Digite a hora de termino do evento (HH:mm): ");
                        String h2 = sc3.nextLine();
                        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
                        horaFim = LocalTime.parse(h2, dtf2);
                        correta4 = true;
                    } catch (Exception e) {
                        System.out.println("Digite uma hora no formato indicado");
                    }
                } while (correta4 == false);

                System.out.println("O evento será repetido? ('s' ou 'n'): ");
                boolean correta5 = false;

                while (correta5 == false) {
                    String resposta = sc3.nextLine();
                    if (resposta.equalsIgnoreCase("s")) {
                        repetir = true;
                        System.out.println("O evento será repetido");
                        correta5 = true;
                    } else if (resposta.equalsIgnoreCase("n")) {
                        System.out.println("O evento não será repetido");
                        correta5 = true;
                    } else {
                        System.out.println("A resposta precisa ser sim(s) ou não(n)");
                    }
                }

                System.out.println("Digite o local do evento: ");
                local = sc3.nextLine();

                ev.setTitulo(titulo);
                ev.setDescricao(descricao);
                ev.setData(data);
                ev.setDataFim(dataFim);
                ev.setHora(hora);
                ev.setHoraFim(horaFim);
                ev.setRepetir(repetir);
                ev.setLocal(local);

                System.out.println("Evento alterado com sucesso!");
            }
        }
    }
}
