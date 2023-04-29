package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Principal extends JFrame {

    private JPanel panelPrincipal;
    private JMenuBar navbar;
    private JMenu menu1;
    private JMenu menu11;
    private JMenu menu12;

    public Principal(){

        setExtendedState(MAXIMIZED_BOTH);
        setTitle("\uD834\uDD1E Green Devil MusicStore \uD834\uDD1E"); // Título del Frame
        Image iconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/Green-Devil-988x1024.png"));
        setIconImage(iconImage); // Establecemos el icono de la ventana
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents(){

        // INICIAR COMPONENTES

        colocarPanelPrincipal();
        colocarLabelsPrincipal();
        colocarMenuBar();

        setVisible(true);
    }

    private void colocarPanelPrincipal(){

        // PANEL

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        this.getContentPane().add(panelPrincipal);
        panelPrincipal.setBackground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(new Color(0x049B04), 4); //Diseñamos el borde del Panel (color y grosor)
        panelPrincipal.setBorder(border);
    }

    private void colocarLabelsPrincipal(){

        // IMÁGENES - LOGOS

        URL urlLogo = Proyecto.Principal.class.getResource("Imagenes/green DEVIL (2) (1).png");
        ImageIcon imagen = new ImageIcon(urlLogo);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));

        URL urlLogo2 = Proyecto.Principal.class.getResource("Imagenes/gibson.png");
        ImageIcon imagen2 = new ImageIcon(urlLogo2);
        Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        URL urlLogo3 = Proyecto.Principal.class.getResource("Imagenes/fender_logo1.png");
        ImageIcon imagen3 = new ImageIcon(urlLogo3);
        Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        URL urlLogo4 = Proyecto.Principal.class.getResource("Imagenes/original.png");
        ImageIcon imagen4 = new ImageIcon(urlLogo4);
        Icon icono4 = new ImageIcon(imagen4.getImage().getScaledInstance(420, 300, Image.SCALE_SMOOTH));

        URL urlLogo5 = Proyecto.Principal.class.getResource("Imagenes/EVH-striped-logo.png");
        ImageIcon imagen5 = new ImageIcon(urlLogo5);
        Icon icono5 = new ImageIcon(imagen5.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));

        URL urlLogo6 = Proyecto.Principal.class.getResource("Imagenes/39.jpg");
        ImageIcon imagen6 = new ImageIcon(urlLogo6);
        Icon icono6 = new ImageIcon(imagen6.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));

        URL urlLogo7 = Proyecto.Principal.class.getResource("Imagenes/logo-amp-marshall-black-300px.png");
        ImageIcon imagen7 = new ImageIcon(urlLogo7);
        Icon icono7 = new ImageIcon(imagen7.getImage().getScaledInstance(250, 125, Image.SCALE_SMOOTH));

        URL urlLogo8 = Proyecto.Principal.class.getResource("Imagenes/orange-amplifiers.png");
        ImageIcon imagen8 = new ImageIcon(urlLogo8);
        Icon icono8 = new ImageIcon(imagen8.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));

        URL urlLogo9 = Proyecto.Principal.class.getResource("Imagenes/2560px-Jackson_guitars_logo.svg.png");
        ImageIcon imagen9 = new ImageIcon(urlLogo9);
        Icon icono9 = new ImageIcon(imagen9.getImage().getScaledInstance(250, 75, Image.SCALE_SMOOTH));

        URL urlLogo10 = Proyecto.Principal.class.getResource("Imagenes/600dadd6516067000439acaa.png");
        ImageIcon imagen10 = new ImageIcon(urlLogo10);
        Icon icono10 = new ImageIcon(imagen10.getImage().getScaledInstance(250, 80, Image.SCALE_SMOOTH));

        URL urlLogo11 = Proyecto.Principal.class.getResource("Imagenes/MXR_Logo_G.png");
        ImageIcon imagen11 = new ImageIcon(urlLogo11);
        Icon icono11 = new ImageIcon(imagen11.getImage().getScaledInstance(255, 100, Image.SCALE_SMOOTH));

        URL urlLogo12 = Proyecto.Principal.class.getResource("Imagenes/Vox-logo-Warranty-DAR-WEB.png");
        ImageIcon imagen12 = new ImageIcon(urlLogo12);
        Icon icono12 = new ImageIcon(imagen12.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        URL urlLogo13 = Proyecto.Principal.class.getResource("Imagenes/Yamaha_logo_dark.svg.png");
        ImageIcon imagen13 = new ImageIcon(urlLogo13);
        Icon icono13 = new ImageIcon(imagen13.getImage().getScaledInstance(240, 50, Image.SCALE_SMOOTH));

        //LABELS PARA LAS IMÁGENES Y TEXTOS

        JLabel imagenLogo = new JLabel();
        imagenLogo.setIcon(icono);
        imagenLogo.setBounds(600, 5, 300, 140);
        panelPrincipal.add(imagenLogo);

        JLabel imagenLogo2 = new JLabel();
        imagenLogo2.setIcon(icono2);
        imagenLogo2.setBounds(350, 230, 300, 150);
        panelPrincipal.add(imagenLogo2);

        JLabel imagenLogo3 = new JLabel();
        imagenLogo3.setIcon(icono3);
        imagenLogo3.setBounds(650, 220, 300, 150);
        panelPrincipal.add(imagenLogo3);

        JLabel imagenLogo4 = new JLabel();
        imagenLogo4.setIcon(icono4);
        imagenLogo4.setBounds(830, 240, 300, 150);
        panelPrincipal.add(imagenLogo4);

        JLabel imagenLogo5 = new JLabel();
        imagenLogo5.setIcon(icono5);
        imagenLogo5.setBounds(650, 370, 300, 150);
        panelPrincipal.add(imagenLogo5);

        JLabel imagenLogo6 = new JLabel();
        imagenLogo6.setIcon(icono6);
        imagenLogo6.setBounds(900, 375, 300, 150);
        panelPrincipal.add(imagenLogo6);

        JLabel imagenLogo7 = new JLabel();
        imagenLogo7.setIcon(icono7);
        imagenLogo7.setBounds(325, 370, 300, 150);
        panelPrincipal.add(imagenLogo7);

        JLabel imagenLogo8 = new JLabel();
        imagenLogo8.setIcon(icono8);
        imagenLogo8.setBounds(330, 530, 300, 150);
        panelPrincipal.add(imagenLogo8);

        JLabel imagenLogo9 = new JLabel();
        imagenLogo9.setIcon(icono9);
        imagenLogo9.setBounds(630, 520, 300, 150);
        panelPrincipal.add(imagenLogo9);

        JLabel imagenLogo10 = new JLabel();
        imagenLogo10.setIcon(icono10);
        imagenLogo10.setBounds(925, 526, 300, 150);
        panelPrincipal.add(imagenLogo10);

        JLabel imagenLogo11 = new JLabel();
        imagenLogo11.setIcon(icono11);
        imagenLogo11.setBounds(328, 665, 300, 150);
        panelPrincipal.add(imagenLogo11);

        JLabel imagenLogo12 = new JLabel();
        imagenLogo12.setIcon(icono12);
        imagenLogo12.setBounds(655, 695, 300, 150);
        panelPrincipal.add(imagenLogo12);

        JLabel imagenLogo13 = new JLabel();
        imagenLogo13.setIcon(icono13);
        imagenLogo13.setBounds(930, 670, 300, 150);
        panelPrincipal.add(imagenLogo13);

        JLabel music = new JLabel("MUSIC");
        music.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE,120));
        music.setBounds(220, 25, 400, 100);
        music.setForeground(new Color(0x049B04));
        panelPrincipal.add(music);

        JLabel store = new JLabel("STORE");
        store.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE,120));
        store.setBounds(900, 25, 400, 100);
        store.setForeground(new Color(0x049B04));
        panelPrincipal.add(store);

        JLabel nuestrasMarcas = new JLabel("NUESTRAS MARCAS:");
        nuestrasMarcas.setFont(new Font("Impact", Font.ROMAN_BASELINE,20));
        nuestrasMarcas.setBounds(673, 165, 200, 100);
        nuestrasMarcas.setForeground(Color.BLACK);
        panelPrincipal.add(nuestrasMarcas);
    }

    private void colocarMenuBar(){

        // MENU BAR

        navbar = new JMenuBar(); //Creación de la barra del menú
        navbar.setOpaque(true); //La hacemos opaca para aplicarle color de fondo y que así se pueda visualizar
        navbar.setBackground(Color.BLACK); //Le aplicamos color de fondo
        navbar.setBounds(4, 145, 1528, 50); //Tamaño y posición del MenuBar
        panelPrincipal.add(navbar); //La añadimos al PANEL

        // OPCIONES DEL MENU BAR (MENÚ, CONTACTO, INFO)

        menu1 = new JMenu("Menú"); //Añadimos el Menu1 que va encima del MenuBar y que abrirá el desplegable de opciones
        menu1.setFont(new Font("Cinzel", Font.PLAIN,18)); //Le aplicamos tipo de fuente, color y tamaño
        menu1.setForeground(Color.WHITE); //Color de la fuente
        //menu1.addSeparator();
        menu1.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambia el tipo de cursor cuando nos posamos encima
        menu1.setRolloverEnabled(true);
        menu1.addMouseListener(mouseAction); //Añadimos los eventos de ratón de más abajo al Menu1
        navbar.add(menu1); //Añadimos el Menu al MenuBar

        menu11 = new JMenu("Contacto"); //Añadimos el Menu1 que va encima del MenuBar y que abrirá el desplegable de opciones
        menu11.setFont(new Font("Cinzel", Font.PLAIN,18)); //Le aplicamos tipo de fuente, color y tamaño
        menu11.setForeground(Color.WHITE); //Color de la fuente
        menu11.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambia el tipo de cursor cuando nos posamos encima
        menu11.setRolloverEnabled(true);
        menu11.addMouseListener(mouseAction); //Añadimos los eventos de ratón de más abajo al Menu11
        navbar.add(menu11); //Añadimos el Menu al MenuBar

        menu12 = new JMenu("Info"); //Añadimos el Menu1 que va encima del MenuBar y que abrirá el desplegable de opciones
        menu12.setFont(new Font("Cinzel", Font.PLAIN,18)); //Le aplicamos tipo de fuente, color y tamaño
        menu12.setForeground(Color.WHITE); //Color de la fuente
        menu12.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambia el tipo de cursor cuando nos posamos encima
        menu12.setRolloverEnabled(true);
        menu12.addMouseListener(mouseAction); //Añadimos los eventos de ratón de más abajo al Menu12
        navbar.add(menu12); //Añadimos el Menu al MenuBar

        // SUBOPCIONES DENTRO DE MENÚ

        JMenu menu2 = new JMenu("Guitarras"); //Este menu2 irá dentro del menu1, y se activará al hacer click en menu1
        menu2.setFont(new Font("Cinzel", Font.PLAIN,20));
        menu2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu1.add(menu2);

        JMenu menu3 = new JMenu("Bajos");
        menu3.setFont(new Font("Cinzel", Font.PLAIN,20));
        menu3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu1.add(menu3);

        JMenu menu5 = new JMenu("Pedales");
        menu5.setFont(new Font("Cinzel", Font.PLAIN,20));
        menu5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu1.add(menu5);

        JMenu menu4 = new JMenu("Amplificadores");
        menu4.setFont(new Font("Cinzel", Font.PLAIN,20));
        menu4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu1.add(menu4);

        // SUBOPCIONES DENTRO DE CONTACTO

        JMenu menu6 = new JMenu("Teléfono");
        menu6.setFont(new Font("Cinzel", Font.PLAIN,20));
        menu6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu11.add(menu6);

        JMenu menu7 = new JMenu("Correo");
        menu7.setFont(new Font("Cinzel", Font.PLAIN,20));
        menu7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu11.add(menu7);

        JMenu menu8 = new JMenu("Dirección");
        menu8.setFont(new Font("Cinzel", Font.PLAIN,20));
        menu8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu11.add(menu8);

        // RESULTADOS PARA LA OPCIÓN DE "CONTACTO"

        JMenuItem telf = new JMenuItem("971809097");
        telf.setFont(new Font("Cinzel", Font.PLAIN,20));
        menu6.add(telf);

        JMenuItem correo = new JMenuItem("greendevilmusicstore@gmail.es");
        telf.setFont(new Font("Cinzel", Font.PLAIN,20));
        menu7.add(correo);

        JMenuItem direccion = new JMenuItem("C/ Barón de Pinopar nº19");
        telf.setFont(new Font("Cinzel", Font.PLAIN,20));
        menu8.add(direccion);
    }

    // EVENTOS DE RATÓN (CUANDO PASAMOS CON EL RATÓN POR ENCIMA DEL MENÚ CAMBIA DE COLOR)

    private final MouseListener mouseAction = new MouseAdapter(){

        @Override
        public void mouseEntered(MouseEvent e) {
            menu1 = (JMenu) e.getSource(); //is this implementation correct ?
            menu1.setOpaque(true);
            menu1.setSelected(true);
            menu1.setBackground(Color.BLACK);
        };

        @Override
        public void mouseExited(MouseEvent e) {
            menu1 = (JMenu)e.getSource();
            menu1.setOpaque(false);
            menu1.setSelected(false);
        };
    };

    public static void main(String[] args) {
        Principal principal = new Principal();
    }


}
