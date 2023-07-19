import java.util.Map;

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
}