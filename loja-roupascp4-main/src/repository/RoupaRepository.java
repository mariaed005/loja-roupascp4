package repository;
import java.util.Scanner;

public interface RoupaRepository {
    void exibirMenu(Scanner leitor);

    void cadastrarRoupa(Scanner leitor);

    void listarRoupas();

    void consultarPorCodigo(Scanner leitor);

    void alterarRoupa(Scanner leitor);

    void excluirRoupa(Scanner leitor);
}