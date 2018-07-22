package sysmatricula.logica;

import java.util.LinkedList;

public class CalcularDigitoVerificador extends LerArquivo {

    public Integer calcDV;
    private LinkedList<Integer> rascunhoDigitoVerificador = new LinkedList<Integer>();
    private LinkedList<Integer> DigitoVerificadorCalculado = new LinkedList<Integer>();

    public void calcularDV(LinkedList<String> matriculaSemDV) {

        setMatriculaSemDV(matriculaSemDV);
        System.out.println(">>>> " + getMatriculaSemDV().toString());

        for (int i = 0; i <= (getMatriculaSemDV().size() - 1); i++) {

            calcDV = 0;

            for (int j = 0; j <= (getMatriculaSemDV().get(i).length() - 1); j++) {

                rascunhoDigitoVerificador.add(Integer.parseInt(String.valueOf(getMatriculaSemDV().get(i).charAt(j))));

                calcDV = calcDV + (Integer.parseInt(String.valueOf(getMatriculaSemDV().get(i).charAt(j))) * (getMatriculaSemDV().get(i).length() + 1 - j));
                System.out.println("CalcDV ===> " + calcDV);
            }
            
            System.out.println("rascunhoDigitoVerificador ====>>> " + rascunhoDigitoVerificador.toString());
            
            DigitoVerificadorCalculado.add( (calcDV%16) );
            
            System.out.println("DigitoVerificadorCalculado ====>>> " + DigitoVerificadorCalculado.toString());
            
            rascunhoDigitoVerificador.clear();

        }

    }

}
