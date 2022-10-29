package controller.File;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ControllerFile {

    private String diretorio;
    private ArrayList<String> telefone;

    public ControllerFile(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public ArrayList<String> leitura() {
        telefone = new ArrayList<>();
        try{
            // Pegando arquivo
            FileReader arquivo = new FileReader(this.getDiretorio());
            // Lendo arquivo
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = "";
            try{
                // Adicionando conteudo linha por linha
                linha = lerArquivo.readLine();
                while (linha!=null) {
                    telefone.add(linha);
                    linha = lerArquivo.readLine();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não " +
                        "encontrado", "Error", 0);
                return null;
            }

        } catch (FileNotFoundException e) {

            JOptionPane.showMessageDialog(null, "Arquivo não " +
                    "encontrado", "Error", 0);
            return null;
        }
        
        return telefone;


    }

    public void Corrigir(ArrayList<String> telefones) {


        try {
            FileWriter arq = new FileWriter(diretorio);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(telefones);
            gravarArq.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


