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

    // INICIALIZAMOS LAS DIFERENTES CLASES (LABELS, BOTONES, COMBOBOX, TABLE...)

    private JPanel panelFiltrar;
    private JLabel labelLogo;
    private JButton atras;
    private JComboBox Filtro;
    private JComboBox FiltroPrecio;
    private JComboBox FiltroTipo;
    private JTable guitarList;

    //CONEXIONES

    private MySQLConnection SQL = new MySQLConnection();

    private Connection conn = SQL.conectarMySQL();

    public Filtrar(){ //Constructor

        // FRAME

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

        panelFiltrar = new JPanel(); //Creamos el Panel
        panelFiltrar.setLayout(null); //Deshabilitamos el diseño por defecto para poder posicionar los widgets en el panel libremente
        this.getContentPane().add(panelFiltrar); //Con "this" nos referimos al Frame, "getContent" su contenido y add para añadir el Panel
        panelFiltrar.setBackground(new Color(0xDFFFDF)); //Color de fondo
        Border border = BorderFactory.createLineBorder(new Color(0x049B04), 4); //Diseñamos el borde del Panel (color y grosor)
        panelFiltrar.setBorder(border); //Añadimos el borde anterior
    }

    private void colocarLabelsFiltrar(){

        //IMÁGEN LOGO

        URL urlLogo = Proyecto.Login.class.getResource("Imagenes/Green-Devil-988x1024.png");
        ImageIcon image = new ImageIcon(urlLogo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        labelLogo = new JLabel(); //Label que contendrá el logo de la página
        labelLogo.setIcon(icon); //Le añadimos la imagen del logo
        labelLogo.setBounds(30, 5, 160, 120); //Establecemos su ubicación en el Panel
        panelFiltrar.add(labelLogo); //Añadimos el label al Panel

        //COMBO BOX + MÉTODOS PARA FILTRAR LA BÚSQUEDA

        Filtro = new JComboBox<>();
        Filtro.setBackground(new java.awt.Color(210, 210, 210));
        Filtro.setFont(new java.awt.Font("Source Sans Pro Black", Font.PLAIN, 15));
        Filtro.setBounds(640, 140, 100, 40);
        Filtro.setModel(new DefaultComboBoxModel<>(new String[] { "", "Gibson", "Fender", "ESP", "Yamaha", "Ibanez", "EVH", "Jackson" }));
        panelFiltrar.add(Filtro);

        FiltroPrecio = new JComboBox<>();
        FiltroPrecio.setBackground(new java.awt.Color(210, 210, 210));
        FiltroPrecio.setFont(new java.awt.Font("Source Sans Pro Black", Font.PLAIN, 15));
        FiltroPrecio.setBounds(300, 140, 105, 40);
        FiltroPrecio.setModel(new DefaultComboBoxModel<>(new String[] {"", "< 500", "500 - 1000", "1000 - 2500", "> 2500"}));
        panelFiltrar.add(FiltroPrecio);

        FiltroTipo = new JComboBox<>();
        FiltroTipo.setBackground(new java.awt.Color(210, 210, 210));
        FiltroTipo.setFont(new java.awt.Font("Source Sans Pro Black", Font.PLAIN, 15));
        FiltroTipo.setBounds(954, 140, 100, 40);
        FiltroTipo.setModel(new DefaultComboBoxModel<>(new String[] {"", "Eléctrica", "Acústica"}));
        panelFiltrar.add(FiltroTipo);

        // FILTRAR POR MARCAS
        ActionListener filtrarGuitar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "SELECT Nombre_guitarra, Precio, Tipo, Disponibilidad FROM guitarras WHERE Nombre_guitarra LIKE '%"+Filtro.getSelectedItem().toString()+"%' ORDER BY Precio ASC";
                try {
                    PreparedStatement preparedStatement = conn.prepareStatement(query); //Coge la conexión que tenemos configurada
                    ResultSet resultado = preparedStatement.executeQuery(query); //Ejecuta la consulta SELECT de arriba (query) en la BBDD
                    guitarList.setModel(DbUtils.resultSetToTableModel(resultado)); //Muestra en la tabla el resultado de la query
                } catch (Exception exception) {
                    exception.printStackTrace(); //En caso de error muestra lo que ha ocurrido
                }
            }
        };
       Filtro.addActionListener(filtrarGuitar);

        // FILTRAR POR PRECIOS (NOS DEVOLVERÁ UNO DE LAS OPCIONES)
        ActionListener filtrarPrecios = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "";
                switch(FiltroPrecio.getSelectedItem().toString()){
                    case "":
                        query = "SELECT Nombre_guitarra, Precio, Tipo, Disponibilidad FROM guitarras";
                        break;
                    case "< 500":
                        query = "SELECT Nombre_guitarra, Precio, Tipo, Disponibilidad FROM guitarras WHERE Precio < 500 ORDER BY Precio ASC";
                        break;
                    case "500 - 1000":
                        query = "SELECT Nombre_guitarra, Precio, Tipo, Disponibilidad FROM guitarras WHERE Precio BETWEEN 500 AND 1000 ORDER BY Precio ASC";
                        break;
                    case "1000 - 2500":
                        query = "SELECT Nombre_guitarra, Precio, Tipo, Disponibilidad FROM guitarras WHERE Precio BETWEEN 1000 AND 2500 ORDER BY Precio ASC";
                        break;
                    case "> 2500":
                        query = "SELECT Nombre_guitarra, Precio, Tipo, Disponibilidad FROM guitarras WHERE Precio > 2500 ORDER BY Precio ASC";
                        break;
                }
                try {
                    PreparedStatement preparedStatement = conn.prepareStatement(query); //Coge la conexión que tenemos configurada
                    ResultSet resultado = preparedStatement.executeQuery(query); //Ejecuta la consulta SELECT de arriba (query) en la BBDD
                    guitarList.setModel(DbUtils.resultSetToTableModel(resultado)); //Muestra en la tabla el resultado de la query
                } catch (Exception exception) {
                    exception.printStackTrace(); //En caso de error muestra lo que ha ocurrido
                }
            }
        };
        FiltroPrecio.addActionListener(filtrarPrecios); //Añadimos el método Actionlister al Combobox

        // FILTRAR POR TIPO
        ActionListener filtrarTipoGuitarra = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "SELECT Nombre_guitarra, Precio, Tipo, Disponibilidad FROM guitarras WHERE Tipo = '"+FiltroTipo.getSelectedItem().toString()+"'";
                try {
                    PreparedStatement preparedStatement = conn.prepareStatement(query); //Coge la conexión que tenemos configurada
                    ResultSet resultado = preparedStatement.executeQuery(query); //Ejecuta la consulta SELECT de arriba (query) en la BBDD
                    guitarList.setModel(DbUtils.resultSetToTableModel(resultado)); //Muestra en la tabla el resultado de la query
                } catch (Exception exception) {
                    exception.printStackTrace(); //En caso de error muestra lo que ha ocurrido
                }
            }
        };
        FiltroTipo.addActionListener(filtrarTipoGuitarra);


       //TABLA

        String data[][]={ {"ESP LTD GH-200 BLK","749.0","Eléctrica", "--"},
                {"ESP LTD GL-200MT","749.0","Eléctrica", "--"},
                {"EVH Striped Series","1359.0","Eléctrica", "--"},
                {"Fender Malibu Acoustic", "310.0", "Acústica", "--"},
                {"Fender Kurt Cobain Jaguar", "1555.0", "Eléctrica", "--"},
                {"Fender Telecaster Custom 60", "2599.0", "Eléctrica", "--"},
                {"Gibson SG Standard 61", "1890.0", "Eléctrica", "--"},
                {"Gibson Explorer Antique Natural", "1899.0", "Eléctrica", "--"},
                {"Gibson Slash Les Paul Standard", "2699.0", "Eléctrica", "--"},
                {"Gibson 1960 Hummingbird", "4980.0", "Acústica", "--"},
                {"Ibanez XPTB720", "1299.0", "Eléctrica", "--"},
                {"Jackson SL3X DX", "719.0", "Eléctrica", "--"},
                {"Yamaha F325 Acoustic", "169.0", "Acústica", "--"},
                {"Yamaha AC1M II TBS", "748.0", "Acústica", "--"}};

        String column[]={"Nombre Guitarra","Precio","Tipo","Disponibilidad"};

        guitarList = new JTable(data, column); //Creamos la tabla
        guitarList.setBackground(new java.awt.Color(210, 210, 210)); //Color de fondo
        guitarList.setBounds(130, 220, 1000, 420); //Posicionamiento y tamaña en el Panel
        guitarList.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15)); //Tipo de fuente
        Border borderTable = BorderFactory.createLineBorder(Color.black, 1); //Diseñamos el borde del Panel (color y grosor)
        guitarList.setBorder(borderTable);
        panelFiltrar.add(guitarList);

        //LABELS VARIOS (INFORMACIÓN ACERCA DE LOS FILTROS Y LA TABLA)

        JLabel filtrar = new JLabel("Filtrar Marca:");
        filtrar.setFont(new Font("Impact", Font.ROMAN_BASELINE,15));
        filtrar.setBounds(545, 110, 500, 100);
        panelFiltrar.add(filtrar);

        JLabel filtrarPrec = new JLabel("Filtrar Precio:");
        filtrarPrec.setFont(new Font("Impact", Font.ROMAN_BASELINE,15));
        filtrarPrec.setBounds(204, 110, 500, 100);
        panelFiltrar.add(filtrarPrec);

        JLabel filtrarTipo = new JLabel("Filtrar Tipo:");
        filtrarTipo.setFont(new Font("Impact", Font.ROMAN_BASELINE,15));
        filtrarTipo.setBounds(872, 110, 500, 100);
        panelFiltrar.add(filtrarTipo);

        JLabel music = new JLabel("BUSCAR");
        music.setFont(new Font("Impact", Font.ROMAN_BASELINE,70));
        music.setBounds(530, 10, 500, 100);
        music.setForeground(new Color(0x049B04));
        panelFiltrar.add(music);

        JLabel nombre = new JLabel("Nombre");
        nombre.setFont(new Font("Source Sans Pro Black", Font.ROMAN_BASELINE,16));
        nombre.setBounds(131, 155, 100, 100);
        nombre.setForeground(new Color(0x049B04));
        panelFiltrar.add(nombre);

        JLabel precio = new JLabel("Precio(€)");
        precio.setFont(new Font("Source Sans Pro Black", Font.ROMAN_BASELINE,16));
        precio.setBounds(380, 155, 100, 100);
        precio.setForeground(new Color(0x049B04));
        panelFiltrar.add(precio);

        JLabel tipo = new JLabel("Tipo");
        tipo.setFont(new Font("Source Sans Pro Black", Font.ROMAN_BASELINE,16));
        tipo.setBounds(630, 155, 100, 100);
        tipo.setForeground(new Color(0x049B04));
        panelFiltrar.add(tipo);

        JLabel disponibilidad = new JLabel("Disponibilidad");
        disponibilidad.setFont(new Font("Source Sans Pro Black", Font.ROMAN_BASELINE,16));
        disponibilidad.setBounds(879, 155, 130, 100);
        disponibilidad.setForeground(new Color(0x049B04));
        panelFiltrar.add(disponibilidad);

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

        ActionListener accederPrincipal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false); //Para cerrar la ventana de Buscar una vez hagamos click en el botón de "Atrás"
                new Principal().setVisible(true); //Instanciamos y hacemos visible de nuevo la ventana principal de la app
            }
        };
        atras.addActionListener(accederPrincipal);
    }
}
