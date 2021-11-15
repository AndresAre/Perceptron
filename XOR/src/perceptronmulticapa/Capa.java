/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmulticapa;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author user
 */
public class Capa {
    public ArrayList<Neurona> neuronas;
    public double[] salidas;
    
    Capa(int numEntradas, int numNeuronas, Random r){
        neuronas = new ArrayList<Neurona>();
        
        for(int i=0; i<numNeuronas; i++){
            neuronas.add(new Neurona(numEntradas, r));
        }
    }
    public double[] Activacion(double[] entradas){
        salidas = new double[neuronas.size()];
        
        for(int i=0; i< neuronas.size();i++){
            salidas[i] = neuronas.get(i).Activacion(entradas);
        }
        return salidas;
    }
}
