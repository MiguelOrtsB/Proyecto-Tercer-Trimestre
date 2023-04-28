package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.URL;

public class Principal extends JFrame {
    public Principal(){
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("\uD834\uDD1E Green Devil MusicStore \uD834\uDD1E"); // Título del Frame
        Image iconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/Green-Devil-988x1024.png"));
        setIconImage(iconImage); // Establecemos el icono de la ventana
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initComponents(){

        // PANEL

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        this.getContentPane().add(panelPrincipal);
        panelPrincipal.setBackground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(new Color(0x049B04), 4); //Diseñamos el borde del Panel (color y grosor)
        panelPrincipal.setBorder(border);

        // IMÁGEN LOGO

        URL urlLogo = Proyecto.Principal.class.getResource("Imagenes/green DEVIL (2) (1).png");
        ImageIcon imagen = new ImageIcon(urlLogo);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));

        //LABEL

        JLabel imagenLogo = new JLabel();
        imagenLogo.setIcon(icono);
        imagenLogo.setBounds(595, 5, 300, 140);
        panelPrincipal.add(imagenLogo);

        setVisible(true);

    }
    public static void main(String[] args) {
        Principal principal = new Principal();
    }
}
