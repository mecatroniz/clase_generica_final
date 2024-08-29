
package clase_final_generica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
    private Connection con; 
 
    public Conexion() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Usuarios", "root", "");
            System.out.println("Conexión establecida"); 
        } catch (Exception e) {
          
            System.out.println("Conexión no establecida: " + e);
        }
    }

    public Connection obtenerConexion() {
        return con;
    }

    public void insertarUsuario(Pair<String, Integer> persona, Pair<String, String> datosSalud) {
       
        String sql = "INSERT INTO Usuarios (nombre, edad, eps, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = obtenerConexion( ).prepareStatement(sql)) {
            // Asigna los valores a la consulta
            pstmt.setString(1, persona.getFirst()); // Nombre
            pstmt.setInt(2, persona.getSecond());    // Edad
            pstmt.setString(3, datosSalud.getFirst()); // EPS
            pstmt.setString(4, datosSalud.getSecond()); // Fecha de nacimiento
            pstmt.executeUpdate(); // Ejecuta la actualización
            System.out.println("Usuario insertado correctamente"); // Mensaje de éxito
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        if (con != null) { 
            try {
                con.close(); 
                System.out.println("Conexión cerrada"); 
            } catch (SQLException e) {
               
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }
    }
}
