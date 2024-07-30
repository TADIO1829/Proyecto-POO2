import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actualizar {
    public JPanel panel1;
    public JTextField textField1;
    public JTextField textField2;
    public JButton button1;
    String nombre=" ";
    int stock;
    Productos productos=new Productos(nombre,stock);

    public actualizar() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre = textField1.getText();
                stock = Integer.parseInt(textField2.getText());

                String conexion = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";

                try (MongoClient mongoClient = MongoClients.create(conexion)) {

                    MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
                    MongoCollection<Document> collection = database.getCollection("Productos");
                    Document busqueda = new Document("nombre", nombre);
                    Document actualizar = new Document("$inc", new Document("stock", stock));
                    collection.updateOne(busqueda, actualizar);
                    System.out.println("Documento actualizado exitosamente");


                }
            }
            });
        }
    }



