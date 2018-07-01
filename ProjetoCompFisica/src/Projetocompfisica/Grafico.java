package Projetocompfisica;

import Banco.IluminaçaoDao;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class Grafico extends ApplicationFrame {
   
   public Grafico( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "",            
         "Tempo Acesa (Minutos)",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
      IluminaçaoDao  manager = new IluminaçaoDao();
      final String lquarto = "Luzes Quarto";        
      final String lcozinha = "Luzes Cozinha";        
      final String lsala = "Luzes Sala"; 
      final String lsuite = "Luzes Suite"; 
      final String consumo = "";        
      
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );
      
      float t1=manager.soma(1).floatValue();
       float t2=manager.soma(2).floatValue();
        float t3=manager.soma(3).floatValue();
         float t4=manager.soma(4).floatValue();
          float t5=manager.soma(5).floatValue();
       

      dataset.addValue( t1, lquarto , consumo );        
      dataset.addValue( t2 , lcozinha , consumo );        
      dataset.addValue( t3 , lsala , consumo );  
      dataset.addValue( t4 , lsuite , consumo );
      dataset.addValue( t5 , "Jardim" , consumo ); 
          

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
      Grafico chart = new Grafico("Car Usage Statistics", 
         "Which car do you like?");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}