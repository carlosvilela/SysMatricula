//+------------------------------------------------------------------+
//|                                                SysMatricula.java |
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
//| Classe Calculo                                              |
//+------------------------------------------------------------------+
public class Calculo {

 //+ Método Construtor 
   public Calculo() {

    }

//+ Método convertDecimalParaHexadecimal 
    public String convertDecimalParaHexadecimal(Integer valor) {
 
//+ Realiza a conversão de Decimal para Hexadecimal
        String resultado = "";
        LinkedList<Integer> restoDivisao = new LinkedList<Integer>();
        Integer resultadoDivisao = 0;
        //System.out.println("Convertendo para Hexadecimal -> valor em decimal = " + valor);

        resultadoDivisao = valor / 16;

        if (resultadoDivisao >= 16) {
            //System.out.println("Convertendo para Hexadecimal -> resultadoDivisao = " + valor);
            restoDivisao.add((valor % 16));
            //System.out.println("Convertendo para Hexadecimal -> restoDivisao = " + restoDivisao.toString());
            valor = resultadoDivisao;
            //System.out.println("Convertendo para Hexadecimal -> valor em decimal = " + valor);

            while (resultadoDivisao >= 16) {

                resultadoDivisao = valor / 16;
                //System.out.println("Convertendo para Hexadecimal -> resultadoDivisao = " + valor);
                restoDivisao.add((valor % 16));
                //System.out.println("Convertendo para Hexadecimal -> restoDivisao = " + restoDivisao.toString());
                valor = resultadoDivisao;
                //System.out.println("Convertendo para Hexadecimal -> valor em decimal = " + valor);
            }

        }
        restoDivisao.add((valor));
        //System.out.println("Convertendo para Hexadecimal -> restoDivisao fINAL = " + restoDivisao.toString());

        for (int i = (restoDivisao.size() - 1); i >= 0; i--) {

            if (restoDivisao.get(i).intValue() == 10) {
                resultado=resultado+"A";

            } else {
                if (restoDivisao.get(i).intValue() == 11) {
                resultado=resultado+"B";
                } else {
                    if (restoDivisao.get(i).intValue() == 12) {
                resultado=resultado+"C";
                    } else {
                        if (restoDivisao.get(i).intValue() == 13) {
                resultado=resultado+"D";
                        } else {
                            if (restoDivisao.get(i).intValue() == 14) {
                resultado=resultado+"E";
                            } else {
                                if (restoDivisao.get(i).intValue() == 15) {
                resultado=resultado+"F";
                                } else {
                resultado=resultado+Integer.toString(restoDivisao.get(i));

                                }

                            }

                        }

                    }

                }
            }

        }
        //System.out.println("Convertendo para Hexadecimal -> RESULTADO = " + resultado);
        return resultado;

    }

}
//+------------------------------------------------------------------+