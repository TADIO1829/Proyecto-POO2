import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.mindrot.jbcrypt.BCrypt;


import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

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
        String conexion = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";
       /*try (MongoClient mongoClient = MongoClients.create(conexion)) {
            MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
            MongoCollection<Document> collection = database.getCollection("Administrador");

            Document doc = new Document("correo", "adriancadena@gmail.com")
                    .append("contraseniaa", encriptada)
                    .append("nombre","Adrian");
            collection.insertOne(doc);

        }
        try (MongoClient mongoClient = MongoClients.create(conexion)) {
            MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
            MongoCollection<Document> collection = database.getCollection("Cajeros");

            Document doc = new Document("correo", "tadeoherrera@gmail.com")
                    .append("contraseniaa", encriptadacajero1)
                    .append("nombre","Tadeo");
            collection.insertOne(doc);
            Document doc2 = new Document("correo", "carlosaguilar@gmail.com")
                    .append("contraseniaa", encriptadacajero2)
                    .append("nombre","Carlos");
            collection.insertOne(doc2);
            Document doc3 = new Document("correo", "patricioherrera.com")
                    .append("contraseniaa", encriptadacajero3)
                    .append("nombre","Patricio");
            collection.insertOne(doc3);

        }



*/
        /*
        try (MongoClient mongoClient = MongoClients.create(conexion)) {
            MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
            MongoCollection<Document> collection = database.getCollection("Productos");

            Document doc = new Document("nombre", "bujia")
                    .append("precio",48 )
                    .append("stock",20);
            collection.insertOne(doc);
            Document doc2 = new Document("nombre", "bomba de agua")
                    .append("precio",210 )
                    .append("stock",12);
            collection.insertOne(doc2);
            Document doc3 = new Document("nombre", "caja de cambios")
                    .append("precio",350 )
                    .append("stock",5);
            collection.insertOne(doc3);
            Document doc4 = new Document("nombre", "amortiguadores")
                    .append("precio",150 )
                    .append("stock",8);
            collection.insertOne(doc4);
            Document doc5 = new Document("nombre", "bateria")
                    .append("precio",400 )
                    .append("stock",20);
            collection.insertOne(doc5);

        }
*//*
        try (MongoClient mongoClient = MongoClients.create(conexion)) {
            MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
            MongoCollection<Document> collection = database.getCollection("Imagenes");
            String bujiaimagen="C:\\Users\\stefi\\IdeaProjects\\Proyecto-POO2\\imagenes\\bujia.jpg";
            String bombaimagen="C:\\Users\\stefi\\IdeaProjects\\Proyecto-POO2\\imagenes\\bomba_agua (1).jpg";
            String cajadecambiosimagen="C:\\Users\\stefi\\IdeaProjects\\Proyecto-POO2\\imagenes\\caja (1).jpg";
            String amortiguadoresimagen="C:\\Users\\stefi\\IdeaProjects\\Proyecto-POO2\\imagenes\\amortiguadores-700 (1).jpg";
            String Baterias="C:\\Users\\stefi\\IdeaProjects\\Proyecto-POO2\\imagenes\\bateria.jpg";

            Document doc = new Document("nombre", "bujia")
                    .append("ruta",bujiaimagen );
            collection.insertOne(doc);
            Document doc2 = new Document("nombre", "bomba de agua")
                    .append("ruta",bombaimagen );
            collection.insertOne(doc2);
            Document doc3 = new Document("nombre", "caja de cambios")
                    .append("ruta",cajadecambiosimagen );
            collection.insertOne(doc3);
            Document doc4 = new Document("nombre", "amortiguadores")
                    .append("ruta",amortiguadoresimagen );
            collection.insertOne(doc4);
            Document doc5 = new Document("nombre", "bateria")
                    .append("ruta",Baterias);
            collection.insertOne(doc5);

        }
*/
        JFrame frame = new JFrame("Mi aplicación");
        frame.setContentPane(new Cajero().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);









    }
}