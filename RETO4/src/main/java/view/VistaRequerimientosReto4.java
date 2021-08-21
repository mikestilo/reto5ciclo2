package view;

import controller.ControladorRequerimientosReto4;

import model.vo.ProyectosPorEstrato;
import model.vo.ProyectosPorTipo;
import model.vo.ProyectosQuibdoApartaestudio;


import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class VistaRequerimientosReto4 extends JFrame{
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static JTextArea textArea;

    public VistaRequerimientosReto4(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 800,600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("Reto 5");
        lbltitulo.setBounds(150, 6, 61, 16);
        contentPane.add(lbltitulo);

        JLabel lblautor = new JLabel("Fundamentos de Programacion Michael Lopez Ciclo 2");
        lblautor.setBounds(200, 6, 400, 16);
        contentPane.add(lblautor);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 737, 455);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsuta1 = new JButton("Consulta 1");
        btnConsuta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsuta1.setBounds(28, 37, 117, 29);
        contentPane.add(btnConsuta1);

        JButton btnConsuta2 = new JButton("Consulta 2");
        btnConsuta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        btnConsuta2.setBounds(157, 37, 117, 29);
        contentPane.add(btnConsuta2);

        JButton btnConsuta3 = new JButton("Consulta 3");
        btnConsuta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsuta3.setBounds(286, 37, 117, 29);
        contentPane.add(btnConsuta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(648, 37, 117, 29);
        contentPane.add(btnLimpiar);

    }

    public static void requerimiento1(){

       // System.out.println("*** Proyectos por Estrato ***");
    
        try{

            ArrayList<ProyectosPorEstrato> rankingProyectosPorEstratos = controlador.consultarProyectosPorEstrato();
            String salida = "*** Proyectos por Estrato *** \n\n ID_Tipo\tCodigo \t Area_Maxima \tEstrato \n\n";

            //cada vo cargado
            for (ProyectosPorEstrato proyectosPorEstrato : rankingProyectosPorEstratos) {      
                salida += proyectosPorEstrato.getIdTipo();
                salida += "\t";
                salida += proyectosPorEstrato.getCodigoTipo();
                salida += "\t";
                salida += proyectosPorEstrato.getAreaMaxima();
                salida += "\t";
                salida += proyectosPorEstrato.getEstrato();
                salida += "\n";
                
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void requerimiento2(){ 
        
        //System.out.println("*** Proyectos por Tipo ***");

        try{

             ArrayList<ProyectosPorTipo> rankingProyectosPorTipo = controlador.consultarProyectosPorTipo();
             String salida = "*** Proyectos por Tipo *** \n\n IdProyecto  \t  Constructora  \t\t  Ciudad\tEstrato \n\n";

            //cada vo cargado
            for (ProyectosPorTipo proyectosPorTipo : rankingProyectosPorTipo) {
                //System.out.printf("El proyecto de ID_Proyecto %d de la constructora: %s de la ciudad %s, tiene un estrato asignado de %d %n",
                salida += proyectosPorTipo.getIdProyecto();
                salida += "\t";                
                salida += proyectosPorTipo.getConstructora();
                if(proyectosPorTipo.getConstructora().length() <= 11){
                    salida += "\t\t";
                } else {
                    salida += "\t"; }
                salida += proyectosPorTipo.getCiudad();
                salida += "\t";
                salida += proyectosPorTipo.getEstrato();
                salida += "\n";
                //);
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void requerimiento3(){

        //System.out.println("*** Proyectos de Tipo Apartaestudio en Quibdo ***");

        try{

            ArrayList<ProyectosQuibdoApartaestudio> rankingProyectosQuibdoApartaestudio = controlador.consultarProyectosQuibdoApartaestudio();
            String salida = "*** Proyectos de Tipo Apartaestudio en Quibdo *** \n\n IdProyecto  \t Constructora  \t    PorcentajeCuotaInicial   \tAcabados \n";

            //cada vo cargado
            for (ProyectosQuibdoApartaestudio proyectosQuibdoApartaestudio : rankingProyectosQuibdoApartaestudio) {
                //System.out.printf("El proyecto de ID_Proyecto %d de la constructora: %s tiene un porcentaje de cuota inicial de %1.1f, y %s tiene acabados %n",
                salida += proyectosQuibdoApartaestudio.getIdProyecto();
                salida += "\t";
                salida += proyectosQuibdoApartaestudio.getConstructora();
                salida += "\t";
                salida += proyectosQuibdoApartaestudio.getPorcentajeCuotaInicial();
                salida += "\t";
                salida += proyectosQuibdoApartaestudio.getAcabados();
                salida += "\n";
                //);
            }
            textArea.setText(salida);
                
        
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

}
