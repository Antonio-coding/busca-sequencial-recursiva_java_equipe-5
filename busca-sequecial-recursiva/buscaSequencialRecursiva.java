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

        public Funcionario(String matricula, String nome, double salario) {
            this.matricula = matricula;
            this.nome = nome;
            this.salario = salario;
        }
    }

    public static class SistemaCadastro {

        private static List<Funcionario> funcionarios = new ArrayList<>();

        public static void carregarDados(String caminhoArquivo) {
            try {
                File arquivo = new File(caminhoArquivo);
                Scanner scanner = new Scanner(arquivo);

                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    String[] partes = linha.split(" ");

                    double salario = Double.parseDouble(partes[partes.length - 1]);

                    StringBuilder nomeBuilder = new StringBuilder();
                    for (int i = 2; i < partes.length - 1; i++) {
                        nomeBuilder.append(partes[i]);
                        if (i < partes.length - 2) {
                            nomeBuilder.append("-");
                        }
                    }

                    Funcionario funcionario = new Funcionario(
                            partes[0],
                            nomeBuilder.toString(),
                            salario
                    );
                    funcionarios.add(funcionario);
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public static Funcionario buscarPorMatricula(String matricula) {
            return buscarPorMatricula(matricula, 0);
        }

        private static Funcionario buscarPorMatricula(String matricula, int indice) {
            if (indice >= funcionarios.size()) {
                return null; // Funcionário não encontrado
            }

            Funcionario funcionarioAtual = funcionarios.get(indice);

            if (funcionarioAtual.matricula.equals(matricula)) {
                return funcionarioAtual; // Funcionário encontrado
            } else {
                return buscarPorMatricula(matricula, indice + 1);
            }
        }

        public static void main(String[] args) {
            carregarDados("busca-sequecial-recursiva/dados_funcionarios.txt");

            String matriculaBuscada = "89";
            Funcionario funcionarioEncontrado = buscarPorMatricula(matriculaBuscada);

            if (funcionarioEncontrado != null) {
                System.out.println("Funcionário encontrado: " + funcionarioEncontrado.nome);
                System.out.println("Funcionário encontrado: " + funcionarioEncontrado.matricula);
                
               
            } else {
                System.out.println("Funcionário não encontrado.");
            }
        }
    }
}
