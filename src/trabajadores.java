/**
 * La clase trabajadores representa a los cajeros con varios atributos y métodos para
 * gestionar la validación y cifrado de la contraseña.
 */

public class trabajadores {
    //Atributos
    String nombre;
    String correo;
    String contrasenia;
    /**
     * Constructor con parámetros.
     *
     * @param nombre      El nombre del cajero.
     * @param correo      El correo del cajero.
     * @param contrasenia La contraseña del Cajero.
     */
    public trabajadores(String nombre, String correo, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    /**
     * Obtiene el nombre del cajero.
     *
     * @return El nombre del cajero.
     */

    public String getNombre() {
        return nombre;
    }
    /**
     * Obtiene el correo del cajero.
     *
     * @return El correo del cajero.
     */

    public String getCorreo() {
        return correo;
    }
    /**
     * Obtiene la contraseña del cajero.
     *
     * @return La contraseña cifrada del cajero.
     */

    public String getContrasenia() {
        return PasswordUtils.hashPassword(contrasenia);
    }
}
