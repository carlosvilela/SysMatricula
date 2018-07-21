package sysmatricula.logica;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LerArquivo {
    
    public LinkedList<String> matricula = new LinkedList<String>();
    private File arquivo;

public void LerArquivoSelecionado(String arquivoSelecionado){
    
    setArquivo(arquivoSelecionado);
  
 
    try{
        FileReader arquivo = new FileReader(this.arquivo);
        BufferedReader ler = new BufferedReader(arquivo);
        System.out.println(this.arquivo.getAbsolutePath());

        int i;
        i=0;
        this.matricula.add(ler.readLine());
        while(this.matricula.get(i) != null){
        this.matricula.add(ler.readLine());
        System.out.println(this.matricula.get(i));
        i=i+1;
        }
        this.matricula.remove(i);
        
       
        arquivo.close();

    }catch(IOException e){
        System.out.println(e);
    }

    
    
}    


    public String getArquivo() {
        return arquivo.getAbsolutePath();
    }

    public void setArquivo(String arquivo) {
        this.arquivo = new File(arquivo);
    }
}
