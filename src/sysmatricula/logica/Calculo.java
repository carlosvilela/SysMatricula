package sysmatricula.logica;

import java.util.LinkedList;

public class Calculo {

    public Calculo() {

    }

    public String convertDecimalParaHexadecimal(Integer valor) {
        String resultado = "";
        LinkedList<Integer> restoDivisao = new LinkedList<Integer>();
        Integer resultadoDivisao = 0;
        System.out.println("Convertendo para Hexadecimal -> valor em decimal = " + valor);

        resultadoDivisao = valor / 16;

        if (resultadoDivisao >= 16) {
            System.out.println("Convertendo para Hexadecimal -> resultadoDivisao = " + valor);
            restoDivisao.add((valor % 16));
            System.out.println("Convertendo para Hexadecimal -> restoDivisao = " + restoDivisao.toString());
            valor = resultadoDivisao;
            System.out.println("Convertendo para Hexadecimal -> valor em decimal = " + valor);

            while (resultadoDivisao >= 16) {

                resultadoDivisao = valor / 16;
                System.out.println("Convertendo para Hexadecimal -> resultadoDivisao = " + valor);
                restoDivisao.add((valor % 16));
                System.out.println("Convertendo para Hexadecimal -> restoDivisao = " + restoDivisao.toString());
                valor = resultadoDivisao;
                System.out.println("Convertendo para Hexadecimal -> valor em decimal = " + valor);
            }

        }
            restoDivisao.add((valor));
            System.out.println("Convertendo para Hexadecimal -> restoDivisao fINAL = " + restoDivisao.toString());
            return resultado;

    }
}
