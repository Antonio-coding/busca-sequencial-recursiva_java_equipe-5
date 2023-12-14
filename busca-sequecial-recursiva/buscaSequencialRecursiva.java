import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class buscaSequencialRecursiva {

    public static class Funcionario {
        public String matricula;
        public String nome;
        public double salario;

        // Construtor para facilitar a criação de objetos Funcionario
        public Funcionario(String matricula, String nome, double salario) {
            this.matricula = matricula;
            this.nome = nome;
            this.salario = salario;
        }
    }

    public static class SistemaCadastro {

        private static List<Funcionario> funcionarios = new ArrayList<>();

        // Método para carregar dados dos funcionários a partir de um arquivo
        public static void carregarDados(String caminhoArquivo) {
            try {
                File arquivo = new File(caminhoArquivo);
                Scanner scanner = new Scanner(arquivo);

                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    String[] partes = linha.split(" ");

                    // Criar um novo objeto Funcionario e adicioná-lo à lista
                    Funcionario funcionario = new Funcionario(
                            partes[0],
                            partes[2],
                            Double.parseDouble(partes[3])
                    );
                    funcionarios.add(funcionario);
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Método de busca sequencial recursiva por número de matrícula
        public static Funcionario buscarPorMatricula(List<Funcionario> funcionarios, String matricula, int indice) {
            if (indice >= funcionarios.size()) {
                return null; // Funcionário não encontrado
            }
        
            Funcionario funcionarioAtual = funcionarios.get(indice);
        
            if (funcionarioAtual.matricula.equals(matricula)) {
                return funcionarioAtual; // Funcionário encontrado
            } else {
                // Chamar recursivamente para o próximo índice
                return buscarPorMatricula(funcionarios, matricula, indice + 1);
            }
        }
        

        // Método principal
        public static void main(String[] args) {
            // Carregar dados dos funcionários a partir do arquivo
            carregarDados("busca-sequecial-recursiva/dados_funcionarios.txt");

            // Exemplo de uso da busca sequencial recursiva
            String matriculaBuscada = "113";
            Funcionario funcionarioEncontrado = buscarPorMatricula(
                    funcionarios,
                    matriculaBuscada,
                    0,
                    funcionarios.size() - 1
            );

            if (funcionarioEncontrado != null) {
                System.out.println("Funcionário encontrado: " + funcionarioEncontrado.nome);
            } else {
                System.out.println("Funcionário não encontrado.");
            }
        }

        private static buscaSequencialRecursiva.Funcionario buscarPorMatricula(
                List<buscaSequencialRecursiva.Funcionario> funcionarios2, String matriculaBuscada, int i, int j) {
            return null;
        }
    }
}
