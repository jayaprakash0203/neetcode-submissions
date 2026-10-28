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
   
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        ans[0] = k;
        kthElement(root, ans);
        return ans[1];



    }

    public void kthElement(TreeNode root, int[]count){
        if(root == null){
            return;
        }
        kthElement(root.left, count);
        if(count[0] == 0){
            return;
        }

        count[0]--;
        if(count[0] == 0){
            count[1] = root.val;
            return;
        }

        kthElement(root.right, count);


        
    }
}
