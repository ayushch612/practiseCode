
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
    public static void main(String[] args) {
        Trie tn = new Trie();
        tn.insert("apple");
        tn.insert("apps");
        tn.insert("apxl");
        System.out.println(tn.search("apps"));
        System.out.println(tn.startsWith("apx"));
    }
}