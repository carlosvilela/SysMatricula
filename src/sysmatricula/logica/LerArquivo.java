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
    
    String dV = "-";
    Integer flagDV;
    
    matricula = new LinkedList<String>();
    matricula = this.matricula;
    
    String caracteresSemDV ="";
    String caracteresComDV = "";
    
    for(int i=0; i<=(matricula.size()-1); i++){
        System.out.println(">>> "+matricula.get(i));
        
        System.out.println(">>>numChar "+matricula.get(i).length());
        
        caracteresSemDV= new String();
        caracteresComDV= new String();
        flagDV = 0;

        for(int j=0; j<=(matricula.get(i).length()-1); j++){
            System.out.println("//"+matricula.get(i).charAt(j)+"//");
        
        
    
        //Preencher matriculaSemDV
        System.out.println("j -> "+j);
        System.out.println("flagDV -> "+flagDV);
        if(j>=flagDV){
        
            
        switch (matricula.get(i).charAt(j)){
            
            case('0'):
                caracteresSemDV = caracteresSemDV+'0';
               break;
                
            case('1'):
                caracteresSemDV = caracteresSemDV+'1';
                break;

                                
            case('2'):
                caracteresSemDV = caracteresSemDV+'2';
                break;
                
            case('3'):
                caracteresSemDV = caracteresSemDV+'3';
                break;
                
            case('4'):
                caracteresSemDV = caracteresSemDV+'4';
                break;
                
            case('5'):
                caracteresSemDV = caracteresSemDV+'5';
                break;
                
            case('6'):
                caracteresSemDV = caracteresSemDV+'6';
                break;
                
            case('7'):
                caracteresSemDV = caracteresSemDV+'7';
                break;
                                
            case('8'):
                caracteresSemDV = caracteresSemDV+'8';
                break;
                
            case('9'):
                caracteresSemDV = caracteresSemDV+'9';
                break;

            case('-'):
                flagDV=j+2;
                System.out.println("achou Digito Verificador; j ="+j);

                break;


                
        }
        
        }else{
        
         System.out.println("##### "+matricula.get(i).charAt(j));

        switch (matricula.get(i).charAt(j)){
            
            case('0'):
                caracteresComDV = caracteresComDV+'0';
                flagDV=flagDV+1;
               break;
                
            case('1'):
                caracteresComDV = caracteresComDV+'1';
                flagDV=flagDV+1;
                break;

                                
            case('2'):
                caracteresComDV = caracteresComDV+'2';
                flagDV=flagDV+1;
                break;
                
            case('3'):
                caracteresComDV = caracteresComDV+'3';
                flagDV=flagDV+1;
                break;
                
            case('4'):
                caracteresComDV = caracteresComDV+'4';
                flagDV=flagDV+1;
                break;
                
            case('5'):
                caracteresComDV = caracteresComDV+'5';
                flagDV=flagDV+1;
                break;
                
            case('6'):
                caracteresComDV = caracteresComDV+'6';
                flagDV=flagDV+1;
                break;
                
            case('7'):
                caracteresComDV = caracteresComDV+'7';
                flagDV=flagDV+1;
                break;
                                
            case('8'):
                caracteresComDV = caracteresComDV+'8';
                flagDV=flagDV+1;
                break;
                
            case('9'):
                caracteresComDV = caracteresComDV+'9';
                flagDV=flagDV+1;
                break;

            case('a'):
            case('A'):
                caracteresComDV = caracteresComDV+'A';
                flagDV=flagDV+1;
                break;

            case('b'):
            case('B'):
                caracteresComDV = caracteresComDV+'B';
                flagDV=flagDV+1;
                break;

            case('c'):
            case('C'):
                caracteresComDV = caracteresComDV+'C';
                flagDV=flagDV+1;
                break;

            case('d'):
            case('D'):
                caracteresComDV = caracteresComDV+'D';
                flagDV=flagDV+1;
                break;
 
            case('e'):
            case('E'):
                caracteresComDV = caracteresComDV+'E';
                flagDV=flagDV+1;
                break;

            case('f'):
            case('F'):
                caracteresComDV = caracteresComDV+'F';
                flagDV=flagDV+1;
                break;
                

        }
            
            
        }
        
        System.out.println("caracteresSemDV -> "+caracteresSemDV);
                
        System.out.println("caracteresComDV -> "+caracteresComDV);
        
        }

        if(!caracteresSemDV.isEmpty()){
        matriculaSemDV.add(caracteresSemDV);
        }

        if(!caracteresComDV.isEmpty()){
        digitoVerificador.add(caracteresComDV);
        }
        
//        System.out.println("matriculaSemDV["+i+"] = "+matriculaSemDV.get(i));
//        System.out.println("digitoVerificador["+i+"] = "+digitoVerificador.get(i));
        System.out.println("flagDV = "+flagDV);

        
    }
    
    
}




}
