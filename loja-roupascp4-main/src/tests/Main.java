package tests;

import repository.RoupaRepository;
import repository.ImplementaRoupa;
import enums.TipoRoupaEnum;
import models.Roupa;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        RoupaRepository repository = new ImplementaRoupa();

        List<Roupa> outraLista = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            try {
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
                        System.out.print("Digite a marca para buscar: ");
                        String marca = leitor.next();
                        ((ImplementaRoupa) repository).buscarRoupasPorMarca(marca);
                        break;
                    case 7:
                        System.out.print("Digite o tamanho para buscar: ");
                        int tamanho = leitor.nextInt();
                        List<Roupa> roupasEncontradas = ((ImplementaRoupa) repository).buscarRoupasPorTamanho(tamanho);
                        roupasEncontradas.forEach(System.out::println);
                        break;
                    case 8:
                        System.out.println("Escolha o tipo de roupa para buscar:");
                        for (TipoRoupaEnum tipo : TipoRoupaEnum.values()) {
                            System.out.println(tipo.ordinal() + 1 + " - " + tipo.name());
                        }
                        int tipoEscolhido = leitor.nextInt();
                        TipoRoupaEnum tipoRoupa = TipoRoupaEnum.values()[tipoEscolhido - 1];
                        ((ImplementaRoupa) repository).buscarRoupasPorTipoEmDuasListas(outraLista, tipoRoupa);
                        break;
                    case 9:
                        continuar = false;
                        System.out.println("Saindo do sistema. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                leitor.nextLine();
            }
        }
        leitor.close();
    }
}
