package calculadora;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Calculadoraswing extends JFrame implements ActionListener {

    private JTextField display;

    private JButton[] botoesNumeros;

    private JButton[] botoesOperadores;

    private JButton botaoLimpar;

    private JButton botaoResultado;

    private double primeiroNumero;

    private String operador;



    public Calculadoraswing() {

        setTitle("Calculadora");

        setSize(300, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        display = new JTextField();

        display.setEditable(false);

        add(display, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel();

        painelBotoes.setLayout(new GridLayout(4, 4));

        botoesNumeros = new JButton[10];

        for (int i = 0; i < 10; i++) {

            botoesNumeros[i] = new JButton(Integer.toString(i));

            botoesNumeros[i].addActionListener(this);

            painelBotoes.add(botoesNumeros[i]);

        }

        botoesOperadores = new JButton[4];

        botoesOperadores[0] = new JButton("+");

        botoesOperadores[1] = new JButton("-");

        botoesOperadores[2] = new JButton("*");

        botoesOperadores[3] = new JButton("/");

        for (JButton botao : botoesOperadores) {

            botao.addActionListener(this);

            painelBotoes.add(botao);

        }

        botaoResultado = new JButton("=");

        botaoResultado.addActionListener(this);

        painelBotoes.add(botaoResultado);

        botaoLimpar = new JButton("C");

        botaoLimpar.addActionListener(this);

        painelBotoes.add(botaoLimpar);



        add(painelBotoes, BorderLayout.CENTER);



        setVisible(true);

    }



    @Override

    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if (comando.equals("C")) {

            display.setText("");

        } else if (comando.equals("=")) {

            double segundoNumero = Double.parseDouble(display.getText());

            double resultado = 0;

            switch (operador) {

                case "+":

                    resultado = primeiroNumero + segundoNumero;

                    break;

                case "-":

                    resultado = primeiroNumero - segundoNumero;

                    break;

                case "*":

                    resultado = primeiroNumero * segundoNumero;

                    break;

                case "/":

                    if (segundoNumero != 0) {

                        resultado = primeiroNumero / segundoNumero;

                    } else {

                        JOptionPane.showMessageDialog(this, "Não é possível dividir por zero!", "Erro", JOptionPane.ERROR_MESSAGE);

                    }

                    break;

            }

            display.setText(Double.toString(resultado));

        } else {

            display.setText(display.getText() + comando);

        }

        if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {

            primeiroNumero = Double.parseDouble(display.getText());

            operador = comando;

            display.setText("");

        }

    }



    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override

            public void run() {

                new Calculadoraswing();

            }

        });

    }

}
