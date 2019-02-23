/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

/**
 *
 * @author eespinosru
 */
public class ProyectoCalculadora {
    private String cad;
    private String[] arre;
    private int numE;
    private final int MAX=100;
    
    public ProyectoCalculadora(String c){
        cad=c;
        arre= new String[MAX];
        numE=0;
    } 
    
    public boolean contadorParentesis(){
        //Método para saber si hay un error de sintaxis
        int cont=0, cont2=0;
        boolean res=false;
        for(int i=0; i++; cad.length()-1){
            //recorre toda la cadena
            if(cad.charAt(i)=='(')
                //cuenta los parentesis abiertos
                cont++;
            else
                if(cad.charAt(i)==')')
                    //cuenta los parentesis cerrados
                    cont2++;
        }
        if(cont==cont2)
            res=true;
        return res;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
