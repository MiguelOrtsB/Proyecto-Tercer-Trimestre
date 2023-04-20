package Proyecto;

import com.sun.jdi.PathSearchingVirtualMachine;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.geom.RoundRectangle2D;

public class Register extends JFrame {

    // INICIALIZAMOS TODAS LAS CLASES
    private JPanel panel;
    private JLabel label;
    private JLabel label2;
    private JTextField nombreUsuario;
    private JTextField correo;
    private JPasswordField contraseña;
    private JButton registerButton;
    private JCheckBox checkBox;
    private JCheckBox checkBox2;


    public Register() { //Constructor del Frame

        // FRAME

        setSize(690, 600); // Tamaño de la ventana (Frame)
        setTitle("\uD834\uDD1E Green Devil MusicStore \uD834\uDD1E"); // Título del Frame
        setLocationRelativeTo(null); // Establece la ventana en el centro de la pantalla
        Image iconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/Green-Devil-988x1024.png"));
        setIconImage(iconImage); // Establecemos el icono de la ventana
        iniciarComponentes(); // Llamamos al método que agrega el JPanel y todos los demás widgets
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establecemos que el programa se detenga al cerrar la ventana
    }

    private void iniciarComponentes(){ //Método para iniciar y agregar el Panel y todos sus componentes en el Frame

        colocarPanel();
        colocarLabels();
        colocarCamposTexto();
        colocarBotones();
        colocarCheckBox();

        setVisible(true); /*Solo hacemos visible el Panel para que se vean todos los elementos, puesto que si hiciéramos visible
        el Frame opacaría el Panel y no veríamos todos los widgets que contiene*/
    }

    private void colocarPanel(){

        // PANEL (CONTENDRÁ TODOS LOS WIDGETS)

        panel = new JPanel(); // Creamos Panel
        panel.setLayout(null); //Deshabilitamos el diseño por defecto para poder posicionar los widgets en el panel libremente
        this.getContentPane().add(panel); //Con "this" nos referimos al Frame, "getContent" su contenido y add para añadir el Panel
        panel.setBackground(Color.BLACK); //Color de fondo del Panel

        Border border = BorderFactory.createLineBorder(Color.green, 4); //Diseñamos el borde del Panel (color y grosor)
        panel.setBorder(border); //Añadimos el borde al Panel
    }

    private void colocarLabels(){

        // IMÁGEN LOGO

        URL urllogo = Proyecto.Login.class.getResource("Imagenes/Green-Devil-988x1024.png");
        ImageIcon image = new ImageIcon(urllogo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(260, 270, Image.SCALE_SMOOTH));

        // LABELS (TEXTO Y LOGO)

        /*label = new JLabel(); //Label que contendrá el logo de la página
        label.setIcon(icon); //Le añadimos la imagen del logo
        label.setBounds(230, 70, 260, 270); //Establecemos su ubicación en el Panel
        panel.add(label); //Añadimos el label al Panel*/

        label2 = new JLabel(); //Label del texto de bienvenida
        label2.setText("Únete a Green Devil"); //Creamos el texto
        label2.setForeground(new Color(0x00FF00)); //Le añadimos un color al texto
        label2.setFont(new Font("Eras Bold ITC", Font.PLAIN,26)); //Le asignamos la fuente y el tamaño de la letra al texto
        label2.setBounds(170, 40, 400, 40);
        panel.add(label2);
    }

    private void colocarCamposTexto(){

        // CAMPOS DE TEXTO PARA INICIAR SESIÓN (USUARIO Y CONTRASEÑA)

        nombreUsuario = new RoundJTextField(15); //Campo de texto para el nombre de usuario
        nombreUsuario.setBounds(170, 110, 340, 60);
        nombreUsuario.setForeground(new Color(0x049B04));
        nombreUsuario.setHorizontalAlignment(JTextField.CENTER); //Alineamos el texto en el centro del campo de texto
        nombreUsuario.setBorder(BorderFactory.createLineBorder(new Color(0x049B04), 3));
        panel.add(nombreUsuario);

        correo = new RoundJTextField(15); //Campo de texto para el nombre de usuario
        correo.setBounds(170, 200, 340, 60);
        correo.setForeground(new Color(0x049B04));
        correo.setHorizontalAlignment(JTextField.CENTER); //Alineamos el texto en el centro del campo de texto
        correo.setBorder(BorderFactory.createLineBorder(new Color(0x049B04), 3));
        panel.add(correo);

        contraseña = new JPasswordField("Contraseña..."); //Campo de texto para la contraseña
        contraseña.setBounds(170, 290, 340, 60);
        contraseña.setForeground(new Color(0x049B04));
        contraseña.setHorizontalAlignment(JTextField.CENTER); //Alineamos el texto en el centro del campo de texto
        contraseña.setBorder(BorderFactory.createLineBorder(new Color(0x049B04), 3)); //Color bordes del campo de texto
        panel.add(contraseña);
    }

    private void colocarCheckBox(){

        checkBox = new JCheckBox("Quiero recibir comunicaciones sobre promociones\n y novedades de Green Devil");
        checkBox.setBounds(170,360,500,50);
        checkBox.setForeground(new Color(0x049B04));
        checkBox.setBackground(Color.BLACK);
        panel.add(checkBox);

        checkBox2 = new JCheckBox("Acepto las condiciones de uso y de privacidad de Green Devil");
        checkBox2.setBounds(170,400,500,50);
        checkBox2.setForeground(new Color(0x049B04));
        checkBox2.setBackground(Color.BLACK);
        panel.add(checkBox2);

    }
    private void colocarBotones(){

        // BOTONES DE REGISTRO

        registerButton = new JButton("Registrarse"); //Botón de Registro
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setBounds(270, 470, 150, 40);
        //registerButton.setBorder(BorderFactory.);
        panel.add(registerButton);

    }
    public class RoundJTextField extends JTextField {

        // CLASE PARA BORDES REDONDOS DE CAMPOS DE TEXTO Y BOTONES
        private Shape shape;

        public RoundJTextField(int size) {
            super(size);
            setOpaque(false); // As suggested by @AVD in comment.
        }

        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 25, 25);
            super.paintComponent(g);
        }

        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 25, 25);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }
    public static void main(String[] args) {
        Register registro = new Register();
    }

}
