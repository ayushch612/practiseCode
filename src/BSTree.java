public class BSTree {
    TreeNode root;
    public BSTree(){
        root = null;
    }

    public TreeNode insert(TreeNode node, int dt){
        if(node == null){
            node = new TreeNode();
            node.data = dt;
            return node;
        }
        if (dt <= node.data)
            node.left = insert(node.left, dt);
        else if (dt > node.data)
            node.right = insert(node.right, dt);
        return node;
    }

    public TreeNode delete(TreeNode node, int key) {
        if (node == null) {
            return node;
        }

        if (key < node.data) {
            node.left = delete(node.left, key);
            return node;
        } else if (key > node.data) {
            node.right = delete(node.right, key);
            return node;
        }
        if(node.left == null){
            TreeNode temp = node.right;
            return temp;
        }else if (node.right == null){
            TreeNode temp = node.left;
            return temp;
        }else{
            TreeNode succParent = node;
            TreeNode successor = node.right;
            while(successor.left!=null){
                succParent = successor;
                successor = successor.left;
            }
            if(succParent != node){
                succParent.left = successor.right;
            }else{
                succParent.right = successor.left;
            }
            node.data = successor.data;
        }
        return node;
    }

    public static void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    public static void main(String[] args){
        BSTree tr = new BSTree();
        tr.root = tr.insert(tr.root,1);
        tr.insert(tr.root,50);
        tr.insert(tr.root,30);
        tr.insert(tr.root,80);
        tr.insert(tr.root,134);
        tr.insert(tr.root,66);
        tr.insert(tr.root,30);
        tr.insert(tr.root,81);
        tr.insert(tr.root,43);

        inOrder(tr.root);

        tr.root = tr.delete(tr.root,81);

        System.out.println();

        inOrder(tr.root);
    }

}
