package sysmatricula.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sysmatricula.grafico.*;
import sysmatricula.logica.*;

public class AmbienteGrafico extends JFrame {

    public LinkedList<String> matriculaPura = new LinkedList<String>();
    public LinkedList<String> digitoPuro = new LinkedList<String>();
    public LinkedList<String> matriculaAgregada = new LinkedList<String>();
    public LinkedList<String> digitoGerado = new LinkedList<String>();
    public LinkedList<String> matriculaGerada = new LinkedList<String>();
    public String gravar;
    public String pastaResultado;
    public Boolean flagBtn;

    public AmbienteGrafico() {

        flagBtn = false;

        setTitle("SysMatricula - XPTO");
        setSize(640, 200);

        JButton btSelecionarArquivo = new JButton("Selecionar Arquivo");
        JButton btVerificarMatricula = new JButton("Verificar Matricula");
        JButton btGerarDV = new JButton("Gerar Dígito Verificador");
        JPanel panel = new JPanel();
        panel.add(btSelecionarArquivo);
        panel.add(btVerificarMatricula);
        panel.add(btGerarDV);

        this.getContentPane().add(panel);

        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btSelecionarArquivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("botao Selecionar Arquivo");
                Seletor selecionar = new Seletor();
                selecionar.selecionarArquivo();
                System.out.println(selecionar.getArquivoSelecionado());

                Verificador arquivo = new Verificador();
                arquivo.verificarArquivo(selecionar.getArquivoSelecionado());

                matriculaPura = arquivo.getMatriculaSemDV();
                digitoPuro = arquivo.getDigitoVerificador();

                matriculaAgregada.clear();
                gravar = "";
                for (int i = 0; i <= (matriculaPura.size() - 1); i++) {

                    if (digitoPuro.get(i).isEmpty()) {
                        gravar = (matriculaPura.get(i));
                    } else {
                        gravar = (matriculaPura.get(i) + "-" + digitoPuro.get(i));
                    }
                    matriculaAgregada.add(gravar);
                }

                System.out.println("Matricula Agregada ===> " + matriculaAgregada.toString());

                flagBtn = true;

            }
        });
        btVerificarMatricula.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("botao Verificar Matricula");
                if (flagBtn == true) {

                    Seletor selecionar = new Seletor();
                    selecionar.selecionarPasta();
                    pastaResultado = selecionar.getCaminhoPastaResultado();
                    System.out.println(pastaResultado);

                } else {
                    JOptionPane.showMessageDialog(null, "ERRO: O arquivo ainda não foi selecionado.\nClick no Botão Selecionar Arquivo.");

                }

            }
        });

        btGerarDV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("botao Gerar Digito Verificador");

                if (flagBtn == true) {
                    Seletor selecionar = new Seletor();
                    selecionar.selecionarPasta();
                    pastaResultado = selecionar.getCaminhoPastaResultado();
                    System.out.println(pastaResultado);

                    System.out.println("getMatriculaSemDV --------- " + matriculaPura.toString());

                    CalcularDigitoVerificador calc = new CalcularDigitoVerificador();
                    digitoGerado = calc.calcularDV(matriculaPura);

                    System.out.println("Digito Gerado -> " + digitoGerado.toString());

                    matriculaGerada.clear();
                    gravar = "";
                    for (int i = 0; i <= (matriculaPura.size() - 1); i++) {

                        if (digitoPuro.get(i).isEmpty()) {
                            gravar = matriculaPura.get(i) + "-" + digitoGerado.get(i);
                            matriculaGerada.add(gravar);
                        }
                    }

                    System.out.println("Matricula Gerada -> " + matriculaGerada.toString());

                    CriarArquivo gravando = new CriarArquivo(pastaResultado + "matriculasComDV.txt", matriculaGerada);

                } else {
                    JOptionPane.showMessageDialog(null, "ERRO: O arquivo ainda não foi selecionado.\nClick no Botão Selecionar Arquivo.");

                }

            }
        });

    }

}
