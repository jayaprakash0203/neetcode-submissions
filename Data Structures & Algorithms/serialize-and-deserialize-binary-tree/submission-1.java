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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        if(root == null){
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            

           
            TreeNode curr = queue.poll();
            if(curr == null){
                ans.append("null ");
            }
            else{
                ans.append(curr.val);
                ans.append(" ");
            }
            

            if(curr != null){
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
            
        }

        return ans.toString();

        
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.equals("")){
            return null;
        }

        String[] dataArr = data.split(" ");

        Queue<TreeNode> queue = new LinkedList<>();
        int start = 0;

        TreeNode root = new TreeNode(Integer.parseInt(dataArr[start]));

        queue.offer(root);
        start++;
        while(!queue.isEmpty() && start < dataArr.length-1){
            TreeNode curr = queue.poll();
            if(!dataArr[start].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(dataArr[start]));
                curr.left = left;
                queue.offer(left);
               
            }
            if(!dataArr[start+1].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(dataArr[start+1])); 
                curr.right = right;  
                queue.offer(right);
               
            }
            
            start = start + 2;
        }


        return root;
    }
    
}
