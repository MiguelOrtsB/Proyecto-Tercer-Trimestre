package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.URL;

public class Información extends JFrame {

    JPanel panelInfo;

    public Información (){

        // FRAME

        setSize(1280, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("\uD834\uDD1E Green Devil MusicStore \uD834\uDD1E"); // Título del Frame
        Image iconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/Green-Devil-988x1024.png"));
        setIconImage(iconImage); // Establecemos el icono de la ventana
        initComponentesInfo();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initComponentesInfo(){

        colocarPanelInfo();
        colocarLabelsInfo();
        colocarTextoInfo();
        this.setVisible(true);
    }

    public void colocarPanelInfo(){

        panelInfo = new JPanel();
        //panelInfo.setLayout(null);
        this.getContentPane().add(panelInfo);
        panelInfo.setBackground(new Color(0xDFFFDF));
        Border border = BorderFactory.createLineBorder(new Color(0x049B04), 4); //Diseñamos el borde del Panel (color y grosor)
        panelInfo.setBorder(border);
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.PAGE_AXIS));
    }

    public void colocarLabelsInfo(){

        JLabel who = new JLabel("¿Quiénes somos?");
        who.setFont(new Font("Impact", Font.PLAIN, 50));
        //who.setBounds(450, 20, 380, 100);
        who.setAlignmentX(Component.CENTER_ALIGNMENT);


        URL urlLogoInfo = Proyecto.Principal.class.getResource("Imagenes/Green-Devil-988x1024.png");
        ImageIcon imagenInfo = new ImageIcon(urlLogoInfo);
        Icon iconoInfo = new ImageIcon(imagenInfo.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH));

        JLabel imagenLogoInfo = new JLabel();
        imagenLogoInfo.setIcon(iconoInfo);
        //imagenLogoInfo.setBounds(570, 110, 300, 130);
        imagenLogoInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelInfo.add(who);
        panelInfo.add(imagenLogoInfo);
        panelInfo.add(Box.createRigidArea(new Dimension(0, 80)));

    }

    public void colocarTextoInfo(){

        JTextArea texto = new JTextArea();
        panelInfo.add(texto);

    }

    public static void main(String[] args) {
        Información info = new Información();

    }
}
