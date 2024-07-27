import com.mongodb.client.MongoDatabase;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;


public class admin {
    public JButton ActualizarProductosbutton;
    public JButton agregarUsuariosButton;
    public JButton revisarVentasButton;
    public JPanel a;

    public admin() {
        ActualizarProductosbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }

        });
    }
}
