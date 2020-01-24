package companies.guidewire;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMaxDiffTemperature {

    @Test
    public void test_() {
        int[] input = {-3, -14, -5, 7, 8, 42, 8, 3};
        System.out.println(solution(input));
    }

    public static final int SEASON_COUNT = 4;
    public String solution(int[] T) {
        Map<Integer, String> map = new HashMap<>();
        map.put(getMaxDiffTemp(T, 0, T.length/4), "WINTER");
        map.put(getMaxDiffTemp(T, T.length/4, T.length*2/4), "SPRING");
        map.put(getMaxDiffTemp(T, T.length*2/4, T.length*3/4), "SUMMER");
        map.put(getMaxDiffTemp(T, T.length*3/4, T.length), "AUTUMN");

        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            max = entry.getKey() > max ? entry.getKey() : max;
        }
        return map.get(max);
    }

    private int getMaxDiffTemp(int[] T, int start, int end) {
        int max = Integer.MIN_VALUE;
        for(int i = start; i < end; i++) {
            for(int j = i + 1; j < end; j++) {
                max = max < Math.abs(T[i] - T[j]) ? Math.abs(T[i] - T[j]) : max;
            }
        }
        return max;
    }
}
