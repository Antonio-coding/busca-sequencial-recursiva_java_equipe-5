// Equipe 5 - 7 PARTICIPANTES
    // Antônio Thiago
    // Breno Fernandes
    // Caio Roberto
    // Jefferson Marques
    // Jorge Klysiman
    // Mirla Vieira
    // Rodrigo Miranda


import java.util.List;

public class buscaSequecialRecursiva {

  class SistemaCadastro {

    // Outras partes do código...

    // Método de busca sequencial recursiva por número de matrícula
    public static Funcionario buscarPorMatricula(
      List<Funcionario> funcionarios,
      String matricula,
      int inicio,
      int fim
    ) {
      if (inicio > fim) {
        return null; // Funcionário não encontrado
      }

      int meio = (inicio + fim) / 2;

      if (funcionarios.get(meio).matricula.equals(matricula)) {
        return funcionarios.get(meio); // Funcionário encontrado
      } else if (funcionarios.get(meio).matricula.compareTo(matricula) > 0) {
        // Se a matrícula do meio for maior, buscar na metade esquerda
        return buscarPorMatricula(funcionarios, matricula, inicio, meio - 1);
      } else {
        // Se a matrícula do meio for menor, buscar na metade direita
        return buscarPorMatricula(funcionarios, matricula, meio + 1, fim);
      }
    }

    // Método principal
    public static void main(String[] args) {
      // Carregar dados dos funcionários...

      // Exemplo de uso da busca sequencial recursiva
      String matriculaBuscada = "01001";
      Funcionario funcionarioEncontrado = buscarPorMatricula(
        funcionarios,
        matriculaBuscada,
        0,
        funcionarios.size() - 1
      );

      if (funcionarioEncontrado != null) {
        System.out.println(
          "Funcionário encontrado: " + funcionarioEncontrado.nome
        );
      } else {
        System.out.println("Funcionário não encontrado.");
      }
      // Outras partes do código...
    }
  }
}
