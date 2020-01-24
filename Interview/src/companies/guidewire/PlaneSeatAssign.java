package companies.guidewire;

import java.util.Arrays;

public class PlaneSeatAssign {

    public int row = 0;
    public int solution(int N, String S) {
        // write your code in Java SE 8
        if(S == null || S.length() < 2) return (2 * N);
        String[] tmp = S.split(" ");
        Arrays.sort(tmp);
        int slow = 0, count = 0;
        Character preRow = tmp[0].charAt(0);
        for(int i = 1; i < tmp.length; i++) {
            Character curRow = tmp[i].charAt(0);
            // get current row information
            while(curRow == preRow && i < tmp.length) {
                curRow = tmp[i].charAt(0);
                i++;
            }
            int start = slow, end = i - 1;
            count += getCurrentAvailableSeatCount(tmp, start, end);
            start = i;
        }

        count += 2 * ( N - row);

        return count;
    }

    public int getCurrentAvailableSeatCount(String[] tmp, int start, int end) {
        row++;
        char[] charArray = new char[end - start + 1];
        int j = 0;
        for(int i = start; i <= end; i++) {
            charArray[j++] = tmp[i].charAt(1);
        }
        String res = new String(charArray);
        if(res.contains("B") || res.contains("C") || res.contains("D") || res.contains("E")) {
            if( (res.contains("F") || res.contains("G") || res.contains("H") || res.contains("I"))) {
                return 0;
            } else {
                return 1;
            }
        } else if(res.contains("F") || res.contains("G") || res.contains("H") || res.contains("J")) {
            if(res.contains("B") || res.contains("C") || res.contains("D") || res.contains("E")) {
                return 0;
            } else {
                return 1;
            }
        }
        return 2;
    }
}
