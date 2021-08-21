package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.ProyectosPorTipo;

public class ProyectosPorTipoDao {
   
    public ArrayList<ProyectosPorTipo> rankingProyectosPorTipo() throws SQLException {
        
        ArrayList<ProyectosPorTipo> respuesta = new ArrayList<ProyectosPorTipo>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "SELECT ID_Proyecto, Constructora, Ciudad, Estrato "+
                                "FROM Proyecto "+
                                "INNER JOIN Tipo "+
                                "ON Proyecto.ID_Tipo = Tipo.ID_Tipo "+
                                "WHERE Ciudad = 'Monteria'";
                                


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
                ProyectosPorTipo proyectosPorTipo = new ProyectosPorTipo();
                proyectosPorTipo.setIdProyecto(resultSet.getInt("Id_Proyecto"));
                proyectosPorTipo.setConstructora(resultSet.getString("Constructora"));
                proyectosPorTipo.setCiudad(resultSet.getString("Ciudad"));
                proyectosPorTipo.setEstrato(resultSet.getInt("Estrato"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(proyectosPorTipo);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los proyectos por estrato: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;
    }
        
}
