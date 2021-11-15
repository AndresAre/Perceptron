/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmulticapa;

import java.util.Random;

/**
 *
 * @author user
 */
public class Neurona {
    public double umbral;
    public double[] pesos;
    double sumaPonderada;
    
    Neurona(int numEntradas, Random r){
        umbral = r.nextDouble();
        pesos = new double[numEntradas];
        
        for(int i=0; i<pesos.length; i++){
            pesos[i] = r.nextDouble();
        }
    }
    public double Activacion(double[] entradas){
        sumaPonderada = umbral;
        
        for(int i=0;i<entradas.length;i++){
            sumaPonderada+=entradas[i]*pesos[i];
        }
        return Sigmoide(sumaPonderada);
    }
    public double Sigmoide(double x){
        return 1 / (1+Math.exp(-x));
    }
}
