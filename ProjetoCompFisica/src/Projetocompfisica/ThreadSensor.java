/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projetocompfisica;

import Arduino.AcessaArduino;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wesle
 */
public class ThreadSensor extends Thread{
    AcessaArduino acesso;
   public ThreadSensor(AcessaArduino arduinoo) {
       // store parameter for later user
       this.acesso = arduinoo;
   }
    
    @Override
    public void run(){
        AcessaArduino arduino = new AcessaArduino();
         try {
            
            System.out.println("porta detectada: " + arduino.getPortaSelecionada());
            
        } catch (Exception e) {
            System.out.println("Erro ao acionar o arduino");
        }
         
         while(true){
            try {
                String sensor;
                sensor = acesso.getDadosArduino();
                System.out.println("sensor: "+sensor);
                ThreadSensor.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }
    
}
