package sysmatricula.logica;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class LerArquivo extends Matricula {

    private File arquivo;

    public String getArquivo() {
        return arquivo.getAbsolutePath();
    }

    public void setArquivo(String arquivo) {
        this.arquivo = new File(arquivo);
    }

    public void LerArquivoSelecionado(String arquivoSelecionado) {

        setArquivo(arquivoSelecionado);

        try {
            if (this.arquivo.exists()) {

                FileReader arquivo = new FileReader(this.arquivo);
                BufferedReader ler = new BufferedReader(arquivo);
                System.out.println(this.arquivo.getAbsolutePath());

                int i;
                i = 0;

                getMatricula().add(ler.readLine());
                while (getMatricula().get(i) != null) {
                    getMatricula().add(ler.readLine());

                    System.out.println(getMatricula().get(i));
                    i = i + 1;
                }

                getMatricula().remove(i);
                arquivo.close();

            } else {
                JOptionPane.showMessageDialog(null, "ERRO FATAL:\nErro na leitura do arquivo.\nhouveram divergencias,\n verifique se o arquivo existe ou se você precisa de prilégios de usuário para acessar a pasta ou arquivo.\n realize a operação novamente para prosseguir com o processo");

            }

        } catch (IOException e) {
            System.out.println(e);
        }

        desagregarMatricula(getMatricula());
    }

    public void desagregarMatricula(LinkedList<String> matricula) {

        String dV = "-";
        Integer indexDV;
        Boolean bFlagDV;
        Boolean bERR;

        matricula = new LinkedList<String>();
        matricula = getMatricula();

        String caracteresSemDV = "";
        String caracteresComDV = "";

        for (int i = 0; i <= (matricula.size() - 1); i++) {
            System.out.println(">>> " + matricula.get(i));

            System.out.println(">>>numChar " + matricula.get(i).length());

            caracteresSemDV = new String();
            caracteresComDV = new String();
            indexDV = 0;
            bFlagDV = false;
            bERR = false;

            for (int j = 0; j <= (matricula.get(i).length() - 1); j++) {
                System.out.println("//" + matricula.get(i).charAt(j) + "//");

                //Preencher matriculaSemDV
                System.out.println("j -> " + j);
                System.out.println("indexDV -> " + indexDV);
                System.out.println("achou Digito Verificador; = " + bFlagDV);

                if (bFlagDV == false) {

                    switch (matricula.get(i).charAt(j)) {

                        case ('0'):
                            caracteresSemDV = caracteresSemDV + '0';
                            break;

                        case ('1'):
                            caracteresSemDV = caracteresSemDV + '1';
                            break;

                        case ('2'):
                            caracteresSemDV = caracteresSemDV + '2';
                            break;

                        case ('3'):
                            caracteresSemDV = caracteresSemDV + '3';
                            break;

                        case ('4'):
                            caracteresSemDV = caracteresSemDV + '4';
                            break;

                        case ('5'):
                            caracteresSemDV = caracteresSemDV + '5';
                            break;

                        case ('6'):
                            caracteresSemDV = caracteresSemDV + '6';
                            break;

                        case ('7'):
                            caracteresSemDV = caracteresSemDV + '7';
                            break;

                        case ('8'):
                            caracteresSemDV = caracteresSemDV + '8';
                            break;

                        case ('9'):
                            caracteresSemDV = caracteresSemDV + '9';
                            break;

                        case ('-'):
                            indexDV = j;
                            bFlagDV = true;
                            System.out.println("achou Digito Verificador; indexDV = " + indexDV);
                            System.out.println("achou Digito Verificador; = " + bFlagDV);
                            break;

                        default:
                            bERR = true;
                    }
                } else {

                    System.out.println("##### " + matricula.get(i).charAt(j));

                    switch (matricula.get(i).charAt(j)) {

                        case ('0'):
                            caracteresComDV = caracteresComDV + '0';
                            break;

                        case ('1'):
                            caracteresComDV = caracteresComDV + '1';
                            break;

                        case ('2'):
                            caracteresComDV = caracteresComDV + '2';
                            break;

                        case ('3'):
                            caracteresComDV = caracteresComDV + '3';
                            break;

                        case ('4'):
                            caracteresComDV = caracteresComDV + '4';
                            break;

                        case ('5'):
                            caracteresComDV = caracteresComDV + '5';
                            break;

                        case ('6'):
                            caracteresComDV = caracteresComDV + '6';
                            break;

                        case ('7'):
                            caracteresComDV = caracteresComDV + '7';
                            break;

                        case ('8'):
                            caracteresComDV = caracteresComDV + '8';
                            break;

                        case ('9'):
                            caracteresComDV = caracteresComDV + '9';
                            break;

                        case ('a'):
                        case ('A'):
                            caracteresComDV = caracteresComDV + 'A';
                            break;

                        case ('b'):
                        case ('B'):
                            caracteresComDV = caracteresComDV + 'B';
                            break;

                        case ('c'):
                        case ('C'):
                            caracteresComDV = caracteresComDV + 'C';
                            break;

                        case ('d'):
                        case ('D'):
                            caracteresComDV = caracteresComDV + 'D';
                            break;

                        case ('e'):
                        case ('E'):
                            caracteresComDV = caracteresComDV + 'E';
                            break;

                        case ('f'):
                        case ('F'):
                            caracteresComDV = caracteresComDV + 'F';
                            break;

                        default:
                            bERR = true;
                    }
                }

                System.out.println("caracteresSemDV -> " + caracteresSemDV);
                System.out.println("caracteresComDV -> " + caracteresComDV);
            }

            if (bERR == true) {
                JOptionPane.showMessageDialog(null, "Houve ERRO de Sintaxe,\n a matrícula \" " + matricula.get(i) + " \" não será analisada.\n Click em OK para continuar o Processo.");

            } else {

                if (!caracteresSemDV.isEmpty() && caracteresComDV.isEmpty()) {
                    getMatriculaSemDV().add(caracteresSemDV);
                    getDigitoVerificador().add("");
                } else {
                    if (caracteresSemDV.isEmpty() && !caracteresComDV.isEmpty()) {
                        getMatriculaSemDV().add("");
                        getDigitoVerificador().add(caracteresComDV);
                    } else {
                        getMatriculaSemDV().add(caracteresSemDV);
                        getDigitoVerificador().add(caracteresComDV);
                    }
                }
            }

            System.out.println("matriculaSemDV[] = " + getMatriculaSemDV().toString());
            System.out.println("digitoVerificador[] = " + getDigitoVerificador().toString());

        }
    }
}
