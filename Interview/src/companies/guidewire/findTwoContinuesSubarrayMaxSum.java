package companies.guidewire;

import org.junit.Test;

public class findTwoContinuesSubarrayMaxSum {

    @Test
    public void test_() {
        int[] input = {6, 1, 4, 6, 2, 3, 7, 4};
        System.out.println(solution(input, 3,2));
    }

    /**
     * Solution:
     * 1. one round from left to right
     * 2. second round from right to left
     */
    public int solution(int[] input, int alice, int bob) {
        if(input.length < (alice + bob)) return -1;
        int max = Integer.MIN_VALUE;
        int sumAlice = 0;
        int sumBob = 0;
        int sumBobFinal = 0;
        for(int i = 0; i <= input.length - alice; i++) {
//          reset Alice for next index;
            sumAlice = 0;
//          sliding window for size alice from index 0 to end. get alice number firstly
            for(int j = i; j < (i + alice); j++) {
                sumAlice += input[j];
            }
//            get bob's number for each index from Alice max range to end of the index
            for(int l = (i + alice); l <= input.length - bob; l++) {
//              reset Bob for next index
                sumBob = 0;
                sumBobFinal = 0;
                for(int m = l; m < (l + bob); m++) {
                    sumBob += input[m];
                }
                sumBobFinal = sumBobFinal > sumBob ? sumBobFinal : sumBob;
                if((sumAlice + sumBobFinal)  == 25) {
                    System.out.println(i);
                }
            }
            max = max < (sumAlice + sumBobFinal) ? (sumAlice + sumBobFinal): max;

        }
        return max;
    }
}
