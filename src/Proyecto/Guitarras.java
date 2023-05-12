package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Guitarras extends JFrame{

    private JPanel panelGuitarras;
    private JLabel labelLogo;
    private JButton atras;
    private JButton btn1;


    public Guitarras(){

        // FRAME

        //setExtendedState(MAXIMIZED_BOTH);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setResizable(false);
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
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        labelLogo = new JLabel(); //Label que contendrá el logo de la página
        labelLogo.setIcon(icon); //Le añadimos la imagen del logo
        labelLogo.setBounds(30, 5, 160, 120); //Establecemos su ubicación en el Panel
        panelGuitarras.add(labelLogo); //Añadimos el label al Panel

        // GUITARRA 1 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra = Proyecto.Login.class.getResource("Imagenes/Gibson_LP_Classic.png");
        ImageIcon imagenGuitarra = new ImageIcon(urlGuitarra);
        Icon iconGuitarra = new ImageIcon(imagenGuitarra.getImage().getScaledInstance(110, 220, Image.SCALE_SMOOTH));
        JLabel guitarra1 = new JLabel();
        guitarra1.setIcon(iconGuitarra);
        guitarra1.setBounds(72, 95, 150, 300);
        panelGuitarras.add(guitarra1);
        JLabel guit1 = new JLabel("Gibson Slash Les Paul Standard");
        guit1.setBounds(35, 340, 300, 50);
        panelGuitarras.add(guit1);
        JLabel prec1= new JLabel("2699€");
        prec1.setBounds(55, 363, 50, 50);
        prec1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec1);
        btn1 = new JButton("Comprar");
        btn1.setBounds(115, 380, 85, 20);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelGuitarras.add(btn1);

        // GUITARRA 2 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra2 = Proyecto.Login.class.getResource("Imagenes/2916352580_jac_ins_frt_1_rr.png");
        ImageIcon imagenGuitarra2 = new ImageIcon(urlGuitarra2);
        Icon iconGuitarra2 = new ImageIcon(imagenGuitarra2.getImage().getScaledInstance(75, 215, Image.SCALE_SMOOTH));
        JLabel guitarra2 = new JLabel();
        guitarra2.setIcon(iconGuitarra2);
        guitarra2.setBounds(338, 92, 150, 300);
        panelGuitarras.add(guitarra2);
        JLabel guit2 = new JLabel("Jackson SL3X DX");
        guit2.setBounds(327, 339, 300, 50);
        panelGuitarras.add(guit2);
        JLabel prec2 = new JLabel("719€");
        prec2.setBounds(313, 363, 50, 50);
        prec2.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec2);
        JButton btn2 = new JButton("Comprar");
        btn2.setBounds(363, 380, 85, 20);
        btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelGuitarras.add(btn2);

        // GUITARRA 3 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra3 = Proyecto.Login.class.getResource("Imagenes/fender-jv-modified-telecaster-custom-60.jpg");
        ImageIcon imagenGuitarra3 = new ImageIcon(urlGuitarra3);
        Icon iconGuitarra3 = new ImageIcon(imagenGuitarra3.getImage().getScaledInstance(165, 215, Image.SCALE_SMOOTH));
        JLabel guitarra3 = new JLabel();
        guitarra3.setIcon(iconGuitarra3);
        guitarra3.setBounds(545, 94, 170, 300);
        panelGuitarras.add(guitarra3);
        JLabel guit3 = new JLabel("Fender Telecaster Custom 60");
        guit3.setBounds(545, 338, 300, 50);
        panelGuitarras.add(guit3);
        JLabel prec3 = new JLabel("2599€");
        prec3.setBounds(555, 363, 50, 50);
        prec3.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec3);
        JButton btn3 = new JButton("Comprar");
        btn3.setBounds(615, 380, 85, 20);
        btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelGuitarras.add(btn3);

        // GUITARRA 4 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra4 = Proyecto.Login.class.getResource("Imagenes/evh-striped-series-frankie-relic.jpg");
        ImageIcon imagenGuitarra4 = new ImageIcon(urlGuitarra4);
        Icon iconGuitarra4 = new ImageIcon(imagenGuitarra4.getImage().getScaledInstance(162, 212, Image.SCALE_SMOOTH));
        JLabel guitarra4 = new JLabel();
        guitarra4.setIcon(iconGuitarra4);
        guitarra4.setBounds(802, 95, 170, 300);
        panelGuitarras.add(guitarra4);
        JLabel guit4 = new JLabel("EVH Striped Series");
        guit4.setBounds(832, 338, 300, 50);
        panelGuitarras.add(guit4);
        JLabel prec4 = new JLabel("1359€");
        prec4.setBounds(812, 363, 50, 50);
        prec4.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec4);
        JButton btn4 = new JButton("Comprar");
        btn4.setBounds(872, 380, 85, 20);
        btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelGuitarras.add(btn4);

        // GUITARRA 5 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra5 = Proyecto.Login.class.getResource("Imagenes/20230403211826-XF1.6FRFBR20-20FRONT20VERTICAL-394x1024.png");
        ImageIcon imagenGuitarra5 = new ImageIcon(urlGuitarra5);
        Icon iconGuitarra5 = new ImageIcon(imagenGuitarra5.getImage().getScaledInstance(95, 230, Image.SCALE_SMOOTH));
        JLabel guitarra5 = new JLabel();
        guitarra5.setIcon(iconGuitarra5);
        guitarra5.setBounds(1080, 95, 170, 300);
        panelGuitarras.add(guitarra5);
        JLabel guit5 = new JLabel("Ibanez XPTB720");
        guit5.setBounds(1085, 338, 300, 50);
        panelGuitarras.add(guit5);
        JLabel prec5 = new JLabel("1299€");
        prec5.setBounds(1060, 363, 50, 50);
        prec5.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec5);
        JButton btn5 = new JButton("Comprar");
        btn5.setBounds(1121, 380, 85, 20);
        btn5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelGuitarras.add(btn5);

        // GUITARRA 6 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra6 = Proyecto.Login.class.getResource("Imagenes/gibson_exploreran.png");
        ImageIcon imagenGuitarra6 = new ImageIcon(urlGuitarra6);
        Icon iconGuitarra6 = new ImageIcon(imagenGuitarra6.getImage().getScaledInstance(85, 210, Image.SCALE_SMOOTH));
        JLabel guitarra6 = new JLabel();
        guitarra6.setIcon(iconGuitarra6);
        guitarra6.setBounds(80, 370, 170, 300);
        panelGuitarras.add(guitarra6);
        JLabel guit6 = new JLabel("Gibson Explorer Antique Natural");
        guit6.setBounds(35, 610, 300, 50);
        panelGuitarras.add(guit6);
        JLabel prec6 = new JLabel("1899€");
        prec6.setBounds(55, 631, 50, 50);
        prec6.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec6);
        JButton btn6 = new JButton("Comprar");
        btn6.setBounds(115, 648, 85, 20);
        btn6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelGuitarras.add(btn6);

        // GUITARRA 7 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra7 = Proyecto.Login.class.getResource("Imagenes/yamaha-yamaha-f325d-acoustic-guitar.png");
        ImageIcon imagenGuitarra7 = new ImageIcon(urlGuitarra7);
        Icon iconGuitarra7 = new ImageIcon(imagenGuitarra7.getImage().getScaledInstance(95, 210, Image.SCALE_SMOOTH));
        JLabel guitarra7 = new JLabel();
        guitarra7.setIcon(iconGuitarra7);
        guitarra7.setBounds(335, 370, 170, 300);
        panelGuitarras.add(guitarra7);
        JLabel guit7 = new JLabel("Yamaha F325 Acoustic");
        guit7.setBounds(320, 610, 300, 50);
        panelGuitarras.add(guit7);
        JLabel prec7 = new JLabel("169€");
        prec7.setBounds(315, 631, 50, 50);
        prec7.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec7);
        JButton btn7 = new JButton("Comprar");
        btn7.setBounds(365, 648, 85, 20);
        btn7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelGuitarras.add(btn7);

        // GUITARRA 8 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra8 = Proyecto.Login.class.getResource("Imagenes/esp-ltd-george-lynch-gl-200mt-yellow-tiger-electric-guitar-sku-number-lgl200mt.png");
        ImageIcon imagenGuitarra8 = new ImageIcon(urlGuitarra8);
        Icon iconGuitarra8 = new ImageIcon(imagenGuitarra8.getImage().getScaledInstance(80, 210, Image.SCALE_SMOOTH));
        JLabel guitarra8 = new JLabel();
        guitarra8.setIcon(iconGuitarra8);
        guitarra8.setBounds(591, 370, 170, 300);
        panelGuitarras.add(guitarra8);
        JLabel guit8 = new JLabel("ESP LTD GL-200MT");
        guit8.setBounds(577, 610, 300, 50);
        panelGuitarras.add(guit8);
        JLabel prec8 = new JLabel("749€");
        prec8.setBounds(563, 631, 50, 50);
        prec8.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec8);
        JButton btn8 = new JButton("Comprar");
        btn8.setBounds(616, 648, 85, 20);
        btn8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelGuitarras.add(btn8);

        // GUITARRA 9 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra9 = Proyecto.Login.class.getResource("Imagenes/fender-malibu-player-arctic-gold.jpg");
        ImageIcon imagenGuitarra9 = new ImageIcon(urlGuitarra9);
        Icon iconGuitarra9 = new ImageIcon(imagenGuitarra9.getImage().getScaledInstance(210, 200, Image.SCALE_SMOOTH));
        JLabel guitarra9 = new JLabel();
        guitarra9.setIcon(iconGuitarra9);
        guitarra9.setBounds(780, 370, 170, 300);
        panelGuitarras.add(guitarra9);
        JLabel guit9 = new JLabel("Fender Malibu Acoustic");
        guit9.setBounds(820, 610, 300, 50);
        panelGuitarras.add(guit9);
        JLabel prec9 = new JLabel("310€");
        prec9.setBounds(818, 631, 50, 50);
        prec9.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec9);
        JButton btn9 = new JButton("Comprar");
        btn9.setBounds(870, 648, 85, 20);
        btn9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelGuitarras.add(btn9);

        // GUITARRA 10 (CON SU NOMBRE, IMÁGEN, PRECIO, ETC)

        URL urlGuitarra10 = Proyecto.Login.class.getResource("Imagenes/gh200_2w4w-34.png");
        ImageIcon imagenGuitarra10 = new ImageIcon(urlGuitarra10);
        Icon iconGuitarra10 = new ImageIcon(imagenGuitarra10.getImage().getScaledInstance(80, 205, Image.SCALE_SMOOTH));
        JLabel guitarra10 = new JLabel();
        guitarra10.setIcon(iconGuitarra10);
        guitarra10.setBounds(1095, 370, 170, 300);
        panelGuitarras.add(guitarra10);
        JLabel guit10 = new JLabel("ESP LTD GH-200 BLK");
        guit10.setBounds(1071, 610, 300, 50);
        panelGuitarras.add(guit10);
        JLabel prec10 = new JLabel("749€");
        prec10.setBounds(1068, 631, 50, 50);
        prec10.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
        panelGuitarras.add(prec10);
        JButton btn10 = new JButton("Comprar");
        btn10.setBounds(1121, 648, 85, 20);
        btn10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelGuitarras.add(btn10);


        // TEXTO / TÍTULO DE LA VENTANA

        JLabel music = new JLabel("GUITARRAS");
        music.setFont(new Font("Impact", Font.ROMAN_BASELINE,70));
        music.setBounds(480, 10, 500, 100);
        music.setForeground(new Color(0x049B04));
        panelGuitarras.add(music);

        JMenuBar linea = new JMenuBar();
        linea.setBounds(4, 120, 1518, 6);
        linea.setBackground(new Color(0x049B04));
        panelGuitarras.add(linea);

        /* CON EL SIGUIENTE TRY/CATCH COMPROBAMOS LA DISPONIBILIDAD DE LAS GUITARRA 1 UNA VEZ ENTREMOS EN LA VENTANA DE "GUITARRAS"
        AUTOMÁTICAMENTE. DE ESTA MANERA, SI AL RECORRER LA TABLA VEMOS QUE LA DISPONIBILIDAD ES "0", NO NOS DEJARÁ LA OPCIÓN DE
        COMPRARLA, YA QUE EL BOTÓN APARECERÁ DESACTIVADO (ALGO ASÍ COMO PERSISTENCIA DE DATOS).
         */

        try{
            ConsultasBBDD compramosGuitar = new ConsultasBBDD(); //Llamamos a la clase donde se encuentran las consultas
            ResultSet usuarios = compramosGuitar.obtenerDisponibilidad();
            String g = "Gibson Slash Les Paul Standard"; //Variable que almacena el nombre de guitarra que pasamos como parámetro

            while(usuarios.next()){
                String guitBBDD = usuarios.getString("Nombre_guitarra"); //
                boolean dispBBDD = usuarios.getBoolean("Disponibilidad");

                if(guitBBDD.equals(g) & !dispBBDD){
                    btn1.setEnabled(false); //Desactivamos el botón una vez hayamos comprado la guitarra para que no se pueda comprar de nuevo
                    JLabel sold1 = new JLabel("VENDIDA");
                    sold1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 38));
                    sold1.setBounds(50, 220, 300, 50);
                    sold1.setForeground(Color.RED);
                    panelGuitarras.add(sold1);
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        // EVENTO ACTIONLISTENER (COMPRAR GUITARRA 1) ¡¡FALTAN MUCHAS FUNCIONALIDADES (LETRERO VENDIDO, PERSISTENCIA DE DATOS, ETC)!!
        ActionListener compraGuitar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ConsultasBBDD compramosGuitar = new ConsultasBBDD(); //Llamamos a la clase donde se encuentran las consultas
                    String g = "Gibson Slash Les Paul Standard"; //Variable que almacena el nombre de guitarra que pasamos como parámetro
                    compramosGuitar.ComprarGuitarra(g); //Accedemos al método de la clase Consultas y le pasamos el nombre de la guitarra
                    btn1.setEnabled(false); //Desactivamos el botón una vez hayamos comprado la guitarra para que no se pueda comprar de nuevo

                }catch (SQLException ex){
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "¡Compra realizada con éxito!");
                JLabel sold1 = new JLabel("VENDIDO");
                sold1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 38));
                sold1.setForeground(Color.RED);
                sold1.setBounds(50, 290, 300, 50);
                panelGuitarras.add(sold1);
            }
        };
        btn1.addActionListener(compraGuitar); //Añadimos al botón 1 el método Comprar Guitarra
    }

    private void colocarBotonesGuitarras(){

        atras = new JButton("↶Atrás");
        atras.setFont(new Font("Dialog", Font.PLAIN, 18));
        atras.setAlignmentX(Component.CENTER_ALIGNMENT);
        atras.setBounds(1130, 45, 100, 35);
        atras.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

}
