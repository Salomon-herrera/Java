import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        window window = new window();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}

class window extends JFrame {
    public window() {
        setBounds(300, 300, 600, 800);
        setTitle("EditorTextoJava");
        add(new Panel());
    }
}

class panel extends JPanel{
    public panel(){

        // Start Menu
        JPanel panelMenu = new JPanel();

        menu = new JMenuBar();
        archive = new JMenu("Archive");
        edit = new JMenu("Edit");
        selection = new JMenu("Selection");
        view = new JMenu("View");
        appearance = new JMenu("Appearance");

        menu.add(archive);
        menu.add(edit);
        menu.add(selection);
        menu.add(view);

        // menu archivo
        createItem("New File", "Archive", "New");
        createItem("Open File", "Archive", "Open");
        archive.addSeparator();
        createItem("Save", "Archive", "Save");
        createItem("Save as", "Archive", "SaveAs");

        //menu editar
        createItem("Undo", "Edit", "Undo");
        createItem("Redo", "Edit", "Redo");
        edit.addSeparator();
        createItem("Cut", "Edit", "Cut");
        createItem("Copy", "Edit", "Copy");
        createItem("Paste", "Edit", "Paste");

        //menu seleccionar
        createItem("Select All", "Selection", "");
        createItem("Select", "Selection", "");

        //menu ver
        createItem("Numeration", "View", "");
        view.add(appearance);
        createItem("Light", "Appearance","");
        createItem("Dark", "Appearance","");

        panelMenu.add(menu);
        //End Menu

        //Start Area de Texto
        tPane = new JTabbedPane();

        listFile = new ArrayList<File>();
        listAreaTexto = new ArrayList<JTextPane>();
        listScroll = new ArrayList<JScrollPane>();



        //End Area de Texto

        //createPanel();

        add(panelMenu);
        add(tPane);
    }
    public void createItem(String rotulo, String menu, String accion){
        elementoItem = new JMenuItem(rotulo);
        
        if (menu.equals("Archive")) {
            archive.add(elementoItem);
            if (accion.equals("New")) {
                elementoItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        createPanel();
                    }
                });
            } else if (accion.equals("Open")) {
                elementoItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                
            }
        } else if (menu.equals("Edit")) {
            edit.add(elementoItem);
        } else if (menu.equals("Selection")) {
            selection.add(elementoItem);
        } else if (menu.equals("View")) {
            view.add(elementoItem);
        } else if (menu.equals("Appearance")){
            appearance.add(elementoItem);
        }
    }
    public void createPanel(){
        ventana = new JPanel();

        listFile.add(new File(""));
        listAreaTexto.add(new JTextPane());
        listScroll.add(new JScrollPane(listAreaTexto.get(contadorPanel)));

        ventana.add(listScroll.get(contadorPanel));

        tPane.addTab("Title",ventana);
        contadorPanel++;
        existePanel = true;
    }

    private  int contadorPanel = 0;
    private boolean existePanel = false;

    private JTabbedPane tPane;
    private JPanel ventana;
    private ArrayList<JTextPane> listAreaTexto;
    private ArrayList<JScrollPane> listScroll;
    private ArrayList<File> listFile;
    private JMenuBar menu;
    private JMenu archive, edit, selection, view, appearance;
    private JMenuItem elementoItem;
}
