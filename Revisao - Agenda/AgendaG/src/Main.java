import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lembrete lembrete = new Lembrete();
        Tarefa tarefa = new Tarefa();
        Evento evento = new Evento();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    --** Menu **-- 
                    1) Lembretes
                    2) Tarefas
                    3) Eventos
                    4) Fechar o programa
                                    
                    Escolha uma opção: 
                    """);
            int num = scan.nextInt();

            switch (num) {
                case 1:
                    System.out.println("""
                            -- Lembretes -- 
                            1) Criar
                            2) Editar
                            3) Listar
                            4) Excluir
                                    
                            Escolha uma opção: 
                            """);
                    int num1 = scan.nextInt();
                    switch (num1) {
                        case 1:
                            lembrete.criarLembrete();
                            break;
                        case 2:
                            lembrete.editarLembrete();
                            break;
                        case 3:
                            lembrete.mostrarLembretes();
                            break;
                        case 4:
                            lembrete.deletarLembrete();
                            break;
                        default:
                            System.out.println("Digite uma opção válida.");
                    }
                    break;

                case 2:
                    System.out.println("""
                            -- Tarefas -- 
                            1) Criar
                            2) Editar
                            3) Listar
                            4) Excluir
                                    
                            Escolha uma opção: 
                            """);
                    int num2 = scan.nextInt();
                    switch (num2) {
                        case 1:
                            tarefa.criarTarefa();
                            break;
                        case 2:
                            tarefa.editarTarefa();
                            break;
                        case 3:
                            tarefa.mostrarTarefas();
                            break;
                        case 4:
                            tarefa.deletarTarefa();
                            break;
                        default:
                            System.out.println("Digite uma opção válida.");
                    }
                    break;

                case 3:
                    System.out.println("""
                            -- Eventos -- 
                            1) Criar
                            2) Editar
                            3) Listar
                            4) Excluir
                                    
                            Escolha uma opção: 
                            """);
                    int num3 = scan.nextInt();
                    switch (num3) {
                        case 1:
                            evento.criarEvento();
                            break;
                        case 2:
                            evento.editarEvento();
                            break;
                        case 3:
                            evento.mostrarEventos();
                            break;
                        case 4:
                            evento.deletarEvento();
                            break;
                        default:
                            System.out.println("Digite uma opção válida.");
                    }
                    break;

                case 4:
                    System.out.println("Até mais!!!");
                    return;

                default:
                    System.out.println("Digite uma opção válida!");
            }
        }
    }
}