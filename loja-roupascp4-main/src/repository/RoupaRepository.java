package repository;

import enums.TipoRoupaEnum;
import models.Roupa;
import java.util.List;
import java.util.Scanner;

public interface RoupaRepository {
    void exibirMenu(Scanner leitor);
    void cadastrarRoupa(Scanner leitor);
    void listarRoupas();
    void consultarPorCodigo(Scanner leitor);
    void alterarRoupa(Scanner leitor);
    void excluirRoupa(Scanner leitor);
    void buscarRoupasPorMarca(String marca);
    List<Roupa> buscarRoupasPorTamanho(int tamanho);
    void buscarRoupasPorTipoEmDuasListas(List<Roupa> outraLista, TipoRoupaEnum tipo);
    TipoRoupaEnum escolherTipoRoupa(Scanner leitor);
    void imprimirDetalhesRoupa(Roupa roupa);
}
