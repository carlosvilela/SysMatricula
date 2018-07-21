package sysmatricula.logica;

import java.io.File;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Verificador extends LerArquivo {

    public Boolean verificarArquivo(String arquivo) {
        LinkedList<String> matriculaSemDV = new LinkedList<String>();
        LinkedList<String> digitoVerificador = new LinkedList<String>();
        
        LerArquivoSelecionado(arquivo);
        matriculaSemDV = getMatriculaSemDV();
        digitoVerificador = getDigitoVerificador();
        
        System.out.println("matriculaSemDV ->> "+matriculaSemDV.toString());
        System.out.println("digitoVerificador ->> "+digitoVerificador.toString());
        
        if (matriculaSemDV.size() == digitoVerificador.size()){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "ERRO FATAL:\nErro na leitura do arquivo.\nhouve inconsistencia de dados, entre em contato com o Desenvolvedor");
            return false;
            
        }
        
    }

}
