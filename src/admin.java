import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class admin {
    public JButton ActualizarProductosbutton;
    public JButton agregarCajerosButton;
    public JButton revisarVentasButton;
    public JPanel a;
    String folderPath="C:\\Users\\stefi\\IdeaProjects\\Proyecto-POO2\\reportes";

    public admin() {
        ActualizarProductosbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new actualizar().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(ActualizarProductosbutton)).dispose();

            }

        });
        agregarCajerosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new cajeros().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(agregarCajerosButton)).dispose();

            }
        });
        revisarVentasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File folder = new File(folderPath);
                    if (Desktop.isDesktopSupported()) {
                        Desktop desktop = Desktop.getDesktop();
                        if (folder.exists()) {
                            desktop.open(folder);
                        } else {
                            System.out.println("a");

                        }
                    } else {
                        System.out.println("b");

                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();

                }
            }
        });
    }
}
