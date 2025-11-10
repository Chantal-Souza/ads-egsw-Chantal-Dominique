import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaClinica {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Atendente> atendentes = new ArrayList<>();
    private static List<Medico> medicos = new ArrayList<>();
    private static List<Consulta> consultas = new ArrayList<>();

    public static void main(String[] args) {
        criarDadosExemplo();

        int opcao;
        do {
            limparTerminal();
            Menu.exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPaciente();
                case 2 -> cadastrarAtendente();
                case 3 -> cadastrarMedico();
                case 4 -> realizarAgendamento();
                case 5 -> listarCadastros();
                case 6 -> buscarPacientePorNome();
                case 7 -> buscarMedicoPorNome();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> {
                    System.out.println("Opção inválida!");
                    esperar();
                }
            }
        } while (opcao != 0);
    }

    // ============================
    // MÉTODOS DE CADASTRO
    // ============================
    private static void cadastrarPaciente() {
        limparTerminal();
        System.out.println("--- CADASTRO DE PACIENTE ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        if (nome.equals("0")) return;

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (cpf.equals("0")) return;

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        if (telefone.equals("0")) return;

        pacientes.add(new Paciente(nome, cpf, telefone));
        System.out.println("\nPaciente cadastrado com sucesso!");
        esperar();
    }

    private static void cadastrarAtendente() {
        limparTerminal();
        System.out.println("--- CADASTRO DE ATENDENTE ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        if (nome.equals("0")) return;

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (cpf.equals("0")) return;

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        if (matricula.equals("0")) return;

        atendentes.add(new Atendente(nome, cpf, matricula));
        System.out.println("\nAtendente cadastrado com sucesso!");
        esperar();
    }

    private static void cadastrarMedico() {
        limparTerminal();
        System.out.println("--- CADASTRO DE MÉDICO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        if (nome.equals("0")) return;

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (cpf.equals("0")) return;

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        if (matricula.equals("0")) return;

        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        if (especialidade.equals("0")) return;

        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        if (crm.equals("0")) return;

        medicos.add(new Medico(nome, cpf, matricula, especialidade, crm));
        System.out.println("\nMédico cadastrado com sucesso!");
        esperar();
    }

    // ============================
    // MÉTODOS DE AGENDAMENTO
    // ============================
    private static void realizarAgendamento() {
        if (pacientes.isEmpty() || medicos.isEmpty() || atendentes.isEmpty()) {
            System.out.println("\nÉ necessário ter pelo menos um paciente, médico e atendente cadastrados!");
            esperar();
            return;
        }

        limparTerminal();
        System.out.println("--- REALIZAR AGENDAMENTO ---");

        System.out.println("\nEscolha o atendente:");
        for (int i = 0; i < atendentes.size(); i++) {
            System.out.println((i + 1) + " - " + atendentes.get(i).getNome());
        }
        System.out.print("Selecione: ");
        int indexAtendente = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("\nEscolha o paciente:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + " - " + pacientes.get(i).getNome());
        }
        System.out.print("Selecione: ");
        int indexPaciente = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("\nEscolha o médico:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + " - " + medicos.get(i).getNome() +
                    " (" + medicos.get(i).getEspecialidade() + ")");
        }
        System.out.print("Selecione: ");
        int indexMedico = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("\nData (DD/MM/AAAA): ");
        String data = scanner.nextLine();
        System.out.print("Horário (HH:MM): ");
        String horario = scanner.nextLine();

        Consulta consulta = new Consulta(
                pacientes.get(indexPaciente),
                atendentes.get(indexAtendente),
                medicos.get(indexMedico),
                data, horario
        );
        consultas.add(consulta);

        System.out.println("\nAgendamento realizado com sucesso!");
        System.out.println(consulta);
        esperar();
    }

    // ============================
    // CONSULTAS E LISTAGENS
    // ============================
    private static void listarCadastros() {
        limparTerminal();
        System.out.println("--- LISTA DE CADASTROS ---");
        System.out.println("1 - Pacientes");
        System.out.println("2 - Atendentes");
        System.out.println("3 - Médicos");
        System.out.println("4 - Consultas");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> listarPacientes();
            case 2 -> listarAtendentes();
            case 3 -> listarMedicos();
            case 4 -> listarConsultas();
            case 0 -> {}
            default -> System.out.println("Opção inválida!");
        }
        esperar();
    }

    private static void listarPacientes() {
        System.out.println("\nPacientes Cadastrados:\n");
        if (pacientes.isEmpty()) System.out.println("Nenhum paciente cadastrado.");
        else pacientes.forEach(System.out::println);
    }

    private static void listarAtendentes() {
        System.out.println("\nAtendentes Cadastrados:\n");
        if (atendentes.isEmpty()) System.out.println("Nenhum atendente cadastrado.");
        else atendentes.forEach(System.out::println);
    }

    private static void listarMedicos() {
        System.out.println("\nMédicos Cadastrados:\n");
        if (medicos.isEmpty()) System.out.println("Nenhum médico cadastrado.");
        else medicos.forEach(System.out::println);
    }

    private static void listarConsultas() {
        System.out.println("\nConsultas Agendadas:\n");
        if (consultas.isEmpty()) System.out.println("Nenhuma consulta agendada.");
        else consultas.forEach(System.out::println);
    }

    // ============================
    // BUSCAS (Versão 1.2)
    // ============================
    private static void buscarPacientePorNome() {
        limparTerminal();
        System.out.print("Digite o nome do paciente: ");
        String nomeBusca = scanner.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Paciente p : pacientes) {
            if (p.getNome().toLowerCase().contains(nomeBusca)) {
                System.out.println("\n" + p);
                System.out.println("Consultas deste paciente:");
                for (Consulta c : consultas) {
                    if (c.getPaciente().equals(p)) {
                        System.out.println(c);
                    }
                }
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\nNenhum paciente encontrado com esse nome.");
        }
        esperar();
    }

    private static void buscarMedicoPorNome() {
        limparTerminal();
        System.out.print("Digite o nome do médico: ");
        String nomeBusca = scanner.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Medico m : medicos) {
            if (m.getNome().toLowerCase().contains(nomeBusca)) {
                System.out.println("\n" + m);
                System.out.println("Consultas deste médico:");
                for (Consulta c : consultas) {
                    if (c.getMedico().equals(m)) {
                        System.out.println(c);
                    }
                }
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\nNenhum médico encontrado com esse nome.");
        }
        esperar();
    }

    // ============================
    // UTILITÁRIOS
    // ============================
    private static void limparTerminal() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("\n".repeat(30));
        }
    }

    private static void esperar() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void criarDadosExemplo() {
        pacientes.add(new Paciente("João Silva", "111.222.333-44", "(11) 9999-1111"));
        pacientes.add(new Paciente("Maria Santos", "222.333.444-55", "(11) 9999-2222"));
        pacientes.add(new Paciente("Pedro Oliveira", "333.444.555-66", "(11) 9999-3333"));

        atendentes.add(new Atendente("Ana Costa", "444.555.666-77", "AT001"));
        atendentes.add(new Atendente("Carlos Lima", "555.666.777-88", "AT002"));

        medicos.add(new Medico("Dr. Roberto Alves", "777.888.999-00", "MED001", "Cardiologia", "CRM/SP 12345"));
        medicos.add(new Medico("Dra. Juliana Martins", "888.999.000-11", "MED002", "Pediatria", "CRM/SP 67890"));

        consultas.add(new Consulta(pacientes.get(0), atendentes.get(0), medicos.get(0), "15/01/2024", "09:00"));
        consultas.add(new Consulta(pacientes.get(1), atendentes.get(1), medicos.get(1), "16/01/2024", "14:30"));
    }
}