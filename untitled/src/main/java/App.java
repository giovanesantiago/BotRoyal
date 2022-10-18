import view.TelaMain;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaMain telaMain = new TelaMain();
            telaMain.setVisible(true);
        });
    }
}
