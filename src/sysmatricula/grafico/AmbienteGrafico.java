//+------------------------------------------------------------------+
//|                                             AmbienteGrafico.java |
//|                           Copyright 2018, Carlos Bezerra Vilela. |
//|                     https://github.com/carlosvilela/SysMatricula |
//+------------------------------------------------------------------+

//+------------------------------------------------------------------+
//| pacote/diretório da Classe                                       |
//+------------------------------------------------------------------+
package sysmatricula.grafico;

//+------------------------------------------------------------------+
//| Bibliotecas Necessárias                                          |
//+------------------------------------------------------------------+
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

//+------------------------------------------------------------------+
//| Classe AmbienteGrafico                                           |
//+------------------------------------------------------------------+
public class AmbienteGrafico extends JFrame {
    
    
//+ Atributos 
    private LinkedList<String> matriculaPura = new LinkedList<String>();
    private LinkedList<String> digitoPuro = new LinkedList<String>();
    private LinkedList<String> matriculaAgregada = new LinkedList<String>();
    private LinkedList<String> digitoGerado = new LinkedList<String>();
    private LinkedList<String> matriculaGerada = new LinkedList<String>();
    private String gravar;
    private String pastaResultado;
    private Boolean flagBtn;

//+ Método Construtor 
    public AmbienteGrafico() {

//+ Criar Janela com os componentes básicos 
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

//+ Ações dos Botões (btSelecionarArquivo)
        btSelecionarArquivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//+ Verificar Integridade dos arquivos e exportar conteúdo para posterior uso

                //System.out.println("botao Selecionar Arquivo");
                Seletor selecionar = new Seletor();
                selecionar.selecionarArquivo();
                //System.out.println(selecionar.getArquivoSelecionado());

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

                //System.out.println("Matricula Agregada ===> " + matriculaAgregada.toString());

                flagBtn = true; //flag que indica se o botão de selecionar arquivo foi executado

            }
        });
        
//+ Ações dos Botões (btVerificarMatricula)
        btVerificarMatricula.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

//+ Selecionar pasta onde será gerado o arquivo de resultado
                //System.out.println("botao Verificar Matricula");
                if (flagBtn == true) { //flag que indica se o botão de selecionar arquivo foi executado

                    Seletor selecionar = new Seletor();
                    selecionar.selecionarPasta();
                    pastaResultado = selecionar.getCaminhoPastaResultado();
                    //System.out.println(pastaResultado);

                    //System.out.println("getMatriculaSemDV --------- " + matriculaPura.toString());

//+ calcular Dígito Verificador e comparar se o D.V. está correto
                    CalcularDigitoVerificador calc = new CalcularDigitoVerificador();
                    digitoGerado = calc.calcularDV(matriculaPura);

                    //System.out.println("Digito Gerado -> " + digitoGerado.toString());
                    //System.out.println("Digito Puro -> " + digitoPuro.toString());

                    matriculaGerada.clear();
                    gravar = "";
                    for (int i = 0; i <= (matriculaPura.size() - 1); i++) {

                        if (digitoPuro.get(i).equals(digitoGerado.get(i))) {
                            gravar = matriculaPura.get(i) + "-" + digitoPuro.get(i) + " verdadeiro";
                            matriculaGerada.add(gravar);
                        } else {
                            gravar = matriculaPura.get(i) + "-" + digitoPuro.get(i) + " falso";
                            matriculaGerada.add(gravar);

                        }
                    }

                    //System.out.println("Matricula Gerada -> " + matriculaGerada.toString());

                    //+ Gerar Resultado em arquivo
                    CriarArquivo gravando = new CriarArquivo(pastaResultado + "matriculasVerificadas.txt", matriculaGerada);

                } else {
                    JOptionPane.showMessageDialog(null, "ERRO: O arquivo ainda não foi selecionado.\nClick no Botão Selecionar Arquivo.");

                }

            }
        });

//+ Ações dos Botões (btGerarDV)
        btGerarDV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//+ Selecionar pasta onde será gerado o arquivo de resultado
                //System.out.println("botao Gerar Digito Verificador");

                if (flagBtn == true) { //flag que indica se o botão de selecionar arquivo foi executado
                    Seletor selecionar = new Seletor();
                    selecionar.selecionarPasta();
                    pastaResultado = selecionar.getCaminhoPastaResultado();
                    //System.out.println(pastaResultado);

                    //System.out.println("getMatriculaSemDV --------- " + matriculaPura.toString());

//+ Calcular e gerar Dígito. Verificador
                    CalcularDigitoVerificador calc = new CalcularDigitoVerificador();
                    digitoGerado = calc.calcularDV(matriculaPura);

                    //System.out.println("Digito Gerado -> " + digitoGerado.toString());

                    matriculaGerada.clear();
                    gravar = "";
                    for (int i = 0; i <= (matriculaPura.size() - 1); i++) {

                        if (digitoPuro.get(i).isEmpty()) {
                            gravar = matriculaPura.get(i) + "-" + digitoGerado.get(i);
                            matriculaGerada.add(gravar);
                        }
                    }

                    //System.out.println("Matricula Gerada -> " + matriculaGerada.toString());

                    //+ Gerar Resultado em arquivo
                    CriarArquivo gravando = new CriarArquivo(pastaResultado + "matriculasComDV.txt", matriculaGerada);

                } else {
                    JOptionPane.showMessageDialog(null, "ERRO: O arquivo ainda não foi selecionado.\nClick no Botão Selecionar Arquivo.");

                }

            }
        });

    }

}
//+------------------------------------------------------------------+