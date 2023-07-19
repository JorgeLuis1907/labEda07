public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insertar palabras en el trie
        trie.insert("hola");
        trie.insert("adiós");
        trie.insert("hoy");
        trie.insert("mañana");

        // Buscar palabras en el trie
        System.out.println(trie.search("hola")); // true
        System.out.println(trie.search("bye"));  // false

        // Reemplazar palabras en el trie
        trie.replace("hola", "hello");
        System.out.println(trie.search("hola"));  // false
        System.out.println(trie.search("hello")); // true
    }
}