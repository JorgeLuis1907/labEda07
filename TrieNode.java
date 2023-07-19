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
