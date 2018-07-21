package sysmatricula.logica;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LerArquivo {
    
    private LinkedList<String> matricula = new LinkedList<String>();
    private LinkedList<String> matriculaSemDV = new LinkedList<String>();
    private LinkedList<String> digitoVerificador = new LinkedList<String>();

    private File arquivo;
    
public String getArquivo() {
    return arquivo.getAbsolutePath();
    }

public void setArquivo(String arquivo) {
        this.arquivo = new File(arquivo);
    }


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
    
    
    desagregarMatricula(this.matricula);
    
    }

public void desagregarMatricula (LinkedList<String> matricula){
    matricula = new LinkedList<String>();
    matricula = this.matricula;
    
    for(int i=0; i<=(matricula.size()-1); i++){
        System.out.println(">>> "+matricula.get(i));
        
        System.out.println(">>>numChar "+matricula.get(i).length());

        for(int j=0; j<=(matricula.get(i).length()-1); j++){
        System.out.println("//"+matricula.get(i).charAt(j)+"//");
            
        }
        
        
        
    }
    
    
}




}
