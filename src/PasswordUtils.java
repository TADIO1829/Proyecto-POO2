import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    /**
     * Genera un hash SHA-256 de la contraseña proporcionada.
     *
     * @param password La contraseña a ser cifrada.
     * @return El hash SHA-256 de la contraseña.
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}