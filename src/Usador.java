/**
 * La clase Usador ayuda a mostrar el cajeor  que hizo las facturas
 */
public class Usador {
    // La única instancia de Usador
    private static Usador instance;

    // Atributos de la clase
    private String nombre;

    /**
     * Constructor privado para evitar la creación de instancias adicionales.
     */
    private Usador() {
    }

    /**
     * Obtiene la única instancia de Usador.
     *
     * @return La instancia única de Usador.
     */
    public static Usador getInstance() {
        if (instance == null) {
            instance = new Usador();
        }
        return instance;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
