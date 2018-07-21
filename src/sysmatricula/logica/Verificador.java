package sysmatricula.logica;

import java.io.File;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Verificador extends LerArquivo {

    public Boolean verificarArquivo(String arquivo) {
        LinkedList<String> matriculaSemDV = new LinkedList<String>();
        LinkedList<String> digitoVerificador = new LinkedList<String>();

        LerArquivoSelecionado(arquivo);
        matriculaSemDV = getMatriculaSemDV();
        digitoVerificador = getDigitoVerificador();

        System.out.println("matriculaSemDV ->> " + matriculaSemDV.toString());
        System.out.println("digitoVerificador ->> " + digitoVerificador.toString());

        for (int i = 0; i <= (matriculaSemDV.size() - 1); i++) {

            if (matriculaSemDV.get(i).equals("")) {
                JOptionPane.showMessageDialog(null, "ERRO:\nHá um registro incoerente,\nNão há matricula, apenas dígito verificador (\" -" + matriculaSemDV.get(i).toString() + digitoVerificador.get(i) + " \"), talvez tenha sido registrado por equivoco na sintaxe,\n este será excluido da lista de verificação.\ncaso não queira continuar, atualize o arquivo e tente novamente\neste erro não irá interferir no processo, click OK para continuar e prosseguir.");
                matriculaSemDV.remove(i);
                digitoVerificador.remove(i);

                setMatriculaSemDV(matriculaSemDV);
                setDigitoVerificador(digitoVerificador);

                System.out.println("==getMatriculaSemDV== >>> " + getMatriculaSemDV().toString());
                System.out.println("==getDigitoVerificador== >>> " + getDigitoVerificador().toString());
            }

        }

        if (matriculaSemDV.size() == digitoVerificador.size()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERRO FATAL:\nErro na leitura do arquivo.\nhouve inconsistencia de dados, entre em contato com o Desenvolvedor");
            return false;

        }

    }
}
