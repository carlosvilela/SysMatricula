package sysmatricula.logica;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class CriarArquivo {
    
    private File gerarArquivo;

    public CriarArquivo(String nomeArquivo, LinkedList<String> conteudo) {
gerarArquivo = new File(nomeArquivo);

if(!gerarArquivo.exists()){
        try {

            FileWriter arquivo = new FileWriter(gerarArquivo); // cria o arquivo
            PrintWriter escreverArquivo = new PrintWriter(arquivo); // escreve no arquivo

            for (int i = 0; i <= (conteudo.size() - 1); i++) {

                escreverArquivo.println(conteudo.get(i));
            }

            arquivo.close();

            JOptionPane.showMessageDialog(null, "Arquivo Gerado.\n"+nomeArquivo);

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
         JOptionPane.showMessageDialog(null, "ERRO: Não foi possivel criar o arquivo.\n"+nomeArquivo+"\nVerifique seus privilégios de usuário.");
        }
}else{
         JOptionPane.showMessageDialog(null, "ERRO: Não foi possível gerar o arquivo, pois ele já existe na pasta.\n"+nomeArquivo);
   
}

    }


}
