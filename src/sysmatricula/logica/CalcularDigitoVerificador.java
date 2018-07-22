package sysmatricula.logica;

import java.util.LinkedList;

public class CalcularDigitoVerificador extends LerArquivo {

    public Integer calcDV;
    private LinkedList<Integer> rascunhoDigitoVerificador = new LinkedList<Integer>();

    public void calcularDV(LinkedList<String> matriculaSemDV) {

        setMatriculaSemDV(matriculaSemDV);
        System.out.println(">>>> " + getMatriculaSemDV().toString());

        for (int i = 0; i <= (getMatriculaSemDV().size() - 1); i++) {

            calcDV = 0;

            for (int j = 0; j <= (getMatriculaSemDV().get(i).length() - 1); j++) {

                rascunhoDigitoVerificador.add(Integer.parseInt(String.valueOf(getMatriculaSemDV().get(i).charAt(j))));
                
                //calcDV

            }

            System.out.println("rascunhoDigitoVerificador ====>>> " + rascunhoDigitoVerificador.toString());
            rascunhoDigitoVerificador.clear();

        }

    }

}
