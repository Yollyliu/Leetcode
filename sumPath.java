public class sumPath {

    public static void main(String[] args) {

    }

    public boolean hasPathSumRecursive(TreeNode root, int sum) {
        if(root==null) return false;

        sum=sum-root.val;
        if((root.right==null) &&(root.left==null) ){
            return (sum==0);
        }else{
           return (hasPathSumRecursive(root.right,sum) || hasPathSumRecursive(root.left,sum));
        }

    }


    public boolean hasPathSumDfs(TreeNode root, int sum) {
        int curSum = 0;
        return dfs(root,curSum,sum);
    }
    public boolean dfs(TreeNode root, int curSum, int sum){
        if(root == null) return false;
        curSum = curSum + root.val;
        if(curSum == sum && root.left==null && root.right==null) return true;
        return dfs(root.left,curSum,sum) || dfs(root.right,curSum,sum);
    }

}
// class TreeNode {
//    int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }