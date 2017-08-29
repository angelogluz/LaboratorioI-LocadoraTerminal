/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.locadoraalpha;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Angelo2
 */
public final class Filme {

    private int codigo;
    private String genero;
    private String nome;
    private int duracao;
    private String tipo;
    private boolean lancamento;
    private boolean locado;

    public Filme(String nome, String genero, int duracao, String tipo, boolean lancamento,
            boolean locado) {
        buscaCodigo();
        setNome(nome);
        setGenero(genero);
        setDuracao(duracao);
        setTipo(tipo);
        setLancamento(lancamento);
        setLocado(locado);
    }

    public Filme(int codigo, String nome, String genero, int duracao, String tipo, boolean lancamento,
            boolean locado) {
        setCodigo(codigo);
        setNome(nome);
        setGenero(genero);
        setDuracao(duracao);
        setTipo(tipo);
        setLancamento(lancamento);
        setLocado(locado);
    }

    public Filme(String nome, String tipo) {
        setNome(nome);
        buscaCodigo();
        setTipo(tipo);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getGenero() {
        return genero;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isLancamento() {
        return lancamento;
    }

    public boolean isLocado() {
        return locado;
    }

    public void buscaCodigo() {
        Random c = new Random();
        this.codigo = c.nextInt(1000);
    }

    public void setCodigo(int codigo) {
        this.codigo = (codigo > 0 ? codigo : 0);
    }

    public void setGenero(String genero) {
        this.genero = (genero.length() >= 4 && genero.length() <= 25 ? genero : "Indefinido");
    }

    public void setNome(String nome) {
        this.nome = (nome.length() >= 2 && nome.length() <= 100 ? nome : "indefinido");
    }

    /**
     *
     * @param duracao tempo em minutos
     */
    public void setDuracao(int duracao) {
        this.duracao = (duracao > 0 && duracao <= 500 ? duracao : 0);
    }

    public void setTipo(String tipo) {
        this.tipo = (tipo.equalsIgnoreCase("DVD") || tipo.equalsIgnoreCase("Bluray") ? tipo : "Indefinido");
    }

    public void setLancamento(boolean lancamento) {
        this.lancamento = lancamento;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }
    
    

    @Override
    public String toString() {
        return String.format("Código: %d \t Nome: %s\t\t Tipo: %s", codigo, nome, tipo);
    }

    /**
     * @throws IOException
     */
    public void salvarTxt() throws IOException {

        File f = new File("locadora.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter(f, true);
//        FileReader fr = new FileReader()
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.format("%d;%s;%s;%d;%s;%b;%b", codigo, genero, nome, duracao, tipo,
                lancamento, locado));
        bw.newLine();
        bw.flush();
        fw.close();
        bw.close();

    }

    public void salvarXml() throws IOException {
        File f = new File("filme"+codigo+".xml");
        f.createNewFile();
        FileWriter fw = new FileWriter(f, true);
//        FileReader fr = new FileReader()
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("<?xml version='1.0' encoding='UTF-8'?>");
        bw.write("<filme>");
        bw.write("<codigo>" + codigo + "</codigo>");
        bw.write("<genero>" + genero + "</genero>");
        bw.write("<nome>" + nome + "</nome>");
        bw.write("<duracao>" + duracao + "</duracao>");
        bw.write("<tipo>" + tipo + "</tipo>");
        bw.write("<lancamento>" + lancamento + "</lancamento>");
        bw.write("<locado>" + locado + "</locado>");
        bw.write("</filme>");

        bw.newLine();
        bw.flush();
        fw.close();
        bw.close();

    }
    
  

    public static Filme[] buscarTodos() throws FileNotFoundException, IOException {
        Filme[] filmes = new Filme[100];
        File f = new File("locadora.txt");
        f.createNewFile();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        int cont = 0;
        while (br.ready()) {
            String[] valores = br.readLine().split(";");
            int codigo = Integer.parseInt(valores[0]);
            String nome = valores[1];
            String genero = valores[2];
            int duracao = Integer.parseInt(valores[3]);
            String tipo = valores[4];
            boolean lancamento = Boolean.parseBoolean(valores[5]);
            boolean locado = Boolean.parseBoolean(valores[6]);
            Filme filme = new Filme(codigo, nome, genero, duracao, tipo, lancamento, locado);
            filmes[cont] = filme;
            cont++;

        }
        return filmes;
    }

    public static String[][] buscarTodosSwing() {
        FileReader fr = null;
        String[][] valoresMatriz = new String[20][4];
        try {
            File f = new File("locadora.txt");
            f.createNewFile();
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int cont = 0;
            while (br.ready()) {

                String[] valores = br.readLine().split(";");
                valoresMatriz[cont][0] = (valores[0]);
                valoresMatriz[cont][1] = valores[1];
                valoresMatriz[cont][2] = (valores[2]);
                valoresMatriz[cont][3] = (valores[3]);
                valoresMatriz[cont][4] = (valores[4]);
                valoresMatriz[cont][5] = (valores[5]);
                valoresMatriz[cont][6] = (valores[6]);
                cont++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Filme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Filme.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Filme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valoresMatriz;
    }

}
