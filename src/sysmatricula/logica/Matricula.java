//+------------------------------------------------------------------+
//|                                                   Matricula.java |
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
import java.util.LinkedList;

//+------------------------------------------------------------------+
//| Classe Matricula                                              |
//+------------------------------------------------------------------+
public class Matricula {

//+ Atributos 
    private LinkedList<String> matricula = new LinkedList<String>();
    private LinkedList<String> matriculaSemDV = new LinkedList<String>();
    private LinkedList<String> digitoVerificador = new LinkedList<String>();

//+ Métodos Set e Get 
    public LinkedList<String> getMatricula() {
        return matricula;
    }

    public void setMatricula(LinkedList<String> matricula) {
        this.matricula = matricula;
    }

    public LinkedList<String> getMatriculaSemDV() {
        return matriculaSemDV;
    }

    public void setMatriculaSemDV(LinkedList<String> matriculaSemDV) {
        this.matriculaSemDV = matriculaSemDV;
    }

    public LinkedList<String> getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(LinkedList<String> digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }
    
}
//+------------------------------------------------------------------+