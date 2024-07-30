import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class cajeros {
    public JPanel panel1;
    public JTextField textField1;
    public JTextField textField2;
    public  JPasswordField passwordField1;
    public JButton button1;
    String nombre;
    String correo;
    String contra;

    public cajeros() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre = textField1.getText();
                correo = textField2.getText();
                contra = passwordField1.getText();

                trabajadores trab=new trabajadores(nombre,correo,contra);
                String conexion = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";
                try (MongoClient mongoClient = MongoClients.create(conexion)) {
                    MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
                    MongoCollection<Document> collection = database.getCollection("Cajeros");

                    Document doc = new Document("nombre", trab.getNombre())
                            .append("correo", trab.getCorreo())
                            .append("contraseniaa", trab.getContrasenia());
                    collection.insertOne(doc);

                }





            }
        });
    }
}
