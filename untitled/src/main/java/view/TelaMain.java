package view;

import controller.ControllerFile;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TelaMain extends TelaMainForm{
    ArrayList<String> telefone;
    String message;
    String diretorio;
    @Override
    protected void btnFileClick(ActionEvent event) {
        JFileChooser ch = new JFileChooser();


        FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione apenas txt", "txt");

        ch.setFileFilter(filter);

        int retorno = ch.showOpenDialog(null);

        if(retorno == JFileChooser.APPROVE_OPTION) {
            diretorio = ch.getSelectedFile().getAbsolutePath();
            txtNumeros.setText(diretorio);
        }

    }

    @Override
    protected void btnEnviarClick(ActionEvent event) {
        String diretorio = txtNumeros.getText();
        ControllerFile controllerFile = new ControllerFile(diretorio);
        message = txtMessage.getText();
        telefone = controllerFile.leitura();
        System.out.println(message);
        System.out.println(telefone);

    }

    @Override
    protected void btnLimparClick(ActionEvent event) {
        txtMessage.setText("");
        txtNumeros.setText("");
    }

    @Override
    protected void btnFecharClick(ActionEvent event) {
        this.setVisible(false);
        this.dispose();
    }
}
