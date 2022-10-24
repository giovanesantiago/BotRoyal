package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class TelaMainForm extends JFrame {

    // Tamanho jLabel
    private static final int TAMANHO_JLABEL_w = 70;
    private static final int TAMANHO_JLABEL_h = 30;
    private static final int TAMANHO_MARGEM = 30;

    // Paineis
    protected JPanel pnlForm;
    // Paines do Formulario
    protected JPanel pnlMessage;
    protected JPanel pnlNumeros;
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
    protected JTextField txtNumeros;
    // Buttons
    protected JButton btnEnviar;
    protected JButton btnLimpar;
    protected JButton btnFechar;
    protected JButton btnFile;
    // Assinatura
    protected JLabel ass;

    // construtor
    public TelaMainForm () {
        this.inicializador();
        this.eventos();
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

        // Adcionando Formulario
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
    }


    // Gerando Painel Formulario
    public JPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new JPanel();
            pnlForm.setLayout(new BorderLayout());
            pnlForm.add(Box.createRigidArea(new Dimension(0,5)));
            pnlForm.setBorder(BorderFactory.createEmptyBorder(TAMANHO_MARGEM,TAMANHO_MARGEM,TAMANHO_MARGEM,TAMANHO_MARGEM));
            // Add componentes formulario
            pnlForm.add(getPnlMessage(), BorderLayout.CENTER);
            pnlForm.add(getPnlNumeros(), BorderLayout.PAGE_END);


        }

        return pnlForm;
    }

    // Gerando Painel Mensagem
    public JPanel getPnlMessage() {
        if(pnlMessage == null) {
            pnlMessage = new JPanel();

            pnlMessage.setLayout(new BoxLayout(pnlMessage, BoxLayout.Y_AXIS));

            lblMessage = new JLabel("Messagem ");
            lblMessage.setMaximumSize(new Dimension(TAMANHO_JLABEL_w,TAMANHO_JLABEL_h));

            txtMessage = new JTextArea();
            txtMessage.setMaximumSize(new Dimension(1100,250));
            txtMessage.setLineWrap(true);
            txtMessage.setBorder(BorderFactory.createLineBorder(Color.BLACK));


            pnlMessage.add(lblMessage);
            pnlMessage.add(txtMessage);

        }

        return pnlMessage;
    }
    // Gerando Painel numeros
    public JPanel getPnlNumeros() {
        if(pnlNumeros == null) {
            pnlNumeros = new JPanel();

            pnlNumeros.setLayout(new FlowLayout());

            lblNumeros = new JLabel("Telefones");
            lblNumeros.setMaximumSize(new Dimension(TAMANHO_JLABEL_w,TAMANHO_JLABEL_h));

            txtNumeros = new JTextField(30);
            txtNumeros.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            btnFile = new JButton("Carregar .txt");


            pnlNumeros.add(lblNumeros);
            pnlNumeros.add(txtNumeros);
            pnlNumeros.add(btnFile);
        }

        return pnlNumeros;
    }

    // Gerando Rodape
    public JPanel getPnlRodape() {
        if(pnlRodape == null) {
            pnlRodape = new JPanel(new BorderLayout());

            pnlRodape.add(getPnlButtons(), BorderLayout.CENTER);
            pnlRodape.add(getPnlAssinaruta(), BorderLayout.PAGE_END);

        }
        return pnlRodape;
    }

    // Gerando painel de buttons
    public JPanel getPnlButtons() {
        if(pnlButtons == null) {
            pnlButtons = new JPanel();

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

            ass = new JLabel("Diretos reservados a Giovane Santiago");

            pnlAssinaruta.add(ass);
        }
        return pnlAssinaruta;
    }

    // Funções dos Buttons
    protected abstract void btnFileClick(ActionEvent event);
    protected abstract void btnEnviarClick(ActionEvent event);
    protected abstract void btnLimparClick(ActionEvent event);
    protected abstract void btnFecharClick(ActionEvent event);
    private void eventos() {

        btnFile.addActionListener(this::btnFileClick);
        btnEnviar.addActionListener(this::btnEnviarClick);
        btnLimpar.addActionListener(this::btnLimparClick);
        btnFechar.addActionListener(this::btnFecharClick);
    }
}
