package sysmatricula.logica;

import java.io.File;
import java.util.LinkedList;

public class Verificador extends LerArquivo {

    public void verificarArquivo(String arquivo) {
        LinkedList<String> matriculaSemDV = new LinkedList<String>();
        LinkedList<String> digitoVerificador = new LinkedList<String>();
        
        LerArquivoSelecionado(arquivo);
        matriculaSemDV = getMatriculaSemDV();
        digitoVerificador = getDigitoVerificador();
        
        System.out.println("matriculaSemDV ->> "+matriculaSemDV.toString());
        System.out.println("digitoVerificador ->> "+digitoVerificador.toString());
        
        
        
    }

}
