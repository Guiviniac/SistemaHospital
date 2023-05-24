import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GestaoHospital {
    private Queue<Paciente> filaNormal;
    private Queue<Paciente> filaLeve;
    private Queue<Paciente> filaModerado;
    private Queue<Paciente> filaSevero;
    private Scanner scanner;

    public GestaoHospital() {
        filaNormal = new LinkedList<>();
        filaLeve = new LinkedList<>();
        filaModerado = new LinkedList<>();
        filaSevero = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    public void adicionarPaciente() {
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite a prioridade do paciente (0 - normal, 1 - leve, 2 - moderado, 3 - severo): ");
        int prioridade = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = new Paciente(nome, cpf, prioridade);

        switch (prioridade) {
            case 0:
                filaNormal.add(paciente);
                break;
            case 1:
                filaLeve.add(paciente);
                break;
            case 2:
                filaModerado.add(paciente);
                break;
            case 3:
                filaSevero.add(paciente);
                break;
            default:
                System.out.println("Prioridade inválida. Por favor, escolha um valor entre 0 e 3.");
                break;
        }

        System.out.println("Paciente " + paciente.getNome() + " adicionado na fila com prioridade " + paciente.getPrioridade());
    }

    public void atenderProximoPaciente() {
        if (!filaSevero.isEmpty()) {
            Paciente paciente = filaSevero.poll();
            System.out.println("Atendendo paciente severo: " + paciente.getNome());
        } else if (!filaModerado.isEmpty()) {
            Paciente paciente = filaModerado.poll();
            System.out.println("Atendendo paciente moderado: " + paciente.getNome());
        } else if (!filaLeve.isEmpty()) {
            Paciente paciente = filaLeve.poll();
            System.out.println("Atendendo paciente leve: " + paciente.getNome());
        } else if (!filaNormal.isEmpty()) {
            Paciente paciente = filaNormal.poll();
            System.out.println("Atendendo paciente normal: " + paciente.getNome());
        } else {
            System.out.println("Não há pacientes na fila.");
        }
    }

    public int getNumeroPacientesNaFila() {
        return filaNormal.size() + filaLeve.size() + filaModerado.size() + filaSevero.size();
    }

    public void exibirFilaPrioridade() {
        System.out.println("Fila de Pacientes em Ordem de Prioridade:");
        System.out.println("Prioridade Severa:");
        for (Paciente paciente : filaSevero) {
            System.out.println("Nome: " + paciente.getNome() + ", CPF: " + paciente.getCpf());
        }
        System.out.println("Prioridade Moderada:");
        for (Paciente paciente : filaModerado) {
            System.out.println("Nome: " + paciente.getNome() + ", CPF: " + paciente.getCpf());
        }
        System.out.println("Prioridade Leve:");
        for (Paciente paciente : filaLeve) {
            System.out.println("Nome: " + paciente.getNome() + ", CPF: " + paciente.getCpf());
        }
        System.out.println("Prioridade Normal:");
        for (Paciente paciente : filaNormal) {
            System.out.println("Nome: " + paciente.getNome() + ", CPF: " + paciente.getCpf());
        }
    }

    public void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Adicionar paciente à fila");
        System.out.println("2. Atender próximo paciente");
        System.out.println("3. Exibir número de pacientes na fila");
        System.out.println("4. Exibir fila de pacientes em ordem de prioridade");
        System.out.println("5. Encerrar programa");
    }

    public void iniciarPrograma() {
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarPaciente();
                    break;
                case 2:
                    atenderProximoPaciente();
                    break;
                case 3:
                    int numeroPacientes = getNumeroPacientesNaFila();
                    System.out.println("Número de pacientes na fila: " + numeroPacientes);
                    break;
                case 4:
                    exibirFilaPrioridade();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        GestaoHospital gestaoHospital = new GestaoHospital();
        gestaoHospital.iniciarPrograma();
    }
}
