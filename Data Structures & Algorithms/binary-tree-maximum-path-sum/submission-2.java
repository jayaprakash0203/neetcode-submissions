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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        nodeSum(root, 0);
        return maxSum;
        
    }
    public int nodeSum(TreeNode root, int parentSum){

        if(root == null){
            return 0;
        }

        int left = Math.max(0, nodeSum(root.left, parentSum));

        int right = Math.max(0, nodeSum(root.right, parentSum));

        int currSum = root.val+left+right;

        parentSum = root.val+Math.max(left,right);

        maxSum = Math.max(maxSum, Math.max(currSum, parentSum));

        return parentSum;

    }
}
