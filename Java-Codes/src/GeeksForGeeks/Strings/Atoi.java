package GeeksForGeeks.Strings;

import java.util.Scanner;

public class Atoi {

    int atoi(String str) {
        int ans = 0;
        int sign = 1;
        int start = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }
        int multiplier = 1;
        for (int i = str.length() - 1; i>=start; i--) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                return -1;
            }
            ans += (multiplier * (str.charAt(i) - '0'));
            multiplier*=10;
        }
        return sign * ans;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        while(true) {
            String input = new Scanner(System.in).next();
            System.out.println(atoi.atoi(input));
        }
    }
}
