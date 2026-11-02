
import java.util.Scanner;

public class Sistema {

    private Reserva[] reservas;
    private int quantidadeReservas;
    private Scanner scanner;

    // Construtor
    public Sistema() {
        reservas = new Reserva[10];
        quantidadeReservas = 0;
        scanner = new Scanner(System.in);
    }

    // Cadastrar reserva
    public void cadastrarReserva() {

        if (quantidadeReservas >= reservas.length) {
            System.out.println("Limite de reservas atingido!");
            return;
        }

        System.out.print("Nome do hospede: ");
        String nome = scanner.nextLine();

        System.out.print("Tipo de quarto: ");
        String tipo = scanner.nextLine();

        System.out.print("Numero de dias: ");
        int dias = Integer.parseInt(scanner.nextLine());

        System.out.print("Valor da diaria: ");
        double valor = Double.parseDouble(scanner.nextLine());

        reservas[quantidadeReservas] =
                new Reserva(nome, tipo, dias, valor);

        quantidadeReservas++;

        System.out.println("Reserva cadastrada com sucesso!");
    }

    // Listar reservas
    public void listarReservas() {

        if (quantidadeReservas == 0) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        for (int i = 0; i < quantidadeReservas; i++) {
            System.out.println("\nReserva " + (i + 1));
            System.out.println(reservas[i]);
        }
    }

    // Buscar reserva
    public void buscarReserva() {

        System.out.print("Digite o nome do hospede: ");
        String nome = scanner.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < quantidadeReservas; i++) {

            if (reservas[i].getNomeHospede()
                    .equalsIgnoreCase(nome)) {

                System.out.println(reservas[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Reserva nao encontrada.");
        }
    }

    public void ordenarReservas() {

        if (quantidadeReservas == 0) {
            System.out.println("Nenhuma reserva para ordenar.");
            return;
        }

        for (int i = 0; i < quantidadeReservas - 1; i++) {

            for (int j = 0; j < quantidadeReservas - 1 - i; j++) {

                if (reservas[j].getNumeroDias() >
                        reservas[j + 1].getNumeroDias()) {

                    Reserva auxiliar = reservas[j];

                    reservas[j] = reservas[j + 1];

                    reservas[j + 1] = auxiliar;
                }
            }
        }

        System.out.println("Reservas ordenadas com sucesso!");
        listarReservas();
    }

    // Menu principal
    public void iniciar() {

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE RESERVAS =====");
            System.out.println("1 - Cadastrar reserva");
            System.out.println("2 - Listar reservas");
            System.out.println("3 - Buscar reserva");
            System.out.println("4 - Ordenar reservas por dias");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarReserva();
                    break;

                case 2:
                    listarReservas();
                    break;

                case 3:
                    buscarReserva();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.iniciar();
    }
}
