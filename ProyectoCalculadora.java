/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author eespinosru
 */
public class ProyectoCalculadora {

    /**
     * @param args the command line arguments
     */
    public static <T> void main(String[] args) {
        
        String infijo;
        String[] opArr;
        double[] numFinal;
        char[] opFinal;
        int cantOp, cantNum, cantOpArr, posIn, n;
        Pila signos;
        T[] postFijo;
        boolean res = true;
        
        signos = new Pila();
        
        n = 0;
        posIn = 0;
        cantOp= 0;
        infijo = "24+4*8";
        
        postFijo = (T[]) new Object[infijo.length()];
        
        while(posIn < infijo.length()-1){

        while(posIn < infijo.length()-1 && !(infijo.charAt(posIn)=='+'||infijo.charAt(posIn)=='-'||infijo.charAt(posIn)=='*'|| infijo.charAt(posIn)=='/' || infijo.charAt(posIn)=='^')){
            posIn++;
        }
        postFijo[++n] = (T) infijo.substring(0, posIn);
        
        if(signos.darTope() == -1){
            signos.push(posIn);
        System.out.println("tope" + signos.darTope());
        }
        else
            switch(infijo.charAt(posIn)){
                     case '+':
                         while(signos.darTope() != -1){
                             postFijo[++n] = (T) signos.pop();
                             System.out.println("N" + n);
                                     }
                         signos.push('+');
                         System.out.println("tope" + signos.darTope());
                         break;
                     case '-':
                         while(signos.darTope() != -1){
                             postFijo[++n] = (T) signos.pop();
                                     }
                         signos.push('-');
                         break;
                     case '*':
                         while(signos.darTope() != -1 &&(!signos.peek().equals('+') || !signos.peek().equals('-'))){
                             postFijo[++n] = (T)signos.pop();
                             System.out.println("N" + n);
                         }
                         signos.push('*');
                         break;
                     case '/':
                         while(signos.darTope() != -1 && (!signos.peek().equals('+') || !signos.peek().equals('-')))
                             postFijo[++n] = (T)signos.pop();
                         signos.push('/');
                         break;
                     case '^':
                         while(signos.darTope() != -1 &&(!signos.peek().equals('*') || !signos.peek().equals('/')))
                             postFijo[++n] = (T)signos.pop();
                         signos.push('^');
                         break;
                 }
        infijo= infijo.substring(posIn+1, infijo.length());
        posIn = 0;
    }  
    while(signos.darTope()!= -1) {
        System.out.println("signos" + signos.peek());
        postFijo[++n] = (T)signos.pop();
    }
    for(int i = 0; i<n ; i++)
        System.out.print(postFijo[i] + " ");
    System.out.println("N" + n);
  }
}
