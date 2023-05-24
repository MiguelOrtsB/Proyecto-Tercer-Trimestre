package Proyecto;

import javax.swing.*;
import java.sql.*;

public class ConsultasBBDD {

    // Instanciamos la clase que creada anteriormente
    private MySQLConnection SQL = new MySQLConnection();

    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();

    // Query que usarás para hacer lo que necesites
    //private String query = "update guitarras set disponibilidad = true where Nombre_guitarra = 'Ibanez XPTB720'";
    //private String query = "select * from guitarras";

    // QUERY PARA HACER EFECTIVA LA COMPRA DE LAS GUITARRAS

    public void ComprarGuitarra(String guitarra) throws SQLException {

        //Creamos la consulta dentro de una variable
        String query = "UPDATE guitarras SET Disponibilidad = false WHERE Nombre_guitarra = '"+guitarra+"'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query); //Coge la conexión que tenemos configurada
            int resultado = preparedStatement.executeUpdate(query); //Ejecuta la consulta UPDATE de arriba (query) en la BBDD
            System.out.println(resultado);
            System.out.println("Conexión OK");
        } catch (SQLException e) {
            e.printStackTrace(); //En caso de error muestra lo que ha ocurrido
        }
    }

    // QUERY PARA HACER EFECTIVO EL REGISTRO DE LOS USUARIOS (PASAMOS COMO PARÁMETRO LO INTRODUCIDO POR LOS USUARIOS EN LOS TEXTFIELDS)

    public boolean RegistrarUsuario(String user, String mail, String password) throws SQLException {

        //Creamos la consulta dentro de una variable

        String queryRegistro = "INSERT INTO usuarios (Nombre_usuario, Correo, Contraseña) VALUES ('"+user+"', '"+mail+"', '"+password+"')";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(queryRegistro); //Prepara la conexión y la query
            if(user.length()==0 | mail.length()==0 | password.length()==0){ //Comprobamos que los campos contengan caracteres
                JOptionPane.showMessageDialog(null, "Los campos no deben estar vacíos", "¡Atención!", JOptionPane.WARNING_MESSAGE);
                return false; //Si no cumple la condición, retorna false y para la ejecución saliendo del método
            }else{
                int resultado = preparedStatement.executeUpdate(queryRegistro); //Ejecuta la consulta INSERT de arriba
                System.out.println("Usuario creado");
                return true; //Si cumple la condición, retorna true y para la ejecución saliendo del método
            }

        } catch (SQLException e) {
            e.printStackTrace(); //En caso de error muestra lo que ha ocurrido
        }

        return true; //Este return en realidad nunca llega a ejecutarse, puesto que será en el try donde termine la ejecucón.
    }

    // QUERY PARA RECUPERAR LOS USUARIOS DE LA BBDD

    public ResultSet ObtenerUsuarioBBDD() throws SQLException {

        //Creamos la consulta dentro de una variable
        String queryObtenerUsuarios = "SELECT Nombre_usuario, contraseña FROM usuarios"; //Seleccionamos todos los usuarios de la BBDD
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(queryObtenerUsuarios); //Prepara la conexión y la query
            ResultSet resultado = preparedStatement.executeQuery(queryObtenerUsuarios); //Ejecuta la consulta SELECT de arriba
            System.out.println("Usuario encontrado");
            return resultado; //Retornamos el resultado para que podamos usarlo desde otras clases o métodos
        } catch (SQLException e) {
            e.printStackTrace(); //En caso de error muestra lo que ha ocurrido
        }
        return null;
    }

    public ResultSet obtenerDisponibilidad() throws SQLException {

        //Creamos la consulta dentro de una variable
        String queryObtenerUsuarios = "SELECT Nombre_guitarra, Disponibilidad FROM guitarras"; //Seleccionamos todas las guitarras de la BBDD
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(queryObtenerUsuarios); //Prepara la conexión y la query
            ResultSet resultado = preparedStatement.executeQuery(queryObtenerUsuarios); //Ejecuta la consulta SELECT de arriba
            System.out.println("Guitarra encontrada");
            return resultado; //Retornamos el resultado para que podamos usarlo desde otras clases o métodos
        } catch (SQLException e) {
            e.printStackTrace(); //En caso de error muestra lo que ha ocurrido
        }
        return null;
    }

    public ResultSet ObtenerGuitarrasBBDD() throws SQLException {

        //Creamos la consulta dentro de una variable
        String queryObtenerGuitarras = "SELECT * FROM guitarras"; //Seleccionamos todos los usuarios de la BBDD
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(queryObtenerGuitarras); //Prepara la conexión y la query
            ResultSet resultado = preparedStatement.executeQuery(queryObtenerGuitarras); //Ejecuta la consulta SELECT de arriba
            System.out.println("Guitarras encontradas");
            return resultado; //Retornamos el resultado para que podamos usarlo desde otras clases o métodos
        } catch (SQLException e) {
            e.printStackTrace(); //En caso de error muestra lo que ha ocurrido
        }
        return null;
    }

}
