package controller;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
                telefone.add("erro");
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Error", 0);
            }

        } catch (FileNotFoundException e) {
            telefone.add("erro");
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Error", 0);
        }

        if(telefone.contains("Erro")){
            return null;
        } else {
            return telefone;
        }

    }
}


