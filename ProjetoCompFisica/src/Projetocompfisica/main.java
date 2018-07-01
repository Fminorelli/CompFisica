/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projetocompfisica;

import Banco.Iluminaçao;
import Banco.IluminaçaoDao;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author wesle
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interface i = new Interface();
        i.setVisible(true);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
        String dataFormatada = sdf.format(hora);
        System.out.println("Data:"+ dataFormatada);
        
        
        
        Date data = new Date();
        System.out.println("Data Agora: "+data);
        System.out.println("teste banco");
        IluminaçaoDao  manager = new IluminaçaoDao();
        BigDecimal soma = manager.soma(1);
        //List<Iluminaçao> lista;
        //lista = manager.lista();
        System.out.println("Teste select sum: "+ soma);
        //System.out.println("teste lista: "+ lista.get(1).getNumLampada() + lista.get(1).getTempoAceso());
        System.out.println("fim teste banco");
        
        ThreadSensor sensor = new ThreadSensor();
        sensor.start();
    }
    
}
