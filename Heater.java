import java.util.Arrays;

public class Heater {
    public static void main(String[] args) {
        int[] houses=new int[]{1,2,3};
        int[] heater=new int[]{2};
        System.out.println(findRadius(houses,heater));

    }
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                    && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }

        return res;
    }
}
