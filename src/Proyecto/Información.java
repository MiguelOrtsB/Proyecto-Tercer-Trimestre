package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.URL;

public class Información extends JFrame {

    private JPanel panelInfo;
    private Image imagen;

    FondoPanel fondoPanelcillo = new FondoPanel();

    public Información (){

        // FRAME

        setSize(1280, 720);
        this.setContentPane(fondoPanelcillo);
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
        this.setVisible(true);
    }

    public void colocarPanelInfo(){

        panelInfo = new JPanel();
        panelInfo.setLayout(null);
        this.getContentPane().add(panelInfo);
        panelInfo.setBackground(new Color(0xDFFFDF));
        Border border = BorderFactory.createLineBorder(new Color(0x049B04), 4); //Diseñamos el borde del Panel (color y grosor)
        panelInfo.setBorder(border);
    }

    public void colocarLabelsInfo(){

        JLabel who = new JLabel("¿Quiénes somos?");
        who.setFont(new Font("Impact", Font.PLAIN, 50));
        who.setBounds(450, 15, 380, 50);
        panelInfo.add(who);

        URL urlLogoInfo = Proyecto.Principal.class.getResource("Imagenes/Green-Devil-988x1024.png");
        ImageIcon imagenInfo = new ImageIcon(urlLogoInfo);
        Icon iconoInfo = new ImageIcon(imagenInfo.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH));

        JLabel imagenLogoInfo = new JLabel();
        imagenLogoInfo.setIcon(iconoInfo);
        imagenLogoInfo.setBounds(570, 75, 300, 130);
        panelInfo.add(imagenLogoInfo);

        JLabel texto = new JLabel();
        texto.setBounds(300, 80, 1000, 400);
        texto.setText("<html><p>Somos una tienda especializada en instrumentos musicales de Palma de Mallorca.<br>" +
                "Nuestra experiencia se remonta a 1995, cuando abrimos nuestra primera tienda<br>" +
                "ajajaj<" +
                "</p></html>");
        texto.setFont(new Font("Calibri", Font.BOLD, 20));
        texto.setBackground(Color.white);
        panelInfo.add(texto);

        URL urlImagenFondo = Proyecto.Principal.class.getResource("Imagenes/Green-Devil-988x1024.png");
        ImageIcon imagenFondo = new ImageIcon(urlImagenFondo);
        Icon iconoFondo = new ImageIcon(imagenFondo.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH));
    }

    class FondoPanel extends JPanel{
        @Override
        public void paint(Graphics g){

            imagen = new ImageIcon(getClass().getResource("Imagenes/electricwall-1.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    public static void main(String[] args) {
        Información info = new Información();

    }
}
