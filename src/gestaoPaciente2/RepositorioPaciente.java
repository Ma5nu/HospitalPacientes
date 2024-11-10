package gestaoPaciente2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class RepositorioPaciente {
    // Declaração do ArrayList onde salvo as informações e modificações
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private final String arquivoPaciente = "pacientes.txt";

    // Método para manipulação da classe Paciente através do ArrayList
    public void alterarPaciente(int id, String nome, double peso, double altura, char sexo) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                paciente.setNome(nome);
                paciente.setPeso(peso);
                paciente.setAltura(altura);
                paciente.setSexo(sexo);
                System.out.println("Paciente atualizado!");
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    public void excluirPaciente(int id) {
        pacientes.removeIf(paciente -> paciente.getId() == id);
        System.out.println("Paciente excluído com sucesso!");
    }

    public ArrayList<Paciente> listarPacientes() {
        return pacientes;
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente adicionado com sucesso!");
    }

    // Método para salvar pacientes no arquivo
    public void salvarPacientes() { // Tornar público
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoPaciente))) {
            for (Paciente paciente : pacientes) {
                writer.write(paciente.getId() + ";" + paciente.getNome() + ";" + 
                            paciente.getPeso() + ";" + paciente.getAltura() + ";" + 
                            paciente.getSexo());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar pacientes: " + e.getMessage());
        }
    }

    // Método para carregar pacientes do arquivo
    public void carregarPacientes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoPaciente))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                double peso = Double.parseDouble(dados[2]);
                double altura = Double.parseDouble(dados[3]);
                char sexo = dados[4].charAt(0);
                pacientes.add(new Paciente(id, nome, peso, altura, sexo));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de pacientes não encontrado. Será criado ao salvar novos pacientes.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar pacientes: " + e.getMessage());
        }
    }
}