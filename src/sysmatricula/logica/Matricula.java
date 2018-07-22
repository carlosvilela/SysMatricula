
package sysmatricula.logica;

import java.util.LinkedList;

public class Matricula {

    private LinkedList<String> matricula = new LinkedList<String>();
    private LinkedList<String> matriculaSemDV = new LinkedList<String>();

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
    private LinkedList<String> digitoVerificador = new LinkedList<String>();

    
}
