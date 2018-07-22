package sysmatricula.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sysmatricula.grafico.Seletor;
import sysmatricula.logica.*;

public class AmbienteGrafico extends JFrame {

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
                
                
                CalcularDigitoVerificador calc = new CalcularDigitoVerificador();
                System.out.println("getMatriculaSemDV --------- "+arquivo.getMatriculaSemDV().toString());
                calc.calcularDV(arquivo.getMatriculaSemDV());

            }
        });

        btVerificarMatricula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("botao Verificar Matricula");
                Seletor selecionar = new Seletor();
                selecionar.selecionarPasta();
                System.out.println(selecionar.getCaminhoPastaResultado());

            }
        });

        btGerarDV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("botao Gerar Digito Verificador");
                Seletor selecionar = new Seletor();
                selecionar.selecionarPasta();
                System.out.println(selecionar.getCaminhoPastaResultado());

            }
        });

    }

}
