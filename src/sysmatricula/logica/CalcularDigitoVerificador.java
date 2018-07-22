//+------------------------------------------------------------------+
//|                                   CalcularDigitoVerificador.java |
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
//| Classe CalcularDigitoVerificador                                              |
//+------------------------------------------------------------------+
public class CalcularDigitoVerificador extends LerArquivo { // Herda Classe LerArquivo

//+ Atributos 
    private Integer calcDV;
    private LinkedList<Integer> rascunhoDigitoVerificador = new LinkedList<Integer>();
    private LinkedList<Integer> DigitoVerificadorCalculado = new LinkedList<Integer>();
    private LinkedList<String> DigitoVerificadorConcluido = new LinkedList<String>();
    
//+ Método calcularDV 
    public LinkedList<String> calcularDV(LinkedList<String> matriculaSemDV) {

//+ Realiza os calculos e processos para calcular o Dígito Verificador. 
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
        
            Calculo calc = new Calculo();
            
            String digito;
        for(int i=0; i<=(DigitoVerificadorCalculado.size()-1);i++){
            digito = (calc.convertDecimalParaHexadecimal(DigitoVerificadorCalculado.get(i).intValue()));
        System.out.println("O DIGITO : "+digito);
            
            DigitoVerificadorConcluido.add(digito);
        }
        
        System.out.println("O DIGITO VERIFICADOR E: "+DigitoVerificadorConcluido.toString());
        return DigitoVerificadorConcluido;

    }

}
//+------------------------------------------------------------------+