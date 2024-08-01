import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import java.text.SimpleDateFormat;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


public class Cajero {
    public JPanel panel1;
    public JTextField textField1;
    public JTextField textField2;
    public JButton terminarCompraButton;
    String nombre=" ";
    int stock;
    double precio;
    int resta;



    public Cajero() {
        terminarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombre = textField1.getText();
                stock = Integer.parseInt(textField2.getText());
                resta=stock*-1;
                if (nombre.equals("bujia")){
                    precio=350;
                };
                if (nombre.equals("bomba de agua")){
                    precio=350;
                };
                if (nombre.equals("caja de cambios")){
                    precio=150;
                };
                if (nombre.equals("bateria")){
                    precio=400;
                };
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                Productos produc=new Productos(stock,nombre,precio);
                String nombreArchivo = "ReporteDeVenta" + timestamp + ".pdf";

                Document document = new Document();
                try {
                    String ruta=System.getProperty("user.home");

                    PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
                    document.open();
                    PdfPTable tabla=new PdfPTable(3);
                    tabla.addCell("Nombre");
                    tabla.addCell("Producto");
                    tabla.addCell("Total");

                    // Añadir contenido al documento
                    document.add(new Paragraph("Factura"));
                    document.add(new Paragraph("Nombre del Producto: " + produc.getNombre()));
                    document.add(new Paragraph("Cantidad: " + produc.getStock()));
                    document.add(new Paragraph("Total: $" + (precio *stock)));

                    System.out.println("Factura creada exitosamente.");

                } catch (DocumentException | IOException a) {
                    System.err.println("Error al crear el PDF: " + a.getMessage());
                } finally {
                    document.close();
                }
                String conexion = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";

                try (MongoClient mongoClient = MongoClients.create(conexion)) {

                    MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
                    MongoCollection<org.bson.Document> collection = database.getCollection("Productos");
                    org.bson.Document busqueda = new org.bson.Document("nombre", nombre);
                    org.bson.Document actualizar = new org.bson.Document("$inc", new org.bson.Document("stock", resta));
                    collection.updateOne(busqueda, actualizar);
                    System.out.println("Documento actualizado exitosamente");


                }




            }
        });
    }



}
