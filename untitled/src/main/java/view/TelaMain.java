package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;

public class TelaMain extends TelaMainForm{
    @Override
    protected void btnFileClick(ActionEvent event) {
        JFileChooser ch = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione apenas txt", "txt");

        ch.setFileFilter(filter);

        int retorno = ch.showOpenDialog(null);

        if(retorno == JFileChooser.APPROVE_OPTION) {
            String diretorio = ch.getSelectedFile().getAbsolutePath();
            txtNumeros.setText(diretorio);
        }
    }

    @Override
    protected void btnEnviarClick(ActionEvent event) {
        String diretorio = txtNumeros.getText();
        System.out.println(diretorio);
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
