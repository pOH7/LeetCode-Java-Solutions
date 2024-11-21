package leetcode.template;

/**
 * @author zhanglei
 * @version 2024/11/20
 */
public class TrieTemplate {
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        insert(root, "apple");
        System.out.println(search(root, "apple")); // true
        System.out.println(search(root, "app")); // false
        System.out.println(startsWith(root, "app")); // true
        insert(root, "app");
        System.out.println(search(root, "app")); // true
    }

    // Insert a word into the trie
    public static void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }

    // Search for a word in the trie
    public static boolean search(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.word != null;
    }

    // Check if a prefix exists in the trie
    public static boolean startsWith(TrieNode root, String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Store the word at the end node
    }
}
