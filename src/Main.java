import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
public class Main {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("PruebadeConexion");
            MongoCollection<Document> collection = database.getCollection("BlahBlah");

            // Crear un documento
            Document doc = new Document("Nombre", "Tadeo")
                    .append("edad", 19)
                    .append("Profesion", "Tiznado");
            collection.insertOne(doc);

            // Leer un documento
            Document myDoc = collection.find().first();
            System.out.println(myDoc.toJson());

        }
    }
}