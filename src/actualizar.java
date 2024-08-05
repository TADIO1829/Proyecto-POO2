import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actualizar {
    public JPanel panel1;
    public JTextField textField1;
    public JTextField textField2;
    public JButton Actualizar;
    public JButton volverButton;
    String nombre=" ";
    int stock;


    public actualizar() {
        Actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre = textField1.getText();
                stock = Integer.parseInt(textField2.getText());
                Productos productos=new Productos(nombre,stock);

                String conexion = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";

                try (MongoClient mongoClient = MongoClients.create(conexion)) {

                    MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
                    MongoCollection<Document> collection = database.getCollection("Productos");
                    Document busqueda = new Document("nombre", productos.getNombre());
                    Document actualizar = new Document("$inc", new Document("stock", productos.getStock()));
                    collection.updateOne(busqueda, actualizar);
                    System.out.println("Documento actualizado exitosamente");


                }
            }
            });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new admin().a);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });
    }
    }



