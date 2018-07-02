/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projetocompfisica;

import Arduino.AcessaArduino;
import Banco.Iluminaçao;
import Banco.IluminaçaoDao;
import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.concurrent.TimeUnit;
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
        int acende = 399;
        long tempoinicial = 0;
        long tempo;
        boolean flag = false;
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
                ThreadSensor.sleep(1500);
                int var = Integer.parseInt(sensor); 
                System.out.println("var: "+var);
                if(var > acende){
                    System.out.println("entrei no var> acende ");
                    if(flag == true){
                        System.out.println("entrei na flag true. Flag: "+ flag+ "Tempo inicial:"+ tempoinicial);
                    tempo=System.currentTimeMillis()-tempoinicial;
                        System.out.println("TEMPO:"+tempo +"DEPOIS DE TIRAR O INICIAL :"+tempo);
                    tempo = tempo/1000;
                        System.out.println("TEMPO FINAL EM SERGUNDOS: ");
                    flag = false;
                    
                    
                    System.out.println("temoi: "+tempo);
                        System.out.println("flag "+ flag);
                    IluminaçaoDao  manager = new IluminaçaoDao();
                     Iluminaçao aux = new Iluminaçao();
                     aux.setNumLampada(5);
                     aux.setTempoAceso(acende);
                     aux.setTempoAceso(tempo);
                     //manager.persist(aux);
                                         }

                }
                else if (var < acende){
                    tempoinicial=System.currentTimeMillis();
                    flag = true;
                
                
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }
    
}
