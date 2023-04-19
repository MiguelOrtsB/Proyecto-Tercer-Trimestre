package ProyectoTercerTrimestre;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.URL;

public class Login extends JFrame {
    public Login() {

        // FRAME

        setSize(690, 600);
        setTitle("\uD834\uDD1E Green Devil MusicStore \uD834\uDD1E");
        setLocationRelativeTo(null); // Establece la ventana en el centro de la pantalla
        Image iconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Green-Devil-988x1024.png"));
        setIconImage(iconImage);
        iniciarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){

        // PANEL (CONTENDRÁ TODOS LOS WIDGETS)

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.BLACK);

        Border border = BorderFactory.createLineBorder(Color.green, 4);
        panel.setBorder(border);

        // IMÁGEN LOGO

        URL urllogo = Graficos.Login_GreenDevil.class.getResource("Green-Devil-988x1024.png");
        ImageIcon image = new ImageIcon(urllogo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(260, 270, Image.SCALE_SMOOTH));

        // LABELS (TEXTO Y LOGO)

        JLabel label = new JLabel(); // Label que contendrá el logo de la página
        label.setIcon(icon); // Le añadimos la imagen del logo
        label.setBounds(230, 70, 260, 270);
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Lo alineamos al centro
        panel.add(label);

        JLabel label2 = new JLabel(); // Label del texto de bienvenida
        label2.setText("¡Bienvenido a Green Devil MusicStore!"); // Creamos el texto
        label2.setForeground(new Color(0x00FF00)); // Le añadimos un color al texto
        label2.setFont(new Font("Eras Bold ITC", Font.PLAIN,20)); // Le asignamos la fuente y el tamaño de la letra al texto
        label2.setBounds(160, 20, 400, 40);
        panel.add(label2);

        // CAMPOS DE TEXTO PARA INICIAR SESIÓN (USUARIO Y CONTRASEÑA)

        JTextField nombreUsuario = new JTextField("Nombre de usuario...");
        nombreUsuario.setBounds(170, 350, 340, 40);
        nombreUsuario.setForeground(new Color(0x049B04));
        nombreUsuario.setHorizontalAlignment(JTextField.CENTER);

        JPasswordField contraseña = new JPasswordField("Contraseña...");
        contraseña.setBounds(170, 410, 340, 40);
        contraseña.setForeground(new Color(0x049B04));
        contraseña.setHorizontalAlignment(JTextField.CENTER);

        // BOTONES DE INICIO DE SESIÓN Y REGISTRO

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBounds(275, 480, 130, 25);

        JButton registerButton = new JButton("Registrarse");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setBounds(560, 520, 100, 25);

        // AÑADIMOS BOTONES Y CAMPOS DE TEXTO AL PANEL



        panel.add(nombreUsuario);
        panel.add(contraseña);
        panel.add(loginButton);
        panel.add(registerButton);
        setVisible(true);
    }
}
