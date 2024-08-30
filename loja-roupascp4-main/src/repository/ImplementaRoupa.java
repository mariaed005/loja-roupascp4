package repository;

import enums.TipoRoupaEnum;
import models.Roupa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

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
        System.out.println("* 1. Cadastrar roupa                      *");
        System.out.println("* 2. Listar roupas                        *");
        System.out.println("* 3. Consultar roupa por código           *");
        System.out.println("* 4. Alterar roupa                        *");
        System.out.println("* 5. Excluir roupa                        *");
        System.out.println("* 6. Buscar roupas por marca              *");
        System.out.println("* 7. Buscar roupas por tamanho            *");
        System.out.println("* 8. Buscar roupas por tipo em duas listas*");
        System.out.println("* 9. Sair                                 *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void cadastrarRoupa(Scanner leitor) {
        System.out.print("Informe a marca da roupa: ");
        String marca = leitor.next();
        System.out.print("Informe o tamanho da roupa (número): ");
        int tamanho = leitor.nextInt();
        System.out.print("Informe o material da roupa: ");
        String material = leitor.next();
        TipoRoupaEnum tipoRoupa = escolherTipoRoupa(leitor);
        Roupa roupa = new Roupa(UUID.randomUUID(), marca, tamanho, material, tipoRoupa);
        roupas.add(roupa);
        System.out.println("Roupa cadastrada com sucesso!");
    }

    @Override
    public void listarRoupas() {
        if (roupas.isEmpty()) {
            System.out.println("Nenhuma roupa cadastrada.");
        } else {
            roupas.stream()
                    .filter(roupa -> roupa.getTamanho() > 0)
                    .forEach(this::imprimirDetalhesRoupa);
        }
    }

    @Override
    public void consultarPorCodigo(Scanner leitor) {
        System.out.print("Digite o código da roupa (UUID): ");
        String codigo = leitor.next();
        roupas.stream()
                .filter(roupa -> roupa.getCodigo().toString().equals(codigo))
                .findFirst()
                .ifPresentOrElse(
                        this::imprimirDetalhesRoupa,
                        () -> System.out.println("Roupa com código " + codigo + " não encontrada.")
                );
    }

    @Override
    public void alterarRoupa(Scanner leitor) {
        System.out.print("Digite o código da roupa que deseja alterar (UUID): ");
        String codigo = leitor.next();
        roupas.stream()
                .filter(roupa -> roupa.getCodigo().toString().equals(codigo))
                .findFirst()
                .ifPresentOrElse(
                        roupa -> {
                            System.out.print("Digite a nova marca da roupa: ");
                            roupa.setMarca(leitor.next());
                            System.out.print("Digite o novo tamanho da roupa (número): ");
                            roupa.setTamanho(leitor.nextInt());
                            System.out.print("Digite o novo material da roupa: ");
                            roupa.setMaterial(leitor.next());
                            roupa.setTipoRoupa(escolherTipoRoupa(leitor));
                            System.out.println("Roupa alterada com sucesso!");
                        },
                        () -> System.out.println("Roupa com código " + codigo + " não encontrada.")
                );
    }

    @Override
    public void excluirRoupa(Scanner leitor) {
        System.out.print("Digite o código da roupa que deseja excluir (UUID): ");
        String codigo = leitor.next();
        roupas.stream()
                .filter(roupa -> roupa.getCodigo().toString().equals(codigo))
                .findFirst()
                .ifPresentOrElse(
                        roupa -> {
                            roupas.remove(roupa);
                            System.out.println("Roupa excluída com sucesso!");
                        },
                        () -> System.out.println("Roupa com código " + codigo + " não encontrada.")
                );
    }

    @Override
    public void buscarRoupasPorMarca(String marca) {
        roupas.stream()
                .filter(roupa -> roupa.getMarca().equalsIgnoreCase(marca))
                .forEach(this::imprimirDetalhesRoupa);
    }

    @Override
    public List<Roupa> buscarRoupasPorTamanho(int tamanho) {
        return roupas.stream()
                .filter(roupa -> roupa.getTamanho() == tamanho)
                .collect(Collectors.toList());
    }

    @Override
    public void buscarRoupasPorTipoEmDuasListas(List<Roupa> outraLista, TipoRoupaEnum tipo) {
        List<Roupa> roupasEncontradas = roupas.stream()
                .filter(roupa -> roupa.getTipoRoupa() == tipo)
                .collect(Collectors.toList());
        roupasEncontradas.addAll(
                outraLista.stream()
                        .filter(roupa -> roupa.getTipoRoupa() == tipo)
                        .collect(Collectors.toList())
        );
        roupasEncontradas.forEach(this::imprimirDetalhesRoupa);
    }

    @Override
    public TipoRoupaEnum escolherTipoRoupa(Scanner leitor) {
        System.out.println("Escolha o tipo de roupa: ");
        for (TipoRoupaEnum tipo : TipoRoupaEnum.values()) {
            System.out.println(tipo.ordinal() + 1 + " - " + tipo.name());
        }
        int tipoEscolhido = leitor.nextInt();
        return TipoRoupaEnum.values()[tipoEscolhido - 1];
    }

    @Override
    public void imprimirDetalhesRoupa(Roupa roupa) {
        System.out.println("- Código: " + roupa.getCodigo());
        System.out.println("- Marca: " + roupa.getMarca());
        System.out.println("- Tamanho: " + roupa.getTamanho());
        System.out.println("- Material: " + roupa.getMaterial());
        System.out.println("- Tipo: " + roupa.getTipoRoupa());
        System.out.println("--------------------------");
    }
}
