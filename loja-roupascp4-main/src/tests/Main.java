package tests;

import repository.RoupaRepository;
import repository.ImplementaRoupa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        RoupaRepository repository = new ImplementaRoupa();

        boolean continuar = true;
        while (continuar) {
            repository.exibirMenu(leitor);

            int opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    repository.cadastrarRoupa(leitor);
                    break;
                case 2:
                    repository.listarRoupas();
                    break;
                case 3:
                    repository.consultarPorCodigo(leitor);
                    break;
                case 4:
                    repository.alterarRoupa(leitor);
                    break;
                case 5:
                    repository.excluirRoupa(leitor);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        leitor.close();
    }
}