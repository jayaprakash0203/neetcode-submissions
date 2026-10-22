/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    TreeNode sameNode;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        else if(root == null && subRoot != null){
            return false;
        }
        if(!(findSubElement(root, subRoot))){
            return false;
        }
        if(isSameTree(sameNode, subRoot)){
            return true;
        }
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));

    }

    public boolean findSubElement(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val){
            sameNode = root;
            return true;
        }

        return findSubElement(root.left,subRoot) || findSubElement(root.right,subRoot);


    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if((root == null && subRoot != null) || (root != null && subRoot == null)){
            return false;
        }

        if(root.val != subRoot.val){
            return false;
        }

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);

    }
}
