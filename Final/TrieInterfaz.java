import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrieInterfaz {
    private Trie trie;
    private JFrame frame;
    private JTextField insertField, searchField, replaceSearchField, replaceReplaceField;

    public TrieInterfaz() {
        trie = new Trie();
        crearInterfaz();
    }

    private void crearInterfaz() {

        frame = new JFrame("Trie Interfaz"); //Creando new Jframe con titulo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Cerrar Jframe

        JTabbedPane tabbedPane = new JTabbedPane(); //Creando objeto Pestaña

        //Pestaña Insertar
        JPanel insertPanel = new JPanel(new BorderLayout());    //Jpanel para insertar
        insertField = new JTextField();                         //Creando objeto Jtext

        JButton insertButton = new JButton("Insertar");     //Creando objeto boton
        insertButton.addActionListener(new ActionListener() {   //Configurando ActionListener del boton
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = insertField.getText();    //Obteniendo Texto del objeto Jtext
                trie.insert(palabra);                      //Aplicando el metodo inserrt
                insertField.setText("");                 //Limpiando el objetoJtext
                printTrie();                                //Imprimiendo en consola para comprobar el Trie
            }
        });
        //Insertando los componentes a el panel Insertar usando BorderLayout para ubicar
        insertPanel.add(new JLabel("Insertar palabra: "), BorderLayout.WEST);  
        insertPanel.add(insertField, BorderLayout.CENTER);  
        insertPanel.add(insertButton, BorderLayout.EAST);
        tabbedPane.add("Insertar", insertPanel);    


        //Pestaña Buscar
        JPanel searchPanel = new JPanel(new BorderLayout());    //Jpanle para BUscar
        searchField = new JTextField();                         //Objeto para Jtext para campo de busqieda
        JButton searchButton = new JButton("Buscar");       //Creando boton

        searchButton.addActionListener(new ActionListener() { //Configurando Boton
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = searchField.getText();         //Obteniendo texto del campo
                boolean found = trie.search(palabra);           //Aplicando metodo search 
                JOptionPane.showMessageDialog(frame, "Palabra encontrada: " + found);   //Segun el resultado de search es true o false
                searchField.setText("");                    //Limpiando el campo de texto
            }
        });
        //Insertando los componentes a el panel Buscar usando BorderLayout para ubicar
        searchPanel.add(new JLabel("Buscar palabra: "), BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
        tabbedPane.add("Buscar", searchPanel);

        //Pestaña Reemplazar
        JPanel replacePanel = new JPanel(new BorderLayout());   //Jpanel para Reemplazar
        JPanel replaceInputPanel = new JPanel(new GridLayout(2, 2));    //Creando gridlayout con 2 filas y 2 columnas

        replaceSearchField = new JTextField();  //campo de texto para buscar
        replaceReplaceField = new JTextField(); //campo de texto para reemplazar
        JButton replaceButton = new JButton("Reemplazar");  //Creando boton reemplazar
        replaceButton.addActionListener(new ActionListener() {  //Configurando boton
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldWord = replaceSearchField.getText();  //Obteniendo palabra a remplazar
                String newWord = replaceReplaceField.getText(); //Obteniendo palabra con texto que va a reemplazar
                trie.replace(oldWord, newWord); //Aplicando el metodo replace
                replaceSearchField.setText(""); //Limpiando texto
                replaceReplaceField.setText("");    //Limpiando texto
                printTrie();    //Imprimir el trie en consola para comprobar
            }
        });
    //Insertando los componentes a el panel reemplazar
        replaceInputPanel.add(new JLabel("Buscar palabra a reemplazar: "));
        replaceInputPanel.add(replaceSearchField);
        replaceInputPanel.add(new JLabel("Reemplazar con: "));
        replaceInputPanel.add(replaceReplaceField);

        replacePanel.add(replaceInputPanel, BorderLayout.CENTER);
        replacePanel.add(replaceButton, BorderLayout.SOUTH);
        tabbedPane.add("Reemplazar", replacePanel);

    //Configurando el frame    
        frame.add(tabbedPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    //Imprimiendo el trie en interfaz
    private void printTrie() {
        System.out.println("Contenido del Trie:");
        trie.printTrie();
    }

  
}
