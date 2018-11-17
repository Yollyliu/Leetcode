public class MinimunMoves {
    public static void main(String[] args) {

    }
    public int minMovesJS(int[] nums) {


    const minMoves = nums =>{
            let sm = Math.min(...nums);
            return nums.reduce((acc, v) =>(acc + (v - sm)), 0);
        } ;
    }
    public int minMovesJava(int[] nums) {

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;
            if (num < min) {
                min = num;
            }
        }

        return sum - min * nums.length;
    }
}
