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

public class no {

    protected String info;
    protected no prox;
    protected no ant;
    protected lista arq;

    no() {
    }

    no(String info) {
        this.info = info;
        this.prox = null;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public no getProx() {
        return prox;
    }

    public void setProx(no prox) {
        this.prox = prox;
    }

    public no getAnt() {
        return ant;
    }

    public void setAnt(no ant) {
        this.ant = ant;
    }

    public lista getArq() {
        return arq;
    }

    public void setArq(lista arq) {
        this.arq = arq;
    }
}
