package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class Filtrar extends JFrame{

    private JPanel panelFiltrar;
    private JLabel labelLogo;
    private JButton atras;
    private JComboBox Filtro;
    private JTable guitarList;

    private MySQLConnection SQL = new MySQLConnection();

    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();

    public Filtrar(){
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

        colocarPanelFiltrar();
        colocarLabelsFiltrar();
        colocarBotonesFiltrar();

        setVisible(true);
    }

    private void colocarPanelFiltrar(){

        // PANEL

        panelFiltrar = new JPanel();
        panelFiltrar.setLayout(null);
        this.getContentPane().add(panelFiltrar);
        panelFiltrar.setBackground(new Color(0xDFFFDF));
        Border border = BorderFactory.createLineBorder(new Color(0x049B04), 4); //Diseñamos el borde del Panel (color y grosor)
        panelFiltrar.setBorder(border);
    }

    private void colocarLabelsFiltrar(){
        URL urlLogo = Proyecto.Login.class.getResource("Imagenes/Green-Devil-988x1024.png");
        ImageIcon image = new ImageIcon(urlLogo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        labelLogo = new JLabel(); //Label que contendrá el logo de la página
        labelLogo.setIcon(icon); //Le añadimos la imagen del logo
        labelLogo.setBounds(30, 5, 160, 120); //Establecemos su ubicación en el Panel
        panelFiltrar.add(labelLogo); //Añadimos el label al Panel

        Filtro = new JComboBox<>();
        Filtro.setBackground(new java.awt.Color(210, 210, 210));
        Filtro.setFont(new java.awt.Font("Source Sans Pro Black", Font.PLAIN, 15));
        Filtro.setBounds(570, 140, 100, 40);
        Filtro.setModel(new DefaultComboBoxModel<>(new String[] { "", "Gibson", "Fender", "ESP", "Yamaha", "Ibanez", "EVH" }));
        panelFiltrar.add(Filtro);

        ActionListener filtrarGuitar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // '"+Filtro.getSelectedItem().toString()+"'"
                String query = "SELECT * FROM guitarras WHERE Nombre_guitarra LIKE '%"+Filtro.getSelectedItem().toString()+"%'";
                try {
                    PreparedStatement preparedStatement = conn.prepareStatement(query); //Coge la conexión que tenemos configurada
                    ResultSet resultado = preparedStatement.executeQuery(query); //Ejecuta la consulta UPDATE de arriba (query) en la BBDD
                    guitarList.setModel(DbUtils.resultSetToTableModel(resultado));
                } catch (Exception exception) {
                    exception.printStackTrace(); //En caso de error muestra lo que ha ocurrido
                }
            }
        };
       Filtro.addActionListener(filtrarGuitar);


        /*String data[][]={ {"Gibson Slash Les Paul Standard","2599","Eléctrica", "1"},
                {"102","Jai","780000", "1"},
                {"101","Sachin","700000", "1"}};*/
        String column[]={"Nombre_guitarra","Precio","Tipo", "Disponibilidad"};

        guitarList = new JTable();
        guitarList.setBackground(new java.awt.Color(210, 210, 210));
        guitarList.setBounds(35, 200, 1200, 450);
        Border borderTable = BorderFactory.createLineBorder(Color.black, 1); //Diseñamos el borde del Panel (color y grosor)
        guitarList.setBorder(borderTable);
        panelFiltrar.add(guitarList);

        JLabel filtrar = new JLabel("Filtrar Marca:");
        filtrar.setFont(new Font("Impact", Font.ROMAN_BASELINE,15));
        filtrar.setBounds(480, 110, 500, 100);
        panelFiltrar.add(filtrar);

        JLabel music = new JLabel("BUSCAR");
        music.setFont(new Font("Impact", Font.ROMAN_BASELINE,70));
        music.setBounds(510, 10, 500, 100);
        music.setForeground(new Color(0x049B04));
        panelFiltrar.add(music);

        JMenuBar linea = new JMenuBar();
        linea.setBounds(4, 120, 1518, 6);
        linea.setBackground(new Color(0x049B04));
        panelFiltrar.add(linea);
    }

    private void colocarBotonesFiltrar(){
        atras = new JButton("↶Atrás");
        atras.setFont(new Font("Dialog", Font.PLAIN, 18));
        atras.setAlignmentX(Component.CENTER_ALIGNMENT);
        atras.setBounds(1135, 45, 100, 35);
        atras.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelFiltrar.add(atras);
    }

    private ResultSet FiltrarPorductos(){

        String query = "SELECT * FROM guitarras WHERE Nombre_guitarra LIKE '%"+ Filtro.getSelectedItem().toString()+"%'";
        ResultSet resultado = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query); //Coge la conexión que tenemos configurada
            resultado = preparedStatement.executeQuery(query); //Ejecuta la consulta UPDATE de arriba (query) en la BBDD
            //guitarList.setModel(DbUtils.resultSetToTableModel(resultado));
        } catch (Exception e) {
            e.printStackTrace(); //En caso de error muestra lo que ha ocurrido
        }
        return resultado;
    };

    public static void main(String[] args) {
        Filtrar filtrar = new Filtrar();
    }
}
