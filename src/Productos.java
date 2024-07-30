public class Productos {
    String nombre;
    int stock;
    double precio;

    public Productos() {
    }

    public Productos(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    public Productos(int stock, String nombre, double precio) {
        this.stock = stock;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
}
