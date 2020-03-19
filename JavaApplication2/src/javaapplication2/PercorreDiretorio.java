/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;
import java.io.File;
/**
 *
 * @author Alexandre
 */

public class PercorreDiretorio {

    private lista ld;

    PercorreDiretorio() {
        this.ld = new lista();
    }

    public lista getLD() {
        return ld;
    }

    public void percorre(File f, no atual) {
        File[] fileList = f.listFiles();

        if (fileList != null) {
            for (File fAux : fileList) {
                if (fAux.isDirectory()) {
                    //caso seja diretorio, cria uma nova caixa de diretorio(campo dir preenchido);
                    //logo após inicializa a lista de arquivos desta caixa de diretorio                    
                    
                    no no = new no();
                    no.setInfo(fAux.getName()); ///////////////nome dir
                    no.setArq(new lista());
                    ld.insereFim(no);
                    percorre(fAux, no);
                } else {
                    //caso seja arquivo, cria uma nova caixa de arquivo(e seta campo arq como null);
                    //logo após insere o arquivo na lista do diretorio atual                    
                   
                    no novoArq = new no();
                    novoArq.setInfo(fAux.getName());
                    novoArq.setArq(null);
                    
                    if (atual != null) {
                        atual.getArq().insereFim(novoArq);
                    }
                    else
                        ld.getIni().getArq().insereFim(novoArq);
                }
            }
        }
    }
}
