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
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new actualizar().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 1000);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(ActualizarProductosbutton)).dispose();



            }

        });
    }
}
