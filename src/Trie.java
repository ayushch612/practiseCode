import java.util.ArrayList;
import java.util.List;

class Trie {
    public static TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public List<String> lexicoGraphSort(){
        TrieNode node = root;
        List<String> res = new ArrayList<>();
        suggestions(node,res,"");
        return res;
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

    public StringBuilder longestCommonPrefix(TrieNode node, StringBuilder lcps){
        int count = 0;
        Integer key = null;
        for(int index = 0 ; index < 26; index++){
            if(node.containsKey(index)){
               count ++;
               key = index;
            }
        }
        if(count != 1){
            return lcps;
        }else{
            char ch  = (char)(key + 97);
            longestCommonPrefix(node.get(key), lcps.append(ch));
        }
        return lcps;
    }

    public static void main(String[] args) {
        Trie tn = new Trie();
        //tn.insert("apple");
        //tn.insert("app");
        //tn.insert("appxl");
        List<String> suggestions = tn.autoComplete("ap");
        for(String s : suggestions){
            System.out.println(s);
        }

        String s = "lexicographic sorting of a set of keys can be accomplished with " +
                "a simple trie based algorithm we insert all keys in a trie output " +
                "all keys in the trie by means of preorder traversal which results " +
                "in output that is in lexicographically increasing order preorder " +
                "traversal is a kind of depth first traversal";

        // split the given string to set of keys
        String[] dict = s.split(" ");

        for (String word: dict) {
            tn.insert(word);
        }

        List<String> sort = tn.lexicoGraphSort();
        for(String so : sort){
            System.out.println(so);
        }


        TrieNode node = root;
        StringBuilder res = new StringBuilder();
        System.out.println(tn.longestCommonPrefix(node,res));

        System.out.println(tn.search("apps"));
        System.out.println(tn.startsWith("apx"));
    }
}