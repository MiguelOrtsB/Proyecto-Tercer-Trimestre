package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Guitarras extends JFrame{

    private JPanel panelGuitarras;

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

        colocarPanelPrincipal();
        colocarLabelsGuitarras();

        setVisible(true);
    }

    private void colocarPanelPrincipal(){

        // PANEL

        panelGuitarras = new JPanel();
        panelGuitarras.setLayout(null);
        this.getContentPane().add(panelGuitarras);
        panelGuitarras.setBackground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(new Color(0x049B04), 4); //Diseñamos el borde del Panel (color y grosor)
        panelGuitarras.setBorder(border);
    }

    private void colocarLabelsGuitarras(){
        JLabel music = new JLabel("Guitarras");
        music.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE,120));
        music.setBounds(220, 25, 600, 100);
        music.setForeground(new Color(0x049B04));
        panelGuitarras.add(music);
    }

    public static void main(String[] args) {
        Guitarras guitarras = new Guitarras();
    }

}
