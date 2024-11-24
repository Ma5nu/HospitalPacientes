package gestaoPaciente2.Controle;

import gestaoPaciente2.Controle.RepositorioPaciente;
import gestaoPaciente2.Dominio.Paciente;
import java.util.Scanner;

public class gestaoPaciente2 {
    public static void main(String[] args) {
        RepositorioPaciente repositorio = new RepositorioPaciente();
        repositorio.carregarPacientes(); // Carrega os pacientes do arquivo
        Scanner leitor = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nSistema de Gerenciamento de Paciente\n");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Excluir Paciente");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Salvar e Sair");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    int id = leitor.nextInt();
                    leitor.nextLine(); // Consome a nova linha
                    System.out.print("Nome: ");
                    String nome = leitor.nextLine();
                    System.out.print("Peso: ");
                    double peso = leitor.nextDouble();
                    System.out.print("Altura: ");
                    double altura = leitor.nextDouble();
                    System.out.print("Sexo (M - Masculino, F - Feminino): ");
                    char sexo = leitor.next().charAt(0);
                    repositorio.adicionarPaciente(new Paciente(id, nome, peso, altura, sexo));
                    System.out.println("Paciente adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("ID do Paciente para alterar: ");
                    int alterarId = leitor.nextInt();
                    leitor.nextLine(); // Consome a nova linha
                    System.out.print("Novo nome: ");
                    String novoNome = leitor.nextLine();
                    System.out.print("Novo Peso: ");
                    double novoPeso = leitor.nextDouble();
                    System.out.print("Nova altura: ");
                    double novaAltura = leitor.nextDouble();
                    System.out.print("Novo sexo (M - Masculino, F - Feminino): ");
                    char novoSexo = leitor.next().charAt(0);
                    repositorio.alterarPaciente(alterarId, novoNome, novoPeso, novaAltura, novoSexo);
                    System.out.println("Paciente alterado com sucesso!");
                    break;
                case 3:
                    System.out.print("ID do Paciente para excluir: ");
                    int idExcluir = leitor.nextInt();
                    repositorio.excluirPaciente(idExcluir);
                    System.out.println("Paciente excluído com sucesso!");
                    break;
                case 4:
                    System.out.println("Lista de Pacientes:");
                    for (Paciente paciente : repositorio.listarPacientes()) {
                        System.out.println(paciente);
                    }
                    break;
                case 5:
                    System.out.println("Salvando pacientes e saindo...");
                    repositorio.salvarPacientes(); // Salva os pacientes no arquivo antes de sair
                    break;
                case 6:
                    System.out.println("Encerrando o Programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 6);
        leitor.close(); // Fecha o scanner ao final do programa
    }
}