package Proyecto;

import java.sql.*;

public class ConsultasBBDD {

    // Instancias la clase que hemos creado anteriormente
    private MySQLConnection SQL = new MySQLConnection();

    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();

    // Query que usarás para hacer lo que necesites
    private String query = "update guitarras set disponibilidad = false where Nombre_guitarra = 'Ibanez XPTB720'";
    //private String query = "select * from guitarras";

    // Query para hacer efectiva la compra de las guitarras

    public void ComprarGuitarra() throws SQLException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query); //Coge la conexión que tenemos configurada
            int resultado = preparedStatement.executeUpdate(query); //Ejecuta la consulta UPDATE de arriba (query) en la BBDD
            System.out.println(resultado);
            System.out.println("Conexión OK");
        } catch (SQLException e) {
            e.printStackTrace(); //En caso de error muestra lo que ha ocurrido
        }
    }

    // Query para hacer efectiva el registro de los usuarios (pasamos como parámetro lo introducido por el usuario en los TextFields)

    public void RegistrarUsuario(String user, String mail, String password) throws SQLException {

        //Creamos la consulta dentro de una variable
        String queryRegistro = "INSERT INTO usuarios (Nombre_usuario, Correo, Contraseña) VALUES ('"+user+"', '"+mail+"', '"+password+"')";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(queryRegistro); //Prepara la conexión y la query
            int resultado = preparedStatement.executeUpdate(queryRegistro); //Ejecuta la consulta INSERT de arriba
            System.out.println("Usuario creado");
        } catch (SQLException e) {
            e.printStackTrace(); //En caso de error muestra lo que ha ocurrido
        }
    }

    // Query para recuperar los usuarios de la BBDD

    public ResultSet ObtenerUsuarioBBDD() throws SQLException {

        //Creamos la consulta dentro de una variable
        String queryObtenerUsuarios = "SELECT Nombre_usuario, contraseña FROM usuarios"; //Seleccionamos todos los usuarios de la BBDD
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(queryObtenerUsuarios); //Prepara la conexión y la query
            ResultSet resultado = preparedStatement.executeQuery(queryObtenerUsuarios); //Ejecuta la consulta INSERT de arriba
            System.out.println("Usuario encontrado");
            return resultado; //Retornamos el resultado para que podamos usarlo desde otras clases o métodos
        } catch (SQLException e) {
            e.printStackTrace(); //En caso de error muestra lo que ha ocurrido
        }

        return null;
    }
}