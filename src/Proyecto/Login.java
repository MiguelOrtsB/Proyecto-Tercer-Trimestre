package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;

public class Login extends JFrame {

    // INICIALIZAMOS TODAS LAS CLASES

    private JPanel panel;
    private JLabel label;
    private JLabel label2;
    private JTextField nombreUsuario;
    private JPasswordField contraseña;
    private JButton loginButton;
    private JButton registerButton;

    public Login() { //Constructor del Frame

        // FRAME

        setSize(690, 600); // Tamaño de la ventana (Frame)
        setTitle("\uD834\uDD1E Green Devil MusicStore \uD834\uDD1E"); // Título del Frame
        setLocationRelativeTo(null); // Establece la ventana en el centro de la pantalla
        Image iconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/Green-Devil-988x1024.png"));
        setResizable(false); // Para que el usuario no pueda maximizar la pantalla y se quede en el tamaño establecido
        setIconImage(iconImage); // Establecemos el icono de la ventana
        iniciarComponentes(); // Llamamos al método que agrega el JPanel y todos los demás widgets
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establecemos que el programa se detenga al cerrar la ventana
        //testSQLConexion(); //Prueba para comprobar si se conecta la BBDD
    }

    /* Para comporbar si se conecta con la BBDD y cambia la disponibiliad a false de una guitarra en concreto (Ibanez)
    private void testSQLConexion() {
        try {
            ConsultasBBDD querys = new ConsultasBBDD();
            querys.ComprarGuitarra();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    // MÉTODO PARA INICIAR Y AGREGAR EL PANEL Y TODOS SU COMPONENTES AL FRAME

    private void iniciarComponentes(){ //Método para iniciar y agregar el Panel y todos sus componentes en el Frame

        colocarPanel();
        colocarLabels();
        colocarCamposTexto();
        colocarBotones();

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

        label = new JLabel(); //Label que contendrá el logo de la página
        label.setIcon(icon); //Le añadimos la imagen del logo
        label.setBounds(230, 70, 260, 270); //Establecemos su ubicación en el Panel
        panel.add(label); //Añadimos el label al Panel

        label2 = new JLabel(); //Label del texto de bienvenida
        label2.setText("¡Bienvenido a Green Devil MusicStore!"); //Creamos el texto
        label2.setForeground(new Color(0x00FF00)); //Le añadimos un color al texto
        label2.setFont(new Font("Eras Bold ITC", Font.PLAIN,20)); //Le asignamos la fuente y el tamaño de la letra al texto
        label2.setBounds(160, 20, 400, 40);
        panel.add(label2);
    }

    private void colocarCamposTexto(){

        // CAMPOS DE TEXTO PARA INICIAR SESIÓN (USUARIO Y CONTRASEÑA)

        nombreUsuario = new JTextField("Nombre de usuario..."); //Campo de texto para el nombre de usuario
        nombreUsuario.setBounds(170, 350, 340, 40);
        nombreUsuario.setForeground(new Color(0x049B04));
        nombreUsuario.setHorizontalAlignment(JTextField.CENTER); //Alineamos el texto en el centro del campo de texto
        nombreUsuario.setBorder(BorderFactory.createLineBorder(new Color(0x049B04), 3));
        panel.add(nombreUsuario);

        contraseña = new JPasswordField("Contraseña..."); //Campo de texto para la contraseña
        contraseña.setBounds(170, 410, 340, 40);
        contraseña.setForeground(new Color(0x049B04));
        contraseña.setHorizontalAlignment(JTextField.CENTER); //Alineamos el texto en el centro del campo de texto
        contraseña.setBorder(BorderFactory.createLineBorder(new Color(0x049B04), 3)); //Color bordes del campo de texto
        panel.add(contraseña);
    }

    private void colocarBotones(){

        // BOTONES DE INICIO DE SESIÓN Y REGISTRO

        loginButton = new JButton("Iniciar Sesión"); //Botón de Inicio de Sesión
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBounds(275, 480, 130, 25);
        panel.add(loginButton);

        registerButton = new JButton("Registrarse"); //Botón de Registro
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setBounds(560, 520, 100, 25);
        panel.add(registerButton);

        // EVENTO ACTIONLISTENER (UNA VEZ INICIADO SESIÓN ACCEDEMOS A LA VENTANA PRINCIPAL DE LA WEB)

        ActionListener oyenteDeAccion = new ActionListener() { //Agregando evento de tipo ActionListener
            @Override
            public void actionPerformed(ActionEvent e) {

                // VAMOS A COMPARAR SI LO INTRODUCIDO POR EL SUPUESTO USUARIO Y LA BBDD COINCIDEN (NOMBRE USUARIO Y CONTRASEÑA)

                String usuarioInput = nombreUsuario.getText(); //Guardamos en una variable el nombre de usuario introducido en el Login
                String passwordInput= contraseña.getText(); //Guardamos en una variable la contraseña introducida en el Login por el user
                ConsultasBBDD obtenerUsuarioBaseDeDatos = new ConsultasBBDD(); //Instaciamos la clase donde tenemos todas las consultas
                try {
                    ResultSet usuarios = obtenerUsuarioBaseDeDatos.ObtenerUsuarioBBDD(); // Recupera los usuario de nuestra BBDD
                    while (usuarios.next()) { //Recorre los usuarios que acabamos de recuperar
                        String usuarioBBDD = usuarios.getString("Nombre_usuario"); //Recupera y asigna en una variable el ussername
                        String passBBDD = usuarios.getString("contraseña"); //Recupera y asigna en una variable el password
                        System.out.println(usuarioBBDD + "\t" + passBBDD);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


                boolean mensaje = false;
                /* for(int i = 0; i < Usuarios.length; i++){
                    if(Usuarios[i].equals(usuario)&&Claves[i].equals(password)){
                        mensaje=true;            }
                }
                if(mensaje){
                    setVisible(false); //Para que se cierre la pestaña anterior de Login una vez accedamos a la principal
                    Principal principal = new Principal();
                    principal.setVisible(true);


                }else {
                    JOptionPane.showMessageDialog(null, "Usario o contraseña incorrectos");
                    nombreUsuario.setText("");
                    contraseña.setText("");
                }*/
            }
        };
        loginButton.addActionListener(oyenteDeAccion); //Le agreamos al botón de Iniciar Sesión el evento ActionListener

        // EVENTO ACTIONLISTENER (UNA VEZ EN LA PANTALLA DE LOGIN ACCEDEMOS A LA VENTANA PARA REGISTRARSE)

        ActionListener accederRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false); //Para cerrar la ventana de Login una vez hagamos click en el botón de Registro
                Register registro = new Register();
                registro.setVisible(true);
            }
        };
        registerButton.addActionListener(accederRegister);
    }
}
