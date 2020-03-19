/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;
import java.io.File;
/**
 *
 * @author Aluno
 */


//ALEXANDRE OLIVEIRA 101730527
//JOAO PEDRO SAVIAN  101629125 

public class JavaApplication2 {

    public static void main(String[] args) {
        
        PercorreDiretorio p = new PercorreDiretorio();   
        p.percorre(new File("C:\\Users\\Alexandre\\Desktop\\dirteste"), null);
        lista diretorios = p.getLD();
        
        
        diretorios.shellSort();
        diretorios.ordenaArquivos();        
        diretorios.exibe();
    }
    
}
