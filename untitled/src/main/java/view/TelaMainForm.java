package view;

import javax.swing.*;
import java.awt.*;

public abstract class TelaMainForm extends JFrame {

    // Tamanho jLabel
    private static final int TAMANHO_JLABEL_w = 70;
    private static final int TAMANHO_JLABEL_h = 30;

    // Paineis
    protected JPanel pnlForm;
    protected JPanel pnlRodape;
    // Paineis para Rodape
    protected JPanel pnlButtons;
    protected JPanel pnlAssinaruta;

    // Campos
    // mensagem a ser enviada
    protected JLabel lblMessage;
    protected JTextArea txtMessage;
    // Lista de numeros
    protected JLabel lblNumeros;
    protected JTextArea txtNumeros;
    // Buttons
    protected JButton btnEnviar;
    protected JButton btnLimpar;
    protected JButton btnFechar;
    // Assinatura
    protected JLabel ass;

    // construtor
    public TelaMainForm () {
        this.inicializador();
    }

    private void inicializador() {
        // Titulo
        this.setTitle("Robo Royal ");
        // Tamanho
        this.setSize(640, 480);
        // Finalizar aplicação ao fechar
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Não aumentar a tela
        this.setResizable(false);
        // Distribuindo componentes com BorderLayout
        this.getContentPane().setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        // Adcionando Formulario
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
    }


    // Gerando Painel Formulario
    public JPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new JPanel();
            pnlForm.setLayout(new BoxLayout(pnlForm, BoxLayout.Y_AXIS));
            pnlForm.setBackground(Color.BLACK);


            // Criando Campos
            // Messagem
            lblMessage = new JLabel("Messagem ");
            lblMessage.setMaximumSize(new Dimension(TAMANHO_JLABEL_w,TAMANHO_JLABEL_h));
            lblMessage.setForeground(Color.WHITE);
            txtMessage = new JTextArea();
            txtMessage.setMaximumSize(new Dimension(1100,100));
            txtMessage.setLineWrap(true);



            /*txtMessage.setBackground(Color.GRAY);*/

            // Numeros
            lblNumeros = new JLabel("Telefones");
            lblNumeros.setMaximumSize(new Dimension(TAMANHO_JLABEL_w,TAMANHO_JLABEL_h));
            lblNumeros.setForeground(Color.WHITE);

            txtNumeros = new JTextArea();
            txtNumeros.setMaximumSize(new Dimension(1100,200));
            txtNumeros.setLineWrap(true);

            /*txtNumeros.setBackground(Color.GRAY);*/

            pnlForm.add(lblMessage);
            pnlForm.add(Box.createRigidArea(new Dimension(0,5)));
            pnlForm.add(txtMessage);
            pnlForm.add(lblNumeros);
            pnlForm.add(txtNumeros);
            pnlForm.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));






        }

        return pnlForm;
    }

    // Gerando Rodape
    public JPanel getPnlRodape() {
        if(pnlRodape == null) {
            pnlRodape = new JPanel(new BorderLayout());
            pnlRodape.setBackground(Color.BLACK);
            pnlRodape.add(getPnlButtons(), BorderLayout.CENTER);
            pnlRodape.add(getPnlAssinaruta(), BorderLayout.PAGE_END);

        }
        return pnlRodape;
    }

    // Gerando painel de buttons
    public JPanel getPnlButtons() {
        if(pnlButtons == null) {
            pnlButtons = new JPanel();
            pnlButtons.setBackground(Color.BLACK);
            pnlButtons.setLayout(new FlowLayout());

            // Criando Buttons
            btnEnviar = new JButton("Ligar Robo");
            btnLimpar = new JButton("Limpar");
            btnLimpar.setBackground(Color.RED);
            btnFechar = new JButton("Cancelar");

            pnlButtons.add(btnEnviar);
            pnlButtons.add(btnLimpar);
            pnlButtons.add(btnFechar);

        }
        return pnlButtons;
    }

    // Painel para assinatura
    public JPanel getPnlAssinaruta() {
        if(pnlAssinaruta == null) {
            pnlAssinaruta = new JPanel();
            pnlAssinaruta.setBackground(Color.BLACK);

            ass = new JLabel("Diretos reservados a Giovane Santiago");

            pnlAssinaruta.add(ass);
        }
        return pnlAssinaruta;
    }
}
