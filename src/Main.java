import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String contraadmin="tadeo123";
        String contracajero1="lala123";
        String contracajero2="lala1234";
        String contracajero3="lala123456";
        //encriptacion de contraseñas
        String encriptada = PasswordUtils.hashPassword(contraadmin);
        String encriptadacajero1= PasswordUtils.hashPassword(contracajero1);
        String encriptadacajero2= PasswordUtils.hashPassword(contracajero2);
        String encriptadacajero3= PasswordUtils.hashPassword(contracajero3);
        String connectionString = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";
       /* try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
            MongoCollection<Document> collection = database.getCollection("Administrador");

            Document doc = new Document("correo", "adriancadena@gmail.com")
                    .append("contraseniaa", encriptada);
            collection.insertOne(doc);

        }
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
            MongoCollection<Document> collection = database.getCollection("Cajeros");

            Document doc = new Document("correo", "tadeoherrera@gmail.com")
                    .append("contraseniaa", encriptadacajero1);
            collection.insertOne(doc);
            Document doc2 = new Document("correo", "carlosaguilar@gmail.com")
                    .append("contraseniaa", encriptadacajero2);
            collection.insertOne(doc2);
            Document doc3 = new Document("correo", "patricioherrera.com")
                    .append("contraseniaa", encriptadacajero3);
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