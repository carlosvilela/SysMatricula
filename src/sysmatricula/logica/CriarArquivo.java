//+------------------------------------------------------------------+
//|                                                SysMatricula.java |
//|                           Copyright 2018, Carlos Bezerra Vilela. |
//|                     https://github.com/carlosvilela/SysMatricula |
//+------------------------------------------------------------------+
//+------------------------------------------------------------------+
//| pacote/diretório da Classe                                       |
//+------------------------------------------------------------------+
package sysmatricula.logica;

//+------------------------------------------------------------------+
//| Bibliotecas Necessárias                                          |
//+------------------------------------------------------------------+
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;

//+------------------------------------------------------------------+
//| Classe CriarArquivo                                              |
//+------------------------------------------------------------------+
public class CriarArquivo {

//+ Atributos 
    private File gerarArquivo;

//+ Método Construtor 
    public CriarArquivo(String nomeArquivo, LinkedList<String> conteudo) {

//+ Criar arquivo de Resultados conforme o caminho e conteúdo 
        gerarArquivo = new File(nomeArquivo);

        if (!gerarArquivo.exists()) {
            try {

                FileWriter arquivo = new FileWriter(gerarArquivo); // cria o arquivo
                PrintWriter escreverArquivo = new PrintWriter(arquivo); // escreve no arquivo

                for (int i = 0; i <= (conteudo.size() - 1); i++) {

                    escreverArquivo.println(conteudo.get(i));
                }

                arquivo.close();

                JOptionPane.showMessageDialog(null, "Arquivo Gerado.\n" + nomeArquivo);

            } catch (Exception e) {
                System.out.println("ERRO: " + e);
                JOptionPane.showMessageDialog(null, "ERRO: Não foi possivel criar o arquivo.\n" + nomeArquivo + "\nVerifique seus privilégios de usuário.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRO: Não foi possível gerar o arquivo, pois ele já existe na pasta.\n" + nomeArquivo);

        }

    }

}
//+------------------------------------------------------------------+