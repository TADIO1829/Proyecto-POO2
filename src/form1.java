import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class form1 {
    public JPanel panel1;
    public JTextField textField1;
    public JPasswordField passwordField1;
    public JButton button1;
    String usuario;
    String clave;

    public form1() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario = textField1.getText();
                clave = passwordField1.getText();
                String connectionString = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {

                    MongoDatabase database = mongoClient.getDatabase("PruebadeConexion");
                    MongoCollection<Document> collection = database.getCollection("Administrador");
                    MongoCollection<Document> collection2 = database.getCollection("Cajeros");





                    Document query = new Document("correo", usuario)
                            .append("contraseniaa", clave);

                    // Perform the find operation to check if the user exists
                    Document user = collection.find(query).first();
                    Document user2=collection2.find(query).first();

                    if (user != null) {
                        JOptionPane.showMessageDialog(button1, "Ingreso como Admin");

                    } else {
                        if (user2!=null){
                            JOptionPane.showMessageDialog(button1, "Ingreso como Cajero");
                        }else{
                            JOptionPane.showMessageDialog(button1, "Datos incorrectos");
                        }

                    }

                } catch (Exception a) {
                    a.printStackTrace();
                }


            }


        });
    }
}

