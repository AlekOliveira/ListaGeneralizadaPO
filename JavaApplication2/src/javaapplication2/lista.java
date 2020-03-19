/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;
/**
 *
 * @author Aluno
 */

public class lista {

    private no ini;
    private no fim;
    private int qtElem;
    
    lista() {
        this.ini = this.fim = null;
        this.qtElem = 0;
    }

    lista(no nodo) {
        this.ini = this.fim = nodo;
        this.qtElem = 1;
    }

   
    public no getIni() {
        return ini;
    }

    public void setIni(no ini) {
        this.ini = ini;
    }

    public no getFim() {
        return fim;
    }

    public void setFim(no fim) {
        this.fim = fim;
    }

    public void insereFim(no no) {
        no aux;
        boolean flag = false;
        if (this.ini == null) {
            this.ini = this.fim = no;
        } else {
            no.setAnt(fim);
            this.fim.setProx(no);
            this.fim = no;
        }
        qtElem++;
    }
    
    private void permuta(no um, no dois){
        String temp = um.getInfo();
        um.setInfo(dois.getInfo());
        dois.setInfo(temp);
    }
    
    private no getNo(int pos){
        no aux = ini;
        for (int i = 0; i < pos; i++) {
            aux = aux.getProx();
        }
        return aux;
    }
    
    private no getNo(no inicio, int desloc){
        no aux = inicio;       
        
        while(aux != null && desloc != 0)
        {
            if(desloc > 0)
            {   
                aux = aux.getProx();
                desloc --;
            }
            else
            {
                aux = aux.getAnt();
                desloc ++;
            }
            
        }        
        return aux;
    }
          
    public void exibe() {
        no aux = this.ini;

        boolean subpastas = false;

        while (aux != null) {
            if (!subpastas) {
                System.out.println(aux.getInfo());
            } else {
                System.out.println("+----" + aux.getInfo());
            }
            if (aux.getArq() != null) {
                no arquivos = aux.getArq().getIni();
                while (arquivos != null) {
                    System.out.println("|    " + arquivos.getInfo());
                    arquivos = arquivos.getProx();
                }
            }

            aux = aux.getProx();
            subpastas = true;
        }
    }
    
    public int calculaTamanho(no n){
       
            int i = 0;
            no aux = n;
            
            if(aux == null)
                return i;

            while(aux.getProx() != null)
            {
                i++;
                aux = aux.getProx();
                
            }
            return i;
    }
    
    public void ordenaArquivos() {
        no aux = this.ini;

        while (aux != null) {

            if (aux.getArq().getIni() != null) {

                SelecaoDireta(aux.getArq().getIni());
            }
            aux = aux.getProx();
        }
    }
                
    public void shellSort() {
        int dist;
        no Noi, Noj, Nok, Maxi;
        
        for (dist = 4, Maxi = getNo(dist); qtElem > 1 && dist != 0; dist /= 2, Maxi = getNo(dist)) {
            for (Noi = ini; Noi != Maxi; Noi = Noi.getProx()) {
                for (Noj = Noi; getNo(Noj, dist) != null; Noj =getNo(Noj, dist)) {
                    if (Noj.getInfo().compareToIgnoreCase(getNo(Noj, dist).getInfo()) <  0) {
                        // permutação                        
                        permuta(Noj, getNo(Noj, dist));
                       
                        // volta verificando se está na pos correta
                        for (Nok = Noj; getNo(Nok, -dist) != null && Nok.getInfo().compareToIgnoreCase(getNo(Nok, -dist).getInfo()) > 0 ; Nok =getNo(Nok, -dist)) {
                            // permutação
                            permuta(Nok, Noi);
                        }
                    }
                }
            }
        }
    }
        
    public void SelecaoDireta(no Nini) {
        //Lado Nao ordenado e ordenado
        no auxi = Nini;
        no auxj;
        no posmenor;

        while (auxi.getProx() != null) {
            posmenor = auxi;
            auxj = auxi.getProx();
            
            while (auxj != null) {
                if (auxj.getInfo().compareToIgnoreCase(posmenor.getInfo()) > 0) {
                    posmenor = auxj;
                }
                auxj = auxj.getProx();
            }
            
            permuta(auxi, posmenor);
            auxi = auxi.getProx();
        }
    }
}

