public class ConvertSortedAtoBinaryST {
    public TreeNode sortedArrayToBSTJS(int[] nums) {
        return mybst(0, nums.length);

        function mybst(start, end){
            if(start>=end) return null;

            let mid = Math.floor((start+end)/2);

            let cur = new TreeNode(nums[mid]);
            let left = mybst(start, mid);
            let right = mybst(mid+1, end);

            cur.left = left;
            cur.right = right;
            return cur;
        }
    }

    public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if(left > right)
            return null;

        int mididx = (left+right)/2;
        TreeNode res = new TreeNode(nums[mididx]);
        res.left = sortedArrayToBSTHelper(nums, left, mididx-1);
        res.right = sortedArrayToBSTHelper(nums, mididx+1, right);
        return res;
    }

    public TreeNode sortedArrayToBSTJava(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }


}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

