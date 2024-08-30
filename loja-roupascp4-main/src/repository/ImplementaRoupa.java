package repository;

import enums.TipoRoupaEnum;
import models.Roupa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ImplementaRoupa implements RoupaRepository {

    private List<Roupa> roupas = new ArrayList<>();

    @Override
    public void exibirMenu(Scanner leitor) {
        System.out.println("\n*******************************************");
        System.out.println("*                                         *");
        System.out.println("*       BEM-VINDO AO SISTEMA DA LOJA      *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*    1. Cadastrar roupa                   *");
        System.out.println("*    2. Listar roupas                     *");
        System.out.println("*    3. Consultar roupa por código        *");
        System.out.println("*    4. Alterar roupa                     *");
        System.out.println("*    5. Excluir roupa                     *");
        System.out.println("*    6. Sair                              *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void cadastrarRoupa(Scanner leitor) {
        System.out.print("Para cadastrar uma roupa, você terá que nos informar algumas características dela. " +
                "\nPrimeiro digite a marca da roupa: ");
        String marca = leitor.next();

        System.out.print("Digite o tamanho da roupa (número): ");
        int tamanho = leitor.nextInt();

        System.out.print("Digite o material da roupa: ");
        String material = leitor.next();

        System.out.println("Escolha o tipo de roupa: ");
        for (TipoRoupaEnum tipo : TipoRoupaEnum.values()) {
            System.out.println(tipo.ordinal() + 1 + " - " + tipo.name());
        }
        int tipoEscolhido = leitor.nextInt();
        TipoRoupaEnum tipoRoupa = TipoRoupaEnum.values()[tipoEscolhido - 1];

        Roupa roupa = new Roupa(UUID.randomUUID(), marca, tamanho, material, tipoRoupa);
        roupas.add(roupa);

        System.out.println("Roupa cadastrada com sucesso!");
    }

    @Override
    public void listarRoupas() {
        if (roupas.isEmpty()) {
            System.out.println("Nenhuma roupa cadastrada.");
        } else {
            System.out.println("Lista de roupas cadastradas:");
            for (Roupa roupa : roupas) {
                System.out.println("- Código: " + roupa.getCodigo());
                System.out.println("- Marca: " + roupa.getMarca());
                System.out.println("- Tamanho: " + roupa.getTamanho());
                System.out.println("- Material: " + roupa.getMaterial());
                System.out.println("- Tipo: " + roupa.getTipoRoupa());
                System.out.println("--------------------------");
            }
        }
    }

    @Override
    public void consultarPorCodigo(Scanner leitor) {
        System.out.print("Digite o código da roupa (UUID): ");
        String codigo = leitor.next();

        for (Roupa roupa : roupas) {
            if (roupa.getCodigo().toString().equals(codigo)) {
                System.out.println("- Roupa encontrada:");
                System.out.println("- Código: " + roupa.getCodigo());
                System.out.println("- Marca: " + roupa.getMarca());
                System.out.println("- Tamanho: " + roupa.getTamanho());
                System.out.println("- Material: " + roupa.getMaterial());
                System.out.println("- Tipo: " + roupa.getTipoRoupa());
                return;
            }
        }
        System.out.println("Não encontramos a roupa com código " + codigo + " no nosso sistema.");
    }

    @Override
    public void alterarRoupa(Scanner leitor) {
        System.out.print("Digite o código da roupa que deseja alterar (UUID): ");
        String codigo = leitor.next();

        for (Roupa roupa : roupas) {
            if (roupa.getCodigo().toString().equals(codigo)) {
                System.out.print("Digite a nova marca da roupa: ");
                String novaMarca = leitor.next();
                roupa.setMarca(novaMarca);

                System.out.print("Digite o novo tamanho da roupa (número): ");
                int novoTamanho = leitor.nextInt();
                roupa.setTamanho(novoTamanho);

                System.out.print("Digite o novo material da roupa: ");
                String novoMaterial = leitor.next();
                roupa.setMaterial(novoMaterial);

                System.out.println("Escolha o novo tipo de roupa: ");
                for (TipoRoupaEnum tipo : TipoRoupaEnum.values()) {
                    System.out.println(tipo.ordinal() + 1 + " - " + tipo.name());
                }
                int tipoEscolhido = leitor.nextInt();
                roupa.setTipoRoupa(TipoRoupaEnum.values()[tipoEscolhido - 1]);

                System.out.println("Roupa alterada com sucesso!");
                return;
            }
        }
        System.out.println("Roupa com código " + codigo + " não encontrada.");
    }

    @Override
    public void excluirRoupa(Scanner leitor) {
        System.out.print("Digite o código da roupa que deseja excluir (UUID): ");
        String codigo = leitor.next();

        Roupa roupaParaRemover = null;
        for (Roupa roupa : roupas) {
            if (roupa.getCodigo().toString().equals(codigo)) {
                roupaParaRemover = roupa;
                break;
            }
        }

        if (roupaParaRemover != null) {
            roupas.remove(roupaParaRemover);
            System.out.println("Roupa excluída com sucesso!");
        } else {
            System.out.println("Não encontramos a roupa com código " + codigo + " no nosso sistema.");
        }
    }
}
