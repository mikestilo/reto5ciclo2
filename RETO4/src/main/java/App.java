import java.awt.EventQueue;

import view.VistaRequerimientosReto4;

public class App {
    public static void main( String[] args ){   

        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                try{
                    VistaRequerimientosReto4 frame = new VistaRequerimientosReto4();
                    frame.setVisible(true);
                } catch(Exception e){
                    e.printStackTrace();
                }
                
            }
            
        });
        
                
    }

}

/* //Casos de prueba 

        //Requerimiento 1 - Reto3
        VistaRequerimientosReto4.requerimiento1();
        System.out.println();

         //Requerimiento 2 - Reto3
         VistaRequerimientosReto4.requerimiento2();
         System.out.println();

        //Requerimiento 5 - Reto3
        VistaRequerimientosReto4.requerimiento3();
        System.out.println(); */