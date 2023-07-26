import java.util.HashMap;
import java.util.Map;

class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Map<Character, TrieNode> children = current.getChildren();
            TrieNode node = children.get(ch);

            if (node == null) {
                node = new TrieNode();
                children.put(ch, node);
            }

            current = node;
        }

        current.setWord(true);
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isWord();
    }

    private TrieNode searchNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Map<Character, TrieNode> children = current.getChildren();
            TrieNode node = children.get(ch);

            if (node == null) {
                return null;
            }

            current = node;
        }

        return current;
    }

    public void replace(String oldWord, String newWord) {
        TrieNode node = searchNode(oldWord);

        if (node != null && node.isWord()) {
            node.setWord(false);
            insert(newWord);
        }
    }

    //Metodos para imprimir el Trie en consola (Metodo extraido de stackoverflow)
    //se usa el root y un objeto StringBuilder en lugar de un string regular
    public void printTrie() {
        printTrieHelper(root, new StringBuilder()); 
    }
    //
    private void printTrieHelper(TrieNode node, StringBuilder currentWord) { //Se requiere como parametro un objeto Stringbuilder currentWord
        if (node.isWord()) {
            System.out.println(currentWord.toString()); //para imprimir el Stringbuilder se debe convertir a string primero
        }
        //Recorriendo los hijos del nodo
        for (Map.Entry<Character, TrieNode> entry : node.getChildren().entrySet()) {
            char ch = entry.getKey();   //Palabra en el nodo
            TrieNode childNode = entry.getValue();

            currentWord.append(ch); //Se agrega la palabra a el StringBuilder
            printTrieHelper(childNode, currentWord);
            currentWord.deleteCharAt(currentWord.length() - 1);
        }
    }
}
