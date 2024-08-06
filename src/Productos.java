/**
 * La clase Productos representa un producto con varios atributos y métodos
 * que usa la informacion de un producto
 */

public class Productos {
    String nombre;
    int stock;
    double precio;
    /**
     * Constructor por vacio
     */

    public Productos() {
    }
    /**
     * Constructor con nombre y stock
     *
     * @param nombre El nombre del producto
     * @param stock  El stock del producto
     */
    public Productos(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }
    /**
     * Constructor con stock, nombre y precio
     *
     * @param stock  El stock del producto
     * @param nombre El nombre del producto
     * @param precio El precio del producto
     */

    public Productos(int stock, String nombre, double precio) {
        this.stock = stock;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el stock del producto.
     *
     * @return El stock del producto.
     */
    public int getStock() {
        return stock;
    }
}
