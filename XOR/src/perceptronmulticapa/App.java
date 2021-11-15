/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *   Link => https://binary-coffee.dev/post/programando-un-perceptron-multicapa-en-java
 */
package perceptronmulticapa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class App {
    
    public static void main(String[] args) {
        
        ArrayList<double[]> entradas = new ArrayList<double[]>();
        ArrayList<double[]> salidas = new ArrayList<double[]>();

        for(int i = 0; i < 4; i++){
            entradas.add(new double[2]);
            salidas.add(new double[1]);
        }

        entradas.get(0)[0] = 0; entradas.get(0)[1] = 0; salidas.get(0)[0] = 1;
        entradas.get(1)[0] = 0; entradas.get(1)[1] = 1; salidas.get(1)[0] = 0;
        entradas.get(2)[0] = 1; entradas.get(2)[1] = 0; salidas.get(2)[0] = 0;
        entradas.get(3)[0] = 1; entradas.get(3)[1] = 1; salidas.get(3)[0] = 0;

        Perceptron p = new Perceptron(new int[]{entradas.get(0).length, 3, salidas.get(0).length});
        p.Entrenar(entradas, salidas, 0.5, 0.01);
        
        Scanner read = new Scanner(System.in);

        while(true){
            double a = read.nextDouble();
            double b = read.nextDouble();
            System.out.println(p.Activacion(new double[]{a, b})[0]);
        }

    }
}
/*
En este ejemplo trataremos que nuestra red aprenda la compuerta NOR:
A 	B 	A NOR B
0 	0 	1
0 	1 	0
1 	0 	0
1 	1 	0

Para ello crearemos una red neuronal con:

    2 entradas.
    1 salida.
    2 neuronas en la capa de entrada.
    3 neuronas en la capa oculta.
    1 neurona de salida.
    0.5 de razón de aprendizaje
    0.01 de máximo error permisible

*/
