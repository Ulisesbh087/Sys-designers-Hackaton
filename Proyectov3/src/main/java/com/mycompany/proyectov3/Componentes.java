/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectov3;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

/**
 *
 * @author ALUMNO
 */
public class Componentes extends Canvas{// implements KeyListener{

    public JFrame frame(String titulo, int w, int h, LayoutManager l) {
        JFrame f = new JFrame();
        f.setTitle(titulo);
        f.setSize(w, h);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(l);

        //f.setVisible(true);
        return f;

    }
    
    

    public JFrame frame(String titulo, int w, int h) {
        JFrame f = new JFrame();
        f.setTitle(titulo);
        f.setSize(w, h);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //f.setVisible(true);
        return f;

    }
    /*
    public JFrame frame(String titulo, int w, int h) {
        JFrame f = new JFrame();
        f.addKeyListener(this);
        f.setFocusable(true);
        f.setFocusTraversalKeysEnabled(false);
        f.setTitle(titulo);
        f.setSize(w, h);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //f.setVisible(true);
        return f;

    }
    */

    public JCheckBox casilla(String descripcion) {
        //JCheckBox c=new JCheckBox();
        JCheckBox c = new JCheckBox(descripcion);
        //JCheckBox c=new JCheckBox(descripcion, true);
        return c;
    }

    public JRadioButton radio(String descripcion) {
        JRadioButton r = new JRadioButton();
        //JRadioButton r=new JRadioButton(descripcion);
        //JRadioButton r=new JRadioButton(descripcion, true);
        return r;
    }

    public JComboBox combo(Object elementos[]) {
        //JComboBox com=new JComboBox();

        JComboBox com = new JComboBox(elementos);
        return com;
    }

    public JTable table(int r, int c) {
        //JTable t=new JTable();
        JTable t = new JTable(r, c);
        return t;
    }

    public JList lista(Object elementos[]) {
        //JList l =new JList();
        JList l = new JList(elementos);
        return l;
    }

    //public JCheckBoxMenuItem menuCaja()
    //public JCheckBoxMenuItem menuCaja(Action a)
    //public JCheckBoxMenuItem menuCaja(Icon ico)
    //public JCheckBoxMenuItem menuCaja(String desc)
    //public JCheckBoxMenuItem menuCaja(String desc, b)
    //public JCheckBoxMenuItem menuCaja(String desc, boolean b)
    //public JCheckBoxMenuItem menuCaja(String desc, Icon)
    public JCheckBoxMenuItem menuCaja(String text, Icon ico, boolean b) {
        //JCheckBoxMenuItem jc =new JCheckBoxMenuItem();
        //JCheckBoxMenuItem jc =new JCheckBoxMenuItem(a);
        //JCheckBoxMenuItem jc =new JCheckBoxMenuItem(ico);
        //JCheckBoxMenuItem jc =new JCheckBoxMenuItem(desc);
        //JCheckBoxMenuItem jc =new JCheckBoxMenuItem(desc, b);
        //JCheckBoxMenuItem jc =new JCheckBoxMenuItem(desc, i);

        JCheckBoxMenuItem jc = new JCheckBoxMenuItem(text, ico, b);
        return jc;
    }

    public Color color(Color cl) {
        Color initialColor = Color.RED;
        Color c = JColorChooser.showDialog(null, "Select a color", initialColor);
        return c;
    }

    public JTabbedPane jt() {
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        JTabbedPane tp = new JTabbedPane();
        tp.add("Secction1", p1);
        tp.add("Secction2", p2);
        tp.add("Secction3", p3);
        return tp;
    }

    public JSlider slider() //public JSlider slider(int orientation)
    //public JSlider slider(int min, int max)
    //public JSlider slider(int min, int max, int value)
    //public JSlider slider(int orientation, int min, int max, int value)
    {
        JSlider jsl = new JSlider();
        return jsl;
    }

    public JSpinner spinner() //public JSpinner spinner()
    {
        JSpinner sp = new JSpinner();
        return sp;
    }

    public JDialog dialogo() //public JDialog dialogo(Frame owner)
    //public JDialog dialogo(Frame Owner, String title, boolean)
    {
        JDialog jd = new JDialog();
        return jd;
    }

    public JPanel panel() //public JPanel panel(boolean isDoubleBuffered)
    //public JPanel panel(LayoutManager layout)
    {
        JPanel jp = new JPanel();
        return jp;
    }

    public JFileChooser escogerArchivos() //public JFileChooser escogerArchivos(File currentDirectory)
    //public JFileChooser escogerArchivos(String currentDirectoryPath)
    {
        JFileChooser fc = new JFileChooser();
        return fc;
    }

    public JToolBar division() //public JToolBar division(int orientation)
    //public JToolBar division(String name)
    //public JToolBar division(String name, int orientation)
    {
        JToolBar jt = new JToolBar();
        return jt;
    }

    public JLayeredPane jl() {
        JLayeredPane jLayer = new JLayeredPane();
        return jLayer;
    }

    public JEditorPane editor() //public JEditorPane editor(String url)
    //public JEditorPane editor(String type, String text)
    //public JEditorPane editor(URL initialPage)
    {
        JEditorPane jEditor = new JEditorPane();
        return jEditor;
    }

    public JSplitPane split() //public JSplitPane split(int newOrientation)
    //public JSplitPane split(int newOrientation, boolean newContinuousLayout)
    {
        JSplitPane sp = new JSplitPane();
        return sp;
    }

    public JTextPane pane() //public JTextPane pane(StyleDocument doc)
    {
        JTextPane jr = new JTextPane();
        return jr;
    }

    public Image icoFrame() {
        Image icon = Toolkit.getDefaultToolkit().getImage("ruta imagen");
        return icon;
    }

    public void dibujar(Graphics g) {
        g.drawString("Programación Gráfica", 40, 40);
        setBackground(Color.GREEN);
        g.fillRect(130, 30, 100, 80);
        g.drawOval(30, 130, 50, 60);
        setForeground(Color.RED);
        g.fillOval(130, 130, 50, 60);
        g.drawArc(30, 200, 40, 50, 90, 60);
        g.fillArc(30, 130, 40, 50, 180, 40);
    }

    public JLabel etiqueta(String descripcion) {
        JLabel eti = new JLabel(descripcion);
        return eti;
    }

    public JTextField texto(int n) {
        JTextField c = new JTextField(n);
        return c;
    }

    public JButton boton(String descripcion) {
        JButton boton = new JButton(descripcion);

        return boton;
    }
}
