
package clase_final_generica;
import java.util.ArrayList;
import java.util.List;


public class ClaseGenerica {
    public static void main(String[] args) {
        // Crea una instancia de la clase Conexion para manejar la base de datos
        Conexion conexion = new Conexion();

        // Crea una lista para almacenar pares de datos de personas
        List<Pair<String, Integer>> persona = new ArrayList<>(); // Lista para nombres y edades
        List<Pair<String, String>> datosSalud = new ArrayList<>(); // Lista para EPS y fechas de nacimiento
        
        // Añade pares a la lista de personas
        persona.add(new Pair<>("Camila", 30)); // Agrega un par con nombre y edad
        persona.add(new Pair<>("Ana", 25)); // Agrega otro par
        // Añade pares a la lista de datos de salud
        datosSalud.add(new Pair<>("EPS Salud", "1990-01-01")); // Agrega un par con EPS y fecha
        datosSalud.add(new Pair<>("EPS Vida", "1995-05-15")); // Agrega otro par
        
        // Inserta usuarios en la base de datos usando un bucle
        for (int i = 0; i < persona.size(); i++) {
            conexion.insertarUsuario(persona.get(i), datosSalud.get(i)); // Llama al método para insertar
        }

        // Accede a un par específico en la lista
        Pair<String, Integer> person = persona.get(1); // Accediendo al segundo par en la lista de personas
        Pair<String, String> datos = datosSalud.get(1); // Accediendo al segundo par en la lista de datos de salud

        // Imprime el primer y segundo elemento del par de persona
        System.out.println("getFirst: " + person.getFirst()); // Imprime el nombre
        System.out.println("getSecond: " + person.getSecond()); // Imprime la edad
        
        // Imprime los datos de salud
        System.out.println("Datos Salud: " + datos.toString());
        
        // Imprime la lista de personas
        System.out.println("Lista de Personas: " + persona.toString()); // Muestra todos los pares de personas
        // Imprime la lista de datos de salud
        System.out.println("Lista de Datos de Salud: " + datosSalud.toString()); // Muestra todos los pares de datos de salud

        // Cierra la conexión cuando ya no la necesites
        conexion.cerrarConexion(); // Llama al método para cerrar la conexión
    }
}




