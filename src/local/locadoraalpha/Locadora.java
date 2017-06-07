
package local.locadoraalpha;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import local.utilidade.Teclado;



public class Locadora {

    private Filme filme;

    public void menu() {
        while (true) {
            try {
                System.out.println("+--------------------------------+");
                System.out.println("|               Menu             |");
                System.out.println("+--------------------------------+");
                System.out.println("1. Inserir Filme");
                System.out.println("2. Listar Filmes");
                System.out.println("3. Sair");
                int escolha = Teclado.leIntTerminal("Escolha uma opção: ");
                switch (escolha) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        listarFilmes();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (IOException ex) {
                Logger.getLogger(Locadora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void cadastrar() throws IOException {
        String nome = Teclado.leStringTerminal("Nome do filme: ");
        String tipo = Teclado.leStringTerminal("Tipo do filme(DVD/Bluray): ");
        String genero = Teclado.leStringTerminal("Genero: ");
        int duracao = Teclado.leIntTerminal("Duração do filme (minutos): ");
        boolean lancamento = Teclado.leBooleanTerminal("É lançamento?(SIM/NÃO) ");
        boolean locado = false;
        filme = new Filme(nome, genero, duracao, tipo, lancamento, locado);
        filme.salvar();
    }
    private void listarFilmes() throws FileNotFoundException, IOException {
        System.out.println("+----------------------------------------+");
        System.out.println("|           LISTAGEM DE FILMES           |");
        System.out.println("+----------------------------------------+");
        for (Filme f : Filme.buscarTodos()) {
            if (f != null) {
                System.out.println("|Código:\t\t" + f.getCodigo() + "\t\t|");
                System.out.println("|Nome:\t\t" + f.getNome() + "\t|");
                System.out.println("|Tipo:\t\t\t" + f.getTipo() + "\t\t|");
                System.out.println("|Gênero:\t\t" + f.getGenero() + "\t\t|");
                System.out.println("|Duração:\t\t" + f.getDuracao() + " minutos\t\t|");
                System.out.println("|Lançamento:\t\t" + f.isLancamento() + "\t\t|");
                System.out.println("|Locado:\t\t" + f.isLocado() + "\t\t|");
                System.out.println("+---------------------------------------+");
            }
        }
    }
}
