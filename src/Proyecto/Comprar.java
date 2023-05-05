package Proyecto;

import java.sql.*;

public class Comprar {
    // Instancias la clase que hemos creado anteriormente
    private MySQLConnection SQL = new MySQLConnection();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();
    // Query que usarás para hacer lo que necesites
    // private String query = "update into guitarras set disponibilidad = 0 where Nombre_guitarra = Ibanez XPTB720";
    private String query = "select * from guitarras";

    public void ComprarGuitarra() throws SQLException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            // Statement sentencia = SQL.conectarMySQL().createStatement();
            ResultSet resultado = preparedStatement.executeQuery(query);
            System.out.println(resultado);
            System.out.println("Conexión OK");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
