import java.util.ArrayList;
import java.util.List;

public class BST {
    private TreeNode node;

    public BST() {

    }

    // khoi tao
    public void init() {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        node = n0;
    }

    // public TreeNode insertIntoBST(TreeNode root, int value) {
    //     TreeNode newNode = new TreeNode(value);
    //     if (root == null)
    //         return newNode;
    //     TreeNode temp = root;
    //     while (true) {
    //         if (value > temp.val) {// ben phai
    //             if (temp.right == null) {
    //                 temp.right = newNode;
    //                 break;
    //             } else {
    //                 temp = temp.right;
    //             }
    //         } else {
    //             if (temp.left == null) {
    //                 temp.left = newNode;
    //                 break;
    //             } else {
    //                 temp = temp.left;
    //             }
    //         }
    //     }
    //     return root;
    // }

    public TreeNode insertIntoBST(TreeNode root, int value) {
        if (root == null)
            return new TreeNode(value);
        if (value < root.val) {// kiem ben phai
            if (root.left == null) {
                root.left = new TreeNode(value);
            } else {
                insertIntoBST(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(value);
            } else {
                insertIntoBST(root.right, value);
            }
        }
        return root;
    }

    public TreeNode findLastLeft(TreeNode root) {
        if (root.left == null)
            return root;
        return findLastLeft(root.left);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // nut la
            if (root.left == null && root.right == null) {
                return null;
            }
            // ben phai
            if (root.left == null && root.right != null) {
                return root.right;
            }
            // ben trai
            if (root.left != null && root.right == null) {
                return root.left;
            }
            // ton tai hai con
            // tim node trai cung cay con ben phai
            TreeNode lastLeft = findLastLeft(root.right);
            root.val = lastLeft.val;
            root.right = deleteNode(root.right, lastLeft.val);
        }
        return root;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    //Duyet cay
    // Th1:PreOrder Node-L-R
    public void PreOrder(TreeNode currentNode){
        if(currentNode==null) return;
        System.out.print(currentNode.val+" ");
        PreOrder(currentNode.left);
        PreOrder(currentNode.right);
    }
    // Th2:InOrder L-Node-R
    public void InOrder(TreeNode currentNode){
        if(currentNode==null) return;
        InOrder(currentNode.left);
        System.out.print(currentNode.val+" ");
        InOrder(currentNode.right);
    }
    // Th3:PostOrder L-R-Node
    public void PostOrder(TreeNode currentNode){
        if(currentNode==null) return;
        PostOrder(currentNode.left);
        PostOrder(currentNode.right);
        System.out.print(currentNode.val+" ");
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;       
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;   
    }
}
