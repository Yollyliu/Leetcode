public class sumPath {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;

        sum=sum-root.val;
        if((root.right==null) &&(root.left==null) ){
            return (sum==0);
        }else{
           return (hasPathSum(root.right,sum) || hasPathSum(root.left,sum));
        }
        
    }
}
// class TreeNode {
//    int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }