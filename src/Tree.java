import java.util.*;

public class Tree {
    private TreeNode root;

    private final Values val = new Values();

    public static class Values {
        private int min;
        private int max;
    }

    public static class QueueObj {
        private TreeNode tn;
        private int hd;

        public QueueObj(TreeNode node, int hd){
            tn = node;
            this.hd = hd;
        }
    }

    public void printVerticalOrder(TreeNode node, int lineNo ,int dp){
        if(node == null){
            return;
        }
        if(lineNo == dp){
            System.out.print(node.data + " ");
        }
        printVerticalOrder(node.left,lineNo ,dp - 1);
        printVerticalOrder(node.right,lineNo ,dp + 1);
    }
    public void verticalOrder(TreeNode root){
        minMaxValues(root,0);

        for(int i = val.min; i <= val.max; i++){
            System.out.print(i + " -> ");
            printVerticalOrder(root,i,0);
            System.out.println();
        }
    }

    private void minMaxValues(TreeNode node, int dp) {
        if(node == null){
            return;
        }
        if(val.min > dp){
            val.min = dp;
        }
        if(val.max < dp){
            val.max = dp;
        }
        minMaxValues(node.left, dp-1);
        minMaxValues(node.right, dp + 1);
    }

    public void insert(int data){
        Queue<TreeNode> qh = new LinkedList<>();
        TreeNode temp = root;
        TreeNode newNode = new TreeNode();
        newNode.data = data;
        if(root == null) {
            root = newNode;
            return;
        }
        qh.add(temp);
        while(!qh.isEmpty())
        {
            temp = qh.remove();
            if(temp.left!=null){
                qh.add(temp.left);
            }else{
                temp.left = newNode;
                qh.clear();
                return;
            }
            if(temp.right!=null){
                qh.add(temp.right);
            }else{
                temp.right = newNode;
                qh.clear();
                return;
            }
        }
    }


    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void rightView(TreeNode node){
        if(node == null){
            return;
        }
        Queue<TreeNode> qh = new LinkedList<>();
        qh.add(node);
        TreeNode temp;
        while (!qh.isEmpty()){
            int n = qh.size();

            for(int i = 0; i < n; i++){
                temp = qh.remove();

                if(i == n-1){
                    System.out.print(temp.data + " ");
                }
                if(temp.left != null){
                    qh.add(temp.left);
                }
                if(temp.right != null){
                    qh.add(temp.right);
                }
            }
        }
    }

    public static void leftView(TreeNode node){
        if(node == null){
            return;
        }
        Queue<TreeNode> qh = new LinkedList<>();
        qh.add(node);
        TreeNode temp;
        while (!qh.isEmpty()){
            int n = qh.size();
            for(int i = 0; i < n; i++){
                temp = qh.remove();
                if(i == 0){
                    System.out.print(temp.data + " ");
                }
                if(temp.left != null){
                    qh.add(temp.left);
                }
                if(temp.right != null){
                    qh.add(temp.right);
                }
            }
        }
    }

    public void topView(TreeNode root){
        if(root == null){
            return;
        }
        minMaxValues(root,0);
        Map<Integer, Integer> map = new HashMap<>();
        map = printTopView(root,map);
        for(int i = val.min; i <= val.max; i++){
            System.out.print(i + " -> ");
            System.out.print(map.get(i));
            System.out.println();
        }
    }

    private Map printTopView(TreeNode root, Map<Integer,Integer> map) {
        if(root == null){
            return null;
        }
        Queue<QueueObj> qh = new LinkedList<>();
        QueueObj temp = null;
        qh.add(new QueueObj(root,0));
        while(!qh.isEmpty()){
            temp = qh.remove();
            map.put(temp.hd, temp.tn.data);
//            if(!map.containsKey(temp.hd)){
//                map.put(temp.hd, temp.tn.data);
//            }
            if(temp.tn.left!=null){
                qh.add(new QueueObj(temp.tn.left, temp.hd - 1));
            }
            if(temp.tn.right!=null){
                qh.add(new QueueObj(temp.tn.right, temp.hd + 1));
            }
        }
        return map;
    }

    public static void bottomView(TreeNode node){

    }



    public static void levelOrder(TreeNode root){
        Queue<TreeNode> qh = new LinkedList<>();
        TreeNode temp;
        qh.add(root);
        while(!qh.isEmpty()){
            temp = qh.remove();
            System.out.print(temp.data + " ");
            if(temp.left!=null){
                qh.add(temp.left);
            }if(temp.right!=null){
                qh.add(temp.right);
            }
        }
    }

    public static void zigzagOrder(TreeNode root){
        Queue<TreeNode> qh = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode tempNode;
        qh.add(root);
        boolean leftRight = true;
        while(!qh.isEmpty()){
            //System.out.print(temp.data + " ");
            ArrayList<Integer> temp = new ArrayList<>();
            int n  = qh.size();
            for (int i = 0; i < n; i++) {
                tempNode = qh.remove();
                if (tempNode.left != null) {
                    qh.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    qh.add(tempNode.right);
                }
                temp.add(tempNode.data);
            }
            if(!leftRight){
                Collections.reverse(temp);
            }
            ans.addAll(temp);
            leftRight = !(leftRight);
        }
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
    public static void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        Tree tr = new Tree();
//        tr.insert(1);
//        tr.insert(2);
//        tr.insert(3);
//        tr.insert(4);
//        tr.insert(5);
//        tr.insert(6);
//        tr.insert(7);
//        tr.insert(8);
//        tr.insert(0);
        tr.root = new TreeNode(20);
        tr.root.left = new TreeNode(8);
        tr.root.right = new TreeNode(22);
        tr.root.left.left = new TreeNode(5);
        tr.root.left.right = new TreeNode(3);
        tr.root.right.left = new TreeNode(4);
        tr.root.right.right = new TreeNode(25);
        tr.root.left.right.left = new TreeNode(10);
        tr.root.left.right.right = new TreeNode(14);
        //tr.root.left.right.right = new TreeNode(5);
        //tr.root.left.right.right.right = new TreeNode(6);


        System.out.println("Pre Order Traversal");
        preOrder(tr.root);
        System.out.println("\nPost Order Traversal");
        postOrder(tr.root);
        System.out.println("\nIn Order Traversal");
        inOrder(tr.root);
        System.out.println("\nLevel Order Traversal");
        levelOrder(tr.root);
        System.out.println("\nZigZag Order Traversal");
        zigzagOrder(tr.root);
        System.out.println("\nVertical Order Traversal");
        tr.verticalOrder(tr.root);

        System.out.println("\n Right View");
        rightView(tr.root);
        System.out.println("\n Top View");
        tr.topView(tr.root);
        System.out.println("\n Left View");
        leftView(tr.root);
    }
}
