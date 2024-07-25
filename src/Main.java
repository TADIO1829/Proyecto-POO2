import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
      /*  String connectionString = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("PruebadeConexion");
            MongoCollection<Document> collection = database.getCollection("Administrador");

            Document doc = new Document("correo", "adriancadena@gmail.com")
                    .append("contraseniaa", "tadeo123");
            collection.insertOne(doc);

        }
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("PruebadeConexion");
            MongoCollection<Document> collection = database.getCollection("Cajeros");

            Document doc = new Document("correo", "tadeoherrera@gmail.com")
                    .append("contraseniaa", "lala123");
            collection.insertOne(doc);
            Document doc2 = new Document("correo", "carlosaguilar@gmail.com")
                    .append("contraseniaa", "lala1234");
            collection.insertOne(doc2);
            Document doc3 = new Document("correo", "patricioherrera.com")
                    .append("contraseniaa", "lala12345");
            collection.insertOne(doc3);

        }

*/

        JFrame frame = new JFrame("Mi aplicación");
        frame.setContentPane(new form1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);





    }
}