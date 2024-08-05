public class Usador {
    private static Usador instance;
    private String nombre;

    public Usador() {
    }
    public static Usador getInstance() {
        if (instance == null) {
            instance = new Usador();
        }
        return instance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
