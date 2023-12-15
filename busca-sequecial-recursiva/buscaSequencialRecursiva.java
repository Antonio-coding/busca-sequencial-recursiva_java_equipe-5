// Equipe 5 - 7 PARTICIPANTES
    // Antônio Thiago
    // Breno Fernandes
    // Caio Roberto
    // Jefferson Marques
    // Jorge Klysiman
    // Mirla Vieira
    // Rodrigo Miranda

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuscaSequencialRecursiva {

    // Definição da classe Funcionario
    static class Funcionario {
        int matricula;
        String cargo; // Alterado para String
        String nome;
        double salario;

        public Funcionario(int matricula, String cargo, String nome, double salario) {
            this.matricula = matricula;
            this.cargo = cargo;
            this.nome = nome;
            this.salario = salario;
        }
    }

    // Método de busca sequencial recursiva por matrícula
    public static Funcionario buscarPorMatricula(
            List<Funcionario> funcionarios,
            int matricula,
            int index
    ) {
        // Caso base: funcionário não encontrado
        if (index >= funcionarios.size()) {
            return null;
        }

        // Verifica se a matrícula do funcionário atual é a procurada
        if (funcionarios.get(index).matricula == matricula) {
            return funcionarios.get(index);
        }

        // Chamada recursiva para o próximo funcionário na lista
        return buscarPorMatricula(funcionarios, matricula, index + 1);
    }

    public static void main(String[] args) {
        // Lista para armazenar os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();

        // Leitura dos dados do arquivo
        try (BufferedReader br = new BufferedReader(new FileReader("busca-sequecial-recursiva/dados_funcionarios.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Separar os dados da linha com espaços múltiplos ou tabulações
                String[] dados = linha.split("\\s+");

                // Certifique-se de que existam pelo menos 4 elementos antes de acessar o índice 3
                if (dados.length >= 4) {
                    int matricula = Integer.parseInt(dados[0]);
                    String cargo = dados[1]; // Alterado para String
                    String nome = dados[2].replace("-", " "); // Remover hífens do nome
                    double salario = Double.parseDouble(dados[3]);

                    // Criar objeto Funcionario e adicionar à lista
                    Funcionario funcionario = new Funcionario(matricula, cargo, nome, salario);
                    funcionarios.add(funcionario);
                } else {
                    System.err.println("Formato inválido na linha: " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exemplo de uso da busca sequencial recursiva
        int matriculaBuscada = 280; // Alterado para um número inteiro
        Funcionario funcionarioEncontrado = buscarPorMatricula(funcionarios, matriculaBuscada, 0);

        if (funcionarioEncontrado != null) {
            System.out.println("Funcionário encontrado: " + funcionarioEncontrado.matricula + " Matricula");
            System.out.println("Cargo: " + funcionarioEncontrado.cargo+" Numero do cargo");
            System.out.println("Nome: " + funcionarioEncontrado.nome);
            System.out.println("Salário: " + funcionarioEncontrado.salario + " R$");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
        
    }
}
