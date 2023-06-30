public class TrieNode {
    TrieNode[] links = new TrieNode[26];
    boolean flag = false;

    boolean containsKey(char ch){
        return (links[ch - 'a']!=null);
    }

    boolean containsKey(int index){
        return (links[index]!=null);
    }

    TrieNode get(char ch){
        return links[ch - 'a'];
    }

    TrieNode get(int index){
        return links[index];
    }

    void put(char ch, TrieNode newNode){
        links[ch - 'a'] = newNode;
    }

    boolean isEnd(){
        return flag;
    }
}
