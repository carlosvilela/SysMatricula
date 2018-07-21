package sysmatricula.grafico;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Seletor {

    private String arquivoSelecionado = ".";
    private String caminhoPastaResultado = ".";

    public String getArquivoSelecionado() {
        return arquivoSelecionado;
    }

    public void setArquivoSelecionado(String arquivoSelecionado) {
        this.arquivoSelecionado = arquivoSelecionado;
    }

    public String getCaminhoPastaResultado() {
        return caminhoPastaResultado;
    }

    public void setCaminhoPastaResultado(String caminhoPastaResultado) {
        this.caminhoPastaResultado = caminhoPastaResultado;
    }
    
    public void selecionarArquivo(){
        
        int confirma;

        JFileChooser selecionarArquivo = new JFileChooser();
        selecionarArquivo.setDialogTitle("Selecione o arquivo que contem as Matrículas em lote");

	int Selecionado = selecionarArquivo.showOpenDialog(null);

	if (Selecionado == JFileChooser.APPROVE_OPTION) {

            setArquivoSelecionado(selecionarArquivo.getSelectedFile().getAbsolutePath());

            confirma = JOptionPane.showConfirmDialog(null, "Confirma o Arquivo?\n\nCaminho :\n"+getArquivoSelecionado()+"\n\nCaso seja necessário configurar novamente, click no Botão Selecionar Arquivo.", "Confimação das Configurações", JOptionPane.OK_CANCEL_OPTION);

		if (confirma == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "O Arquivo com as Matriculas Não foi selecionado!", "Configuração do Sistema", JOptionPane.ERROR_MESSAGE);
                    setArquivoSelecionado(".");

		}else {}

	}else {
            JOptionPane.showMessageDialog(null, "O Arquivo com as Matriculas Não foi selecionado!", "Configuração do Sistema", JOptionPane.ERROR_MESSAGE);
            setArquivoSelecionado(".");

		}
    }
    
    public void selecionarPasta(){
        
        int confirma;
       
        JFileChooser chooser = new JFileChooser(); 

        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Selecione o Diretorio de Resultados");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            setCaminhoPastaResultado(String.valueOf(chooser.getSelectedFile())+"\\");
            confirma = JOptionPane.showConfirmDialog(null, "Confirma as configurações do Diretorio de Resultados?\n\nCaminho do Diretório de Resultados:\n"+getCaminhoPastaResultado()+"\n\nCaso seja necessário configurar novamente, repita o processo.", "Confimação das Configurações de Resultado", JOptionPane.OK_CANCEL_OPTION);
            
            if (confirma == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "O Diretorio de Resultados Nao foi configurado!", "Configuração do Sistema", JOptionPane.ERROR_MESSAGE);
                setCaminhoPastaResultado(".");
                }else {}
        }
        else {
            JOptionPane.showMessageDialog(null, "O Diretorio de Resultados Nao foi configurado!", "Configuração do Sistema", JOptionPane.ERROR_MESSAGE);
            setCaminhoPastaResultado(".");
            }
        }
}
