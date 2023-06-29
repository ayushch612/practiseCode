import java.util.ArrayList;
import java.util.List;

class Trie {
    public static TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(int i = 0 ; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.flag = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(int i = 0 ; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(int i = 0 ; i < prefix.length(); i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    public List<String> autoComplete(String prefix){
        TrieNode node  = root;
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < prefix.length(); i++){
            if(!node.containsKey(prefix.charAt(i))){
                return res;
            }
            node = node.get(prefix.charAt(i));
        }
        suggestions(node,res,prefix);
        return res;
    }

    private void suggestions(TrieNode node, List<String> res, String prefix) {
        //System.out.println("Prefix = " + prefix);
        if(node == null){
            return;
        }
        if(node.isEnd()){
            res.add(prefix);
        }
        for(int i = 0; i < 26; i++){
            char ch = (char)(i+97);
            //System.out.println(ch);
            suggestions(node.links[i],res, prefix + ch);
        }
    }

    public static void main(String[] args) {
        Trie tn = new Trie();
        tn.insert("apple");
        tn.insert("ap");
        tn.insert("apxl");
        List<String> suggestions = tn.autoComplete("ap");
        for(String s : suggestions){
            System.out.println(s);
        }
        System.out.println(tn.search("apps"));
        System.out.println(tn.startsWith("apx"));
    }
}