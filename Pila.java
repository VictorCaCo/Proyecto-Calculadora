/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

public class Pila<T> implements PilaADT<T> {

    private T[] colec;
    private int tope;
    private final int MAX = 10;

    public Pila() {
        colec = (T[]) new Object[MAX];
        tope = -1;
    }

    public void push(T dato) {

        if (!isFull()) {
            tope++;
        }
        colec[tope] = dato;
    }

    @Override

    public T pop() {
        T res = null;
        if (!isEmpty()) {
            res = peek();
            tope--;
        }
        return res;
    }
    public T peek() {
    T res = null;
        if(!isEmpty())
        res = colec[tope];
    return res;
    }

    public boolean isFull(){
    return(tope==MAX-1);
    }
    
    public boolean isEmpty() {
            return tope == -1;
    }
    
    public int darTope(){
        return tope;
    }

}
