package local.utilidade;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Classe fazer leitura de dados através da classe JOptionPane.
 *
 * @author Angelo
 */
public class Teclado {

    /**
     * Leitura de dados com JOptionPane.
     *
     * @param mensagem Mensagem a ser apresentada ao usuário
     * @return a String lida
     */
    public static String leStringJOptionPane(String mensagem) {
        String entrada = JOptionPane.showInputDialog(mensagem);
        return entrada;
    }

    /**
     * Leitura de dados em Terminal.
     *
     * @param mensagem Mensagem a ser apresentada ao usuário
     * @return a String lida
     */
    public static String leStringTerminal(String mensagem) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensagem);
        String entrada = teclado.nextLine();
        return entrada;
    }

    /**
     * Leitura de dados com JOptionPane.
     *
     * @param mensagem Mensagem a ser apresentada ao usuário
     * @return o int lido
     */
    public static int leIntJOptionPane(String mensagem) {
        int entrada = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
        return entrada;
    }

    /**
     * Leitura de dados em Terminal.
     *
     * @param mensagem Mensagem a ser apresentada ao usuário
     * @return o int lido
     */
    public static int leIntTerminal(String mensagem) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensagem);
        int entrada = (teclado.nextInt());
        return entrada;
    }

    /**
     * Leitura de dados com JOptionPane.
     *
     * @param mensagem Mensagem a ser apresentada ao usuário
     * @return o double lido
     */
    public static double leDoubleJOptionPane(String mensagem) {
        double entrada = Double.parseDouble(JOptionPane.showInputDialog(mensagem));
        return entrada;
    }

    /**
     * Leitura de dados com Terminal.
     *
     * @param mensagem Mensagem a ser apresentada ao usuário
     * @return o double lido
     */
    public static double leDoubleTerminal(String mensagem) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensagem);
        double entrada = (teclado.nextDouble());
        return entrada;
    }

    /**
     * Leitura de dados com JOptionPane.
     *
     * @param mensagem Mensagem a ser apresentada ao usuário
     * @return o long lido
     */
    public static long leLongJOptionPane(String mensagem) {
        long entrada = Long.parseLong(JOptionPane.showInputDialog(mensagem));
        return entrada;
    }

    /**
     * Digitar "SIM" ou "NÃO"
     *
     * @param mensagem Mensagem a ser apresentada ao usuário
     * @return um boolean
     */
    public static boolean leBooleanJOptionPane(String mensagem) {
        boolean entrada = ((JOptionPane.showInputDialog(mensagem).equals("SIM")));
        return entrada;
    }

    /**
     * Digitar "SIM" ou "NÃO"
     *
     * @param mensagem Mensagem a ser apresentada ao usuário
     * @return um boolean
     */
    public static boolean leBooleanTerminal(String mensagem) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensagem);
        boolean entrada = ((teclado.nextLine().equals("SIM")));
        return entrada;
    }
}
