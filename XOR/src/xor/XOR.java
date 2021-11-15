/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * https://www.youtube.com/watch?v=vgOl0XOc2qM&t=254s
 */
package xor;

import java.util.Random;

/**
 *
 * @author Andres Arenas
 */
public class XOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Arreglo de valores XOR
        double [][] arregloXOR={
            {1,0,0},
            {1,0,1},
            {0,1,1},
            {0,0,0}
        };
        //Pesos Aleatorios
        double w1X1;
        double w2X1;
        double w1X2;
        double w2X2;
        double w1Y1;
        double w1Y2;
        double wBias1;
        double wBias2;
        double wBias3;
        
        //Factor de Aprendizaje
        double factorAprendizaje=0.5; 
        
        //Definicion de Variables
        double errorDelta3=0;
        double errorDelta2=0;
        double errorDelta1=0;
        double y1=0;
        double y2=0;
        double y3=0;
        int fila=0;
        int iteraciones=1;
        
        while(fila<=3){ //Ciclo que recorre las 4 filas de arregloXOR
            //Asigna 0 a las variables para hacer los calculos desde el principio
            y1=0;y2=0;y3=0;errorDelta3=0;errorDelta2=0;errorDelta1=0;iteraciones=0;
            
            //Asigna valores aleatorios entre 0 y 1 a todos los pesos
            w1X1=new Random().nextDouble();
            w2X1=new Random().nextDouble();
            w1X2=new Random().nextDouble();
            w2X2=new Random().nextDouble();
            w1Y1=new Random().nextDouble();
            w1Y2=new Random().nextDouble();
            wBias1=new Random().nextDouble();
            wBias2=new Random().nextDouble();
            wBias3=new Random().nextDouble();
            
            while(iteraciones<=2000){//Ciclo que controla cuantas veces se va a repetir
                
                //FORWARD PROPAGATION********************************
                //Calcula la Salida de las Neuronas de la capa oculta
                y1 = (arregloXOR[fila][0]*w1X1)+(arregloXOR[fila][1]*w1X2)+ (1*wBias1);
                y2 = (arregloXOR[fila][0]*w2X1)+(arregloXOR[fila][1]*w2X2)+ (1*wBias2);
               
                 //Implementa la funcion de activacion Sigmoide
                 y1=1.0/(1+Math.pow(Math.E, (-1)*y1));
                 y2=1.0/(1+Math.pow(Math.E, (-1)*y2));
                 
                 //Calcula la salida de la neurona de salida
                 y3=(y1*w1Y1)+(y2*w1Y2)+(1*wBias3);
                 //Implementa la funcion sigmoide
                 y3=1.0/(1+Math.pow(Math.E, (-1) * y3));
                 
                 //BACKPROPAGATION
                 //Calcula el error de la neurona de Salida
                 errorDelta3 = (y3 * (1-y3))*(arregloXOR[fila][2]-y3);
                 
                 //Ajusta los pesos de la neurona de salida de acuerdo al Error Calculado
                 w1Y1 = w1Y1 + (factorAprendizaje*errorDelta3 * y1);
                 w1Y2 = w1Y2 + (factorAprendizaje*errorDelta3 * y2);
                 wBias3 = wBias3+(errorDelta3);
                 //Calcula el error de las neuronas de capa oculta
                 errorDelta1 = (y1 * (1-y1)) * errorDelta3 - w1Y1;
                 errorDelta2 = (y2 * (1-y2)) * errorDelta3 - w1Y2;
                 
                 //Ajusta los pesos de las neuronas de la capa oculta (Neurona 1)
                 w1X1 = w1X1 + (factorAprendizaje*errorDelta1 * arregloXOR[fila][0]);
                 w1X2 = w1X2 + (factorAprendizaje*errorDelta1 * arregloXOR[fila][1]);
                 wBias1 = wBias1 +errorDelta1;
                //Ajusta los pesos de las neuronas de la capa oculta (Neurona 2)
                 w2X1 = w2X1 + (factorAprendizaje*errorDelta2 * arregloXOR[fila][0]);
                 w2X2 = w2X2 + (factorAprendizaje*errorDelta2 * arregloXOR[fila][1]);
                 wBias2 = wBias2 +errorDelta2;
                 iteraciones++;
            }  
            //Imprime cada fila de arregloXOR al terminar el proceso
            System.out.println(""+(int)arregloXOR[fila][0]+"\tXOR\t"+(int)arregloXOR[fila][1]+"\t=\t" + (int)arregloXOR[fila][2]+"\tCalculado: "+y3);
            //incremento para la siguiente fila
            fila++;
        }
    }
    
}
