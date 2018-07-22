package sysmatricula.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sysmatricula.grafico.*;
import sysmatricula.logica.*;

public class AmbienteGrafico extends JFrame {

    public LinkedList<String> matriculaPura = new LinkedList<String>();
    public LinkedList<String> digitoPuro = new LinkedList<String>();
    public LinkedList<String> matriculaAgregada = new LinkedList<String>();
    public LinkedList<String> matriculaGerada = new LinkedList<String>();
    public LinkedList<String> matriculaGravada = new LinkedList<String>();

    public String pastaResultado;

    public AmbienteGrafico() {

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
                matriculaAgregada = arquivo.getMatricula();


            }
        });
            btVerificarMatricula.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("botao Verificar Matricula");
                Seletor selecionar = new Seletor();
                selecionar.selecionarPasta();
                pastaResultado = selecionar.getCaminhoPastaResultado();
                System.out.println(pastaResultado);

                CalcularDigitoVerificador calc = new CalcularDigitoVerificador();

                System.out.println("getMatriculaSemDV --------- " + matriculaPura.toString());
                digitoPuro = calc.calcularDV(matriculaPura);
                
                System.out.println("Matricula --------- " + matriculaAgregada.toString());
                                

                
                String gravar;
                for (int i = 0; i <= (matriculaAgregada.size() - 1); i++) {
                    gravar = (matriculaPura.get(i) + "-" + digitoPuro.get(i));
                        System.out.println("gravar -> "+gravar);
                    matriculaGerada.add(gravar);
                        System.out.println("Matricula Gerada -> "+matriculaGerada.toString());

                    if (matriculaGerada.get(i).equals(matriculaAgregada.get(i))) {
                        matriculaGravada.add((matriculaAgregada.get(i) + " verdadeiro"));
                    } else {
                        gravar = (matriculaAgregada.get(i) + " falso");
                        System.out.println("gravar -> "+gravar);

                        matriculaGravada.add(gravar);
                    }
                }

               

System.out.println("Matricula gerada para gravar -> "+matriculaGravada.toString());
               

            }
        });

        btGerarDV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("botao Gerar Digito Verificador");
                Seletor selecionar = new Seletor();
                selecionar.selecionarPasta();
                pastaResultado = selecionar.getCaminhoPastaResultado();
                System.out.println(pastaResultado);

            }
        });

    }

}
