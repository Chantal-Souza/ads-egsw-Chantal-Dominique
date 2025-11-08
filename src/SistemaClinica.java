import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaClinica {
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Atendente> atendentes = new ArrayList<>();
    private static List<Medico> medicos = new ArrayList<>();
    private static List<Consulta> consultas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        criarDadosExemplo();

        int opcao;
        
        do {
            limparTerminal();

            System.out.println("=== SISTEMA CLINICA - VERSAO 1.0 ===");
            System.out.println("\n1 - Cadastrar Paciente");
            System.out.println("2 - Cadastrar Atendente");
            System.out.println("3 - Cadastrar Medico");
            System.out.println("4 - Realizar Agendamento");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    cadastrarAtendente();
                    break;
                case 3:
                    cadastrarMedico();
                    break;
                case 4:
                    realizarAgendamento();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("\nOpcao invalida!");
                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
            }

        } while (opcao != 0);
    }
    
    private static void cadastrarPaciente() {
        limparTerminal();
        System.out.println("--- CADASTRO DE PACIENTE ---");
        System.out.println("(Digite 0 a qualquer momento para voltar ao menu)");
        
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        if (nome.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (cpf.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        if (telefone.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        Paciente paciente = new Paciente(nome, cpf, telefone);
        pacientes.add(paciente);
        System.out.println("\nPaciente cadastrado com sucesso!");
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }
    
    private static void cadastrarAtendente() {
        limparTerminal();
        System.out.println("--- CADASTRO DE ATENDENTE ---");
        System.out.println("(Digite 0 a qualquer momento para voltar ao menu)");
        
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        if (nome.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (cpf.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        if (matricula.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        Atendente atendente = new Atendente(nome, cpf, matricula);
        atendentes.add(atendente);
        System.out.println("\nAtendente cadastrado com sucesso!");
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }
    
    private static void cadastrarMedico() {
        limparTerminal();
        System.out.println("--- CADASTRO DE MÉDICO ---");
        System.out.println("(Digite 0 a qualquer momento para voltar ao menu)");
        
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        if (nome.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (cpf.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        if (matricula.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        if (especialidade.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        if (crm.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }
        
        Medico medico = new Medico(nome, cpf, matricula, especialidade, crm);
        medicos.add(medico);
        System.out.println("\nMédico cadastrado com sucesso!");
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }
    
    private static void realizarAgendamento() {
        if (pacientes.isEmpty() || medicos.isEmpty() || atendentes.isEmpty()) {
            limparTerminal();
            System.out.println("--- REALIZAR AGENDAMENTO ---");
            System.out.println("\nÉ necessário ter pelo menos um paciente, um atendente e um médico cadastrado!");
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            return;
        }

        int indexAtendente;
        while (true) {
            limparTerminal();
            System.out.println("--- REALIZAR AGENDAMENTO ---");
            System.out.println("(Digite 0 a qualquer momento para voltar ao menu)");

            System.out.println("\nAtendentes cadastrados:");
            for (int i = 0; i < atendentes.size(); i++) {
                System.out.println((i + 1) + " - " + atendentes.get(i).getNome());
            }
            System.out.print("Selecione o atendente (número): ");
            
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                int numero = Integer.parseInt(input);
                indexAtendente = numero - 1;
                
                if (numero == 0) {
                    System.out.println("Voltando ao menu principal...");
                    return;
                }
                
                if (indexAtendente >= 0 && indexAtendente < atendentes.size()) {
                    break;
                } else {
                    System.out.println("\nAtendente inválido!");
                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                }
            } else {
                System.out.println("\nPor favor, digite um número válido.");
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }
        }

        int indexPaciente;
        while (true) {
            limparTerminal();
            System.out.println("--- REALIZAR AGENDAMENTO ---");
            System.out.println("(Digite 0 a qualquer momento para voltar ao menu)");

            System.out.println("\nPacientes cadastrados:");
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println((i + 1) + " - " + pacientes.get(i).getNome());
            }
            System.out.print("Escolha o paciente (número): ");
            
            String input = scanner.nextLine();
            
            if (input.matches("\\d+")) {
                int numero = Integer.parseInt(input);
                indexPaciente = numero - 1;
                
                if (numero == 0) {
                    System.out.println("Voltando ao menu principal...");
                    return;
                }
                
                if (indexPaciente >= 0 && indexPaciente < pacientes.size()) {
                    break;
                } else {
                    System.out.println("\nPaciente inválido!");
                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                }
            } else {
                System.out.println("\nPor favor, digite um número válido.");
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }
        }

        int indexMedico;
        while (true) {
            limparTerminal();
            System.out.println("--- REALIZAR AGENDAMENTO ---");
            System.out.println("(Digite 0 a qualquer momento para voltar ao menu)");

            System.out.println("\nMédicos cadastrados:");
            for (int i = 0; i < medicos.size(); i++) {
                System.out.println((i + 1) + " - " + medicos.get(i).getNome() + " (" + medicos.get(i).getEspecialidade() + ")");
            }
            System.out.print("Escolha o médico (número): ");
            
            String input = scanner.nextLine();
            
            if (input.matches("\\d+")) {
                int numero = Integer.parseInt(input);
                indexMedico = numero - 1;
                
                if (numero == 0) {
                    System.out.println("Voltando ao menu principal...");
                    return;
                }
                
                if (indexMedico >= 0 && indexMedico < medicos.size()) {
                    break;
                } else {
                    System.out.println("\nMédico inválido!");
                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                }
            } else {
                System.out.println("\nPor favor, digite um número válido.");
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }
        }
        limparTerminal();
        System.out.println("--- REALIZAR AGENDAMENTO ---");
        System.out.println("(Digite 0 a qualquer momento para voltar ao menu)");

        System.out.print("\nData da consulta (DD/MM/AAAA): ");
        String data = scanner.nextLine();
        if (data.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }

        limparTerminal();
        System.out.println("--- REALIZAR AGENDAMENTO ---");
        System.out.println("(Digite 0 a qualquer momento para voltar ao menu)");

        System.out.print("\nHorário da consulta (HH:MM): ");
        String horario = scanner.nextLine();
        if (horario.equals("0")) {
            System.out.println("Voltando ao menu principal...");
            return;
        }

        Atendente atendenteSelecionado = atendentes.get(indexAtendente);
        Paciente pacienteSelecionado = pacientes.get(indexPaciente);
        Medico medicoSelecionado = medicos.get(indexMedico);
        
        Consulta consulta = new Consulta(pacienteSelecionado, atendenteSelecionado, medicoSelecionado, data, horario);
        consultas.add(consulta);
        
        System.out.println("\nAgendamento realizado com sucesso!");
        System.out.println("Consulta: " + pacienteSelecionado.getNome() + " com Dr(a). " + 
                        medicoSelecionado.getNome() + " em " + data + " às " + horario);
        System.out.println("Atendente responsável: " + atendenteSelecionado.getNome());
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void limparTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    private static void criarDadosExemplo() {
        pacientes.add(new Paciente("Joao Silva", "111.222.333-44", "(11) 9999-1111"));
        pacientes.add(new Paciente("Maria Santos", "222.333.444-55", "(11) 9999-2222"));
        pacientes.add(new Paciente("Pedro Oliveira", "333.444.555-66", "(11) 9999-3333"));
        
        atendentes.add(new Atendente("Ana Costa", "444.555.666-77", "AT001"));
        atendentes.add(new Atendente("Carlos Lima", "555.666.777-88", "AT002"));
        atendentes.add(new Atendente("Fernanda Rocha", "666.777.888-99", "AT003"));
        
        medicos.add(new Medico("Dr. Roberto Alves", "777.888.999-00", "MED001", "Cardiologia", "CRM/SP 12345"));
        medicos.add(new Medico("Dra. Juliana Martins", "888.999.000-11", "MED002", "Pediatria", "CRM/SP 67890"));
        medicos.add(new Medico("Dr. Marcelo Souza", "999.000.111-22", "MED003", "Ortopedia", "CRM/SP 54321"));
        
        if (!pacientes.isEmpty() && !medicos.isEmpty()) {
            consultas.add(new Consulta(pacientes.get(0), atendentes.get(0), medicos.get(0), "15/01/2024", "09:00"));
            consultas.add(new Consulta(pacientes.get(1), atendentes.get(1), medicos.get(1), "16/01/2024", "14:30"));
            consultas.add(new Consulta(pacientes.get(2), atendentes.get(2), medicos.get(2), "17/01/2024", "10:15"));
        }
    }
}