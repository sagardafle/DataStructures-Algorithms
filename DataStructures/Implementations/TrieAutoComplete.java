import java.util.*;
// Trie node class
class Node {
    String prefix;
    HashMap < Character, Node > children;

    // Does this node represent the last character in a word?
    boolean isWord;

    public Node(String prefix) {
        this.prefix = prefix;
        this.children = new HashMap < Character, Node > ();
    }
}
public class TrieAutoComplete {
    // The trie
    private Node trie;

    // Construct the trie from the dictionary
    public TrieAutoComplete(String[] dict) {
        trie = new Node("");
        for (String s: dict) insertWord(s);
         System.out.println("AFTER INSERT: Trie details: Prefix: "+trie.prefix+"Children: "+trie.children);
    }

    // Insert a word into the trie
    private void insertWord(String s) {
        // Iterate through each character in the string. If the character is not
        // already in the trie then add it
        System.out.println("Trie details: Prefix: "+trie.prefix+"Children: "+trie.children);
        Node curr = trie;
        for (int i = 0; i < s.length(); i++) {
            if (!curr.children.containsKey(s.charAt(i))) {
                System.out.println("Adding "+s.charAt(i)+" to the tree");
                curr.children.put(s.charAt(i), new Node(s.substring(0, i + 1)));
            }
            curr = curr.children.get(s.charAt(i));
            if (i == s.length() - 1) curr.isWord = true;
        }
    }

    // Find all words in trie that start with prefix
    public List < String > getWordsForPrefix(String pre) {
        List < String > results = new LinkedList < String > ();

        // Iterate to the end of the prefix
        Node curr = trie;
        for (char c: pre.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return results;
            }
        }

        // At the end of the prefix, find all child words
        findAllChildWords(curr, results);
        return results;
    }

    // Recursively find every child word
    private void findAllChildWords(Node n, List < String > results) {
        System.out.println("###Searching: "+n.prefix);
        if (n.isWord) results.add(n.prefix);
        for (Character c: n.children.keySet()) {
            findAllChildWords(n.children.get(c), results);
        }
    }

    public static void main(String[] args) {
        // String[] dictionary = {
        //     "abc",
        //     "acd",
        //     "bcd",
        //     "bf",
        //     "a",
        //     "aba"
        // };
        String[] dictionary = {
            "their",
            "there"
        };
        TrieAutoComplete obj = new TrieAutoComplete(dictionary);
        List < String > autocompleteresults = obj.getWordsForPrefix("the");
        System.out.println(autocompleteresults);
    }
}