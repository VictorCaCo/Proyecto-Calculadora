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
        
        n = -1;
        posIn = 0;
        cantOp= 0;
        infijo = "24^4*8+55";
        infijo = infijo + " ";
        postFijo = (T[]) new Object[infijo.length()];
        
        while(posIn < infijo.length()){

        while(posIn < infijo.length()-1 && !(infijo.charAt(posIn)=='+'||infijo.charAt(posIn)=='-'||infijo.charAt(posIn)=='*'|| infijo.charAt(posIn)=='/' || infijo.charAt(posIn)=='^')){
            posIn++;
        }
        postFijo[++n] = (T) infijo.substring(0, posIn);
        
        if(signos.darTope() == -1){
            signos.push(infijo.charAt(posIn));
  
        }
        else
            switch(infijo.charAt(posIn)){
                     case '+':
                         while(signos.darTope() != -1){
                             postFijo[++n] = (T) signos.pop();
                                     }
                         signos.push('+');
                         break;
                     case '-':
                         while(signos.darTope() != -1){
                             postFijo[++n] = (T) signos.pop();
                                     }
                         signos.push('-');
                         break;
                     case '*':
                         while(signos.darTope() != -1 &&(!signos.peek().equals('+') && !signos.peek().equals('-')))
                        	 postFijo[++n] = (T)signos.pop();
                         signos.push('*');
                         break;
                     case '/':
                         while(signos.darTope() != -1 && (!signos.peek().equals('+') && !signos.peek().equals('-')))
                             postFijo[++n] = (T)signos.pop();
                         signos.push('/');
                         break;
                     case '^':
                         while(signos.darTope() != -1 &&(!signos.peek().equals('*') && !signos.peek().equals('/') && (!signos.peek().equals('+') && !signos.peek().equals('-'))))
                             postFijo[++n] = (T)signos.pop();
                         signos.push('^');
                         break;
                 }
        infijo= infijo.substring(posIn+1, infijo.length());
        posIn = 0;
    }  

    while(signos.darTope()!= -1) {
        postFijo[++n] = (T)signos.pop();
    }
    for(int i = 0; i<=n ; i++)
        System.out.print(postFijo[i] + " ");
  }
}
