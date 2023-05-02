package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Guitarras extends JFrame{

    private JPanel panelGuitarras;
    private JLabel labelLogo;
    private JButton atras;


    public Guitarras(){
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("\uD834\uDD1E Green Devil MusicStore \uD834\uDD1E"); // Título del Frame
        Image iconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/Green-Devil-988x1024.png"));
        setIconImage(iconImage); // Establecemos el icono de la ventana
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents(){

        // INICIAR COMPONENTES

        colocarPanelGuitarras();
        colocarLabelsGuitarras();
        colocarBotonesGuitarras();

        setVisible(true);
    }

    private void colocarPanelGuitarras(){

        // PANEL

        panelGuitarras = new JPanel();
        panelGuitarras.setLayout(null);
        this.getContentPane().add(panelGuitarras);
        panelGuitarras.setBackground(new Color(0xDFFFDF));
        Border border = BorderFactory.createLineBorder(new Color(0x049B04), 4); //Diseñamos el borde del Panel (color y grosor)
        panelGuitarras.setBorder(border);
    }

    private void colocarLabelsGuitarras(){

        // IMÁGEN LOGO - GUITARRAS

        URL urlLogo = Proyecto.Login.class.getResource("Imagenes/Green-Devil-988x1024.png");
        ImageIcon image = new ImageIcon(urlLogo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        labelLogo = new JLabel(); //Label que contendrá el logo de la página
        labelLogo.setIcon(icon); //Le añadimos la imagen del logo
        labelLogo.setBounds(30, 16, 160, 120); //Establecemos su ubicación en el Panel
        panelGuitarras.add(labelLogo); //Añadimos el label al Panel

        // GUITARRA 1 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra = Proyecto.Login.class.getResource("Imagenes/Gibson_LP_Classic.png");
        ImageIcon imagenGuitarra = new ImageIcon(urlGuitarra);
        Icon iconGuitarra = new ImageIcon(imagenGuitarra.getImage().getScaledInstance(150, 300, Image.SCALE_SMOOTH));
        JLabel guitarra1 = new JLabel();
        guitarra1.setIcon(iconGuitarra);
        guitarra1.setBounds(50, 170, 150, 300);
        panelGuitarras.add(guitarra1);
        JLabel guit1 = new JLabel("Gibson Slash Les Paul Standard");
        guit1.setBounds(35, 460, 300, 50);
        panelGuitarras.add(guit1);
        JLabel prec1= new JLabel("2699€");
        prec1.setBounds(55, 484, 50, 50);
        prec1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec1);
        JButton btn1 = new JButton("Comprar");
        btn1.setBounds(115, 500, 85, 20);
        panelGuitarras.add(btn1);

        // GUITARRA 2 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra2 = Proyecto.Login.class.getResource("Imagenes/2916352580_jac_ins_frt_1_rr.png");
        ImageIcon imagenGuitarra2 = new ImageIcon(urlGuitarra2);
        Icon iconGuitarra2 = new ImageIcon(imagenGuitarra2.getImage().getScaledInstance(100, 290, Image.SCALE_SMOOTH));
        JLabel guitarra2 = new JLabel();
        guitarra2.setIcon(iconGuitarra2);
        guitarra2.setBounds(320, 170, 150, 300);
        panelGuitarras.add(guitarra2);
        JLabel guit2 = new JLabel("Jackson SL3X DX");
        guit2.setBounds(320, 458, 300, 50);
        panelGuitarras.add(guit2);
        JLabel prec2 = new JLabel("719€");
        prec2.setBounds(300, 482, 50, 50);
        prec2.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec2);
        JButton btn2 = new JButton("Comprar");
        btn2.setBounds(350, 498, 85, 20);
        panelGuitarras.add(btn2);

        // GUITARRA 3 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra3 = Proyecto.Login.class.getResource("Imagenes/fender-jv-modified-telecaster-custom-60.jpg");
        ImageIcon imagenGuitarra3 = new ImageIcon(urlGuitarra3);
        Icon iconGuitarra3 = new ImageIcon(imagenGuitarra3.getImage().getScaledInstance(220, 290, Image.SCALE_SMOOTH));
        JLabel guitarra3 = new JLabel();
        guitarra3.setIcon(iconGuitarra3);
        guitarra3.setBounds(520, 166, 170, 300);
        panelGuitarras.add(guitarra3);
        JLabel guit3 = new JLabel("Fender Telecaster Custom 60");
        guit3.setBounds(550, 457, 300, 50);
        panelGuitarras.add(guit3);
        JLabel prec3 = new JLabel("2599€");
        prec3.setBounds(560, 482, 50, 50);
        prec3.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec3);
        JButton btn3 = new JButton("Comprar");
        btn3.setBounds(620, 498, 85, 20);
        panelGuitarras.add(btn3);

        // GUITARRA 4 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra4 = Proyecto.Login.class.getResource("Imagenes/evh-striped-series-frankie-relic.jpg");
        ImageIcon imagenGuitarra4 = new ImageIcon(urlGuitarra4);
        Icon iconGuitarra4 = new ImageIcon(imagenGuitarra4.getImage().getScaledInstance(220, 290, Image.SCALE_SMOOTH));
        JLabel guitarra4 = new JLabel();
        guitarra4.setIcon(iconGuitarra4);
        guitarra4.setBounds(780, 166, 170, 300);
        panelGuitarras.add(guitarra4);
        JLabel guit4 = new JLabel("EVH Striped Series");
        guit4.setBounds(840, 455, 300, 50);
        panelGuitarras.add(guit4);
        JLabel prec4 = new JLabel("1359€");
        prec4.setBounds(820, 480, 50, 50);
        prec4.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec4);
        JButton btn4 = new JButton("Comprar");
        btn4.setBounds(880, 496, 85, 20);
        panelGuitarras.add(btn4);

        // GUITARRA 5 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra5 = Proyecto.Login.class.getResource("Imagenes/20230403211826-XF1.6FRFBR20-20FRONT20VERTICAL-394x1024.png");
        ImageIcon imagenGuitarra5 = new ImageIcon(urlGuitarra5);
        Icon iconGuitarra5 = new ImageIcon(imagenGuitarra5.getImage().getScaledInstance(140, 310, Image.SCALE_SMOOTH));
        JLabel guitarra5 = new JLabel();
        guitarra5.setIcon(iconGuitarra5);
        guitarra5.setBounds(1080, 170, 170, 300);
        panelGuitarras.add(guitarra5);
        JLabel guit5 = new JLabel("Ibanez XPTB720");
        guit5.setBounds(1105, 454, 300, 50);
        panelGuitarras.add(guit5);
        JLabel prec5 = new JLabel("1299€");
        prec5.setBounds(1080, 479, 50, 50);
        prec5.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec5);
        JButton btn5 = new JButton("Comprar");
        btn5.setBounds(1140, 495, 85, 20);
        panelGuitarras.add(btn5);

        // GUITARRA 6 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra6 = Proyecto.Login.class.getResource("Imagenes/gibson_exploreran.png");
        ImageIcon imagenGuitarra6 = new ImageIcon(urlGuitarra6);
        Icon iconGuitarra6 = new ImageIcon(imagenGuitarra6.getImage().getScaledInstance(110, 290, Image.SCALE_SMOOTH));
        JLabel guitarra6 = new JLabel();
        guitarra6.setIcon(iconGuitarra6);
        guitarra6.setBounds(1350, 170, 170, 300);
        panelGuitarras.add(guitarra6);
        JLabel guit6 = new JLabel("Gibson Explorer Antique Natural");
        guit6.setBounds(1310, 455, 300, 50);
        panelGuitarras.add(guit6);
        JLabel prec6 = new JLabel("1899€");
        prec6.setBounds(1330, 480, 50, 50);
        prec6.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec6);
        JButton btn6 = new JButton("Comprar");
        btn6.setBounds(1390, 498, 85, 20);
        panelGuitarras.add(btn6);

        // TEXTO / TÍTULO DE LA VENTANA

        JLabel music = new JLabel("GUITARRAS");
        music.setFont(new Font("Impact", Font.ROMAN_BASELINE,100));
        music.setBounds(560, 20, 500, 100);
        music.setForeground(new Color(0x049B04));
        panelGuitarras.add(music);

        JMenuBar linea = new JMenuBar();
        linea.setBounds(4, 150, 1528, 6);
        linea.setBackground(new Color(0x049B04));
        panelGuitarras.add(linea);
    }

    private void colocarBotonesGuitarras(){

        atras = new JButton("↶ Atrás");
        atras.setFont(new Font("Dialog", Font.PLAIN, 18));
        atras.setAlignmentX(Component.CENTER_ALIGNMENT);
        atras.setBounds(1410, 60, 100, 35);
        panelGuitarras.add(atras);

        ActionListener accederRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false); //Para cerrar la ventana de Guitarras una vez hagamos click en el botón de "Atrás"
                new Principal().setVisible(true);
            }
        };
        atras.addActionListener(accederRegister); //Añadimos el método ActionListener a la subopción de "guitarras"

    }

    public static void main(String[] args) {
        Guitarras guitarras = new Guitarras();
    }

}
