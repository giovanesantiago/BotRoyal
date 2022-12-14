package view;

import controller.Bot.ControllerBot;
import controller.File.ControllerFile;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TelaMain extends TelaMainForm{

    ArrayList<String> telefones;
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
        telefones = controllerFile.leitura();
        if(telefones != null){
            System.out.println(telefones);
            if(!message.equals("")) {
                ControllerBot controllerBot = new ControllerBot(telefones, message);
                controllerBot.inciarBot();
                System.out.println(message);
            }else {
                JOptionPane.showMessageDialog(null, "Messagem não " +
                        "encontrado", "Error", 0);
            }
        }


        
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
