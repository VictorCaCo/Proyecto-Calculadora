/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
		int cantOp, cantNum, cantOpArr, posIn, n;
		Pila signos, numeros;
		String[] postFijo;
		boolean res = true;
		char operador;
		signos = new Pila<String>();
		numeros = new Pila<Double>();
		double num1, num2, result;

		n = -1;
		posIn = 0;
		cantOp= 0;
		cantNum = 0;
		result = 0;
		infijo = "23+4*8+55";
		infijo = infijo + " ";
		postFijo = new String[infijo.length()];
		
		System.out.println("Infijo: 23+4*8+55" );

		while(posIn < infijo.length()){

			while(posIn < infijo.length()-1 && !(infijo.charAt(posIn)=='+'||infijo.charAt(posIn)=='-'||infijo.charAt(posIn)=='*'|| infijo.charAt(posIn)=='/' || infijo.charAt(posIn)=='^')){
				posIn++;
			}
			postFijo[++n] = infijo.substring(0, posIn);

			if(signos.isEmpty()){
				signos.push(infijo.charAt(posIn));

			}
			else
				switch(infijo.charAt(posIn)){
				case '+':
					while(!signos.isEmpty()){
						postFijo[++n] = signos.pop() + "";
					}
					signos.push('+');
					break;
				case '-':
					while(!signos.isEmpty()){
						postFijo[++n] = signos.pop() + "";
					}
					signos.push('-');
					break;
				case '*':
					while(!signos.isEmpty() &&(!signos.peek().equals('+') && !signos.peek().equals('-')))
						postFijo[++n] = signos.pop() + "";
					signos.push('*');
					break;
				case '/':
					while(!signos.isEmpty() && (!signos.peek().equals('+') && !signos.peek().equals('-')))
						postFijo[++n] = signos.pop() + "";
					signos.push('/');
					break;
				case '^':
					while(!signos.isEmpty() &&(!signos.peek().equals('*') && !signos.peek().equals('/') && (!signos.peek().equals('+') && !signos.peek().equals('-'))))
						postFijo[++n] = signos.pop() + "";
					signos.push('^');
					break;
				}
			infijo= infijo.substring(posIn+1, infijo.length());
			posIn = 0;
		}  

		while(!signos.isEmpty()) {
			postFijo[++n] = signos.pop() + "";
		}
		System.out.print("Postfijo: ");
		for(int i = 0; i<=n ; i++)
			System.out.print(postFijo[i] + " ");


		cantNum = 0;
		while(cantNum <=n-2) {	   
			while(cantNum <=n&&!postFijo[cantNum].equals("*") && !postFijo[cantNum].equals("/") && !postFijo[cantNum].equals("+") && !postFijo[cantNum].equals("-") && !postFijo[cantNum].equals("^")) {
				numeros.push(Double.parseDouble(postFijo[cantNum]));
				cantNum++;
			}
			num2 = (double) numeros.pop();
			num1 = (double) numeros.pop();
			switch(postFijo[cantNum]){
			case "+":
				result = num1+num2;

				break;
			case "-":
				result = num1-num2;

				break;
			case "*":
				result = num1*num2;

				break;
			case "/":
				result = num1/num2;

				break;
			case "^":
				result = Math.pow(num1, num2);

				break;
			}
			
			postFijo[cantNum]= result+"";
		}
		System.out.println("\nResultado : " +postFijo[cantNum]);

	}
}
