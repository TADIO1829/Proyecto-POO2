import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.*;

import org.bson.Document;
import org.mindrot.jbcrypt.BCrypt;

public class form1 {
    public JPanel panel1;
    public JTextField textField1;
    public JPasswordField passwordField1;
    public JButton button1;


    public form1() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textField1.getText();
                String clave = new String(passwordField1.getPassword());
                String connectionString = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {

                    MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
                    MongoCollection<Document> collection = database.getCollection("Administrador");
                    MongoCollection<Document> collection2 = database.getCollection("Cajeros");


                    Document query = new Document("correo", usuario);


                     Document user = collection.find(query).first();
                    Document user2=collection2.find(query).first();

                    if (user != null) {
                        String storedHashedPassword = user.getString("contraseniaa"); //
                        String hashedInputPassword = PasswordUtils.hashPassword(clave);
                        if (hashedInputPassword.equals(storedHashedPassword)) {
                            JOptionPane.showMessageDialog(button1, "Ingreso como Admin");
                        } else {
                            JOptionPane.showMessageDialog(button1, "Contraseña incorrecta");
                        }
                    } else if (user2 != null) {
                        String storedHashedPassword = user2.getString("contraseniaa"); //
                        String hashedInputPassword = PasswordUtils.hashPassword(clave);
                        if (hashedInputPassword.equals(storedHashedPassword)) {
                            JOptionPane.showMessageDialog(button1, "Ingreso como Cajero");
                        } else {
                            JOptionPane.showMessageDialog(button1, "Contraseña incorrecta");
                        }
                    } else {
                        JOptionPane.showMessageDialog(button1, "Datos incorrectos");
                    }
                } catch (Exception a) {
                    a.printStackTrace();
                    JOptionPane.showMessageDialog(button1, "Error en el login: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }


            }


        });
    }
}

