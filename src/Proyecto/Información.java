package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Información extends JFrame {

    // INICIALIZAMOS LAS CLASES

    private JPanel panelInfo;
    private Image imagen;
    private JButton back;
    FondoPanel fondoPanelcillo = new FondoPanel();

    public Información (){ //Constructor principal

        // FRAME

        fondoPanelcillo.setLayout(null); //Deshabilitamos el diseño por defecto para poder posicionar los widgets en el panel libremente
        setSize(1280, 720); //Tamaño del frame
        setContentPane(fondoPanelcillo); //Método para que el Frame contenga el Panel
        Border border = BorderFactory.createLineBorder(Color.BLACK, 4); //Diseñamos el borde del Panel (color y grosor)
        fondoPanelcillo.setBorder(border); //Aplicamos el borde
        setLocationRelativeTo(null); //Coloca el Frame justo en el centro de la pantalla
        setResizable(false); //No deja al usuario redimensionar la ventana
        setTitle("\uD834\uDD1E Green Devil MusicStore \uD834\uDD1E"); // Título del Frame
        Image iconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/Green-Devil-988x1024.png"));
        setIconImage(iconImage); // Establecemos el icono de la ventana
        initComponentesInfo(); //Iniciamos los componentes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerramos como operación por defecto
    }

    public void initComponentesInfo(){

        //MÉTODO PARA INCIAR TODOS LOS COMPONENTES EN EL FRAME

        colocarLabelsInfo();
        colocarBotonesInfo();
        setVisible(true);
    }

    /*public void colocarPanelInfo(){
        panelInfo = new JPanel();
        this.add(panelInfo);
        panelInfo.setBackground(new Color(0xDFFFDF));
        Border border = BorderFactory.createLineBorder(new Color(0x049B04), 4); //Diseñamos el borde del Panel (color y grosor)
        panelInfo.setBorder(border);
    }*/

    public void colocarLabelsInfo(){

        // LABELS PARA EL TÍTULO Y EL TEXTO DEL PANEL

        JLabel who = new JLabel(" ¿Quiénes somos?");
        who.setFont(new Font("Impact", Font.PLAIN, 40));
        who.setForeground(Color.BLACK);
        who.setBackground(new Color(0xE9E9E9));
        who.setOpaque(true);
        who.setBounds(475, 15, 320, 80);
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 4); //Diseñamos el borde del Panel (color y grosor)
        who.setBorder(border1);
        getContentPane().add(who);

        URL urlLogoInfo = Proyecto.Principal.class.getResource("Imagenes/Green-Devil-988x1024.png");
        ImageIcon imagenInfo = new ImageIcon(urlLogoInfo);
        Icon iconoInfo = new ImageIcon(imagenInfo.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
        JLabel imagenLogoInfo = new JLabel();
        imagenLogoInfo.setIcon(iconoInfo);
        imagenLogoInfo.setBounds(850, 555, 300, 130);
        getContentPane().add(imagenLogoInfo);

        JLabel texto = new JLabel();
        texto.setBounds(265, 150, 730, 360);
        texto.setText("<html><p>Somos una tienda especializada en instrumentos musicales de Palma de Mallorca.<br>" +
                "Nuestra experiencia se remonta a 1995, cuando abrimos nuestra tienda con el objetivo<br>" +
                "de aportar nuestro granito de arena para que todos los aficionados a la música de<br>" +
                "nuestra ciudad pudieran hacer realidad su deseo de obtener consejo para iniciarse en<br>" +
                "este hobby o simplemente adquirir un nuevo instrumento acorde a sus necesidades.<br>" +
                "<br>" +
                "Desde entonces, somos la tienda de confiaza para mucha gente, es por esta razón que<br>" +
                "nos consideramos expertos principalmente en instrumentos de cuerda <strong><i>(guitarras <br>" +
                "eléctricas, guitarras acústicas y bajos)</i></strong> así como todo tipo de complementos de éstos.<br>" +
                "Todo ello enfocado a estilos clásicos como Blues o Rock, hasta los estilos más pesados del<br>" +
                "Heavy Metal.<br>" +
                "<br>" +
                "¡Esperamos verte pronto!<br>" +
                "Atentamente, el equipo de Green Devil MusicStore." +
                "</p></html>");
        texto.setFont(new Font("Calibri", Font.BOLD, 20));
        texto.setBackground(new Color(0xE9E9E9));
        texto.setOpaque(true);
        texto.setBorder(border1);
        getContentPane().add(texto);

        JLabel contacto = new JLabel();
        contacto.setBounds(930, 520, 400, 200);
        contacto.setText("<html><p><strong>Correo:</strong> greendevilmusicstore@gmail.com<br>" +
                "<strong>Teléfono:</strong> 971 80 90 97<br>" +
                "<strong>Dirección:</strong> C/ Barón de Pinopar Nº19, Palma</p></html>");
        contacto.setFont(new Font("Candara", Font.PLAIN, 17));
        contacto.setForeground(new Color(0xE9E9E9));
        getContentPane().add(contacto);

        JLabel version = new JLabel("Versión 1.01");
        version.setBounds(20, 10, 100, 30);
        version.setFont(new Font("Candara", Font.PLAIN, 20));
        version.setForeground(new Color(0xE9E9E9));
        getContentPane().add(version);

        JLabel autor = new JLabel("Powered by MikeSolutions");
        autor.setBounds(20, 30, 180, 30);
        autor.setFont(new Font("Candara", Font.PLAIN, 15));
        autor.setForeground(new Color(0xE9E9E9));
        getContentPane().add(autor);
    }

    private void colocarBotonesInfo(){

        // BOTÓN PARA VOLVER HACIA ATRÁS

        back = new JButton("↶Atrás");
        back.setFont(new Font("Dialog", Font.PLAIN, 18));
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setBounds(1140, 20, 100, 35);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getContentPane().add(back);

        ActionListener accederRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false); //Para cerrar la ventana de Información una vez hagamos click en el botón de "Atrás"
                new Principal().setVisible(true); //Instanciamos y hacemos visible de nuevo la ventana principal de la app
            }
        };
        back.addActionListener(accederRegister); //Añadimos el método ActionListener a la subopción de "¿Quiénes somos?"
    }

    // MÉTODO DENTRO DE LA CLASE PARA ESTABLECER UNA IMÁGEN COMO FONDE DE PANTALLA
    class FondoPanel extends JPanel{
        @Override
        public void paint(Graphics g){

            imagen = new ImageIcon(getClass().getResource("Imagenes/electricwall-1.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
