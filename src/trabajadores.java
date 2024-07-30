public class trabajadores {
    String nombre;
    String correo;
    String contrasenia;

    public trabajadores(String nombre, String correo, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return PasswordUtils.hashPassword(contrasenia);
    }
}
