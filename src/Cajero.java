import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.Date;

public class Cajero {
    public JPanel panel1;
    public JTextField textField1;
    public JTextField textField2;
    public JButton terminarCompraButton;
    private JButton volverButton;
    String nombre=" ";
    int stock;
    double precio;
    int resta;
    String imagen;


    public Cajero() {
        terminarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombre = textField1.getText();
                stock = Integer.parseInt(textField2.getText());
                resta=stock*-1;
                String conexion = "mongodb+srv://adriancadena:tadio1234@cluster0.pqiuxu4.mongodb.net/";
                MongoClient mongoClient = MongoClients.create(conexion);
                MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
                MongoCollection<org.bson.Document> collection = database.getCollection("Productos");

                // Buscar el producto en la base de datos
                org.bson.Document producto = collection.find(Filters.eq("nombre", nombre)).first();
                if (producto == null) {
                    JOptionPane.showMessageDialog(terminarCompraButton, "Producto no encontrado");
                    return;
                }

                if (nombre.equals("bujia")){
                    precio=350;
                };
                if (nombre.equals("bomba de agua")){
                    precio=210;
                };
                if (nombre.equals("caja de cambios")){
                    precio=1300;
                };
                if (nombre.equals("bateria")){
                    precio=750;
                };

                database = mongoClient.getDatabase("AutoPartsXpress");
                collection = database.getCollection("Imagenes");
                org.bson.Document documento = collection.find(Filters.eq("nombre", nombre)).first();
                if (documento != null) {
                    imagen = documento.getString("ruta");
                    System.out.println("Ruta de la imagen " + imagen);
                }

                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                Productos produc=new Productos(stock,nombre,precio);
                String nombreArchivo = "ReporteDeVenta" + timestamp +Usador.getInstance().getNombre()+ ".pdf";
                String carpeta="C:\\Users\\stefi\\IdeaProjects\\Proyecto-POO2\\reportes"; /*CAMBIAR RUTA*/
                String nombreyruta=carpeta+"/"+nombreArchivo;
                Document document = new Document();

                try {
                    Image image = Image.getInstance(imagen);
                    PdfWriter.getInstance(document, new FileOutputStream(nombreyruta));
                    document.open();
                    Paragraph title = new Paragraph("FACTURA", new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
                    title.setAlignment(Element.ALIGN_CENTER);
                    document.add(title);
                    document.add(new Paragraph(" "));
                    document.add(new Paragraph("AutoPartsXpress"));
                    document.add(new Paragraph(" "));
                    document.add(new Paragraph("Cajero: " + Usador.getInstance().getNombre()));
                    document.add(new Paragraph(" "));
                    //CREACION DE LA TABLA

                    PdfPTable table = new PdfPTable(5);
                    table.setWidthPercentage(100);
                    table.setSpacingBefore(10f);
                    table.setSpacingAfter(10f);

                    PdfPCell cell = new PdfPCell(new Phrase("Descripción", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase("Cantidad", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase("Imagen", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase("Precio Unitario", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase("Total", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
                    table.addCell(cell);
                    table.addCell(new Phrase(produc.getNombre()));
                    table.addCell(String.valueOf(produc.getStock()));
                    table.addCell(image);
                    table.addCell(String.format("$%.2f", precio));
                    table.addCell(String.format("$%.2f", precio * produc.getStock()));
                    document.add(table);
                    Paragraph total = new Paragraph(String.format("Total a Pagar: $%.2f", precio * produc.getStock()), new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
                    total.setAlignment(Element.ALIGN_RIGHT);
                    document.add(total);
                    JOptionPane.showMessageDialog(terminarCompraButton, "Factura Creada");

                } catch (DocumentException | IOException a) {
                    System.err.println("Error al crear Factura" + a.getMessage());
                } finally {
                    document.close();
                }
                    MongoCollection<org.bson.Document> collection2 = database.getCollection("Productos");
                    org.bson.Document busqueda = new org.bson.Document("nombre", nombre);
                    org.bson.Document actualizar = new org.bson.Document("$inc", new org.bson.Document("stock", resta));
                    collection2.updateOne(busqueda, actualizar);









            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new form1().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });
    }



}
