package GeeksForGeeks.Strings;

public class StrStr {

    // find iter_str2 in iter_str1
    boolean findOccurence(int iter_str1, int iter_str2, String s1, String s2, int[][] dp) {
        if (iter_str2 == s2.length() && iter_str1 <= s1.length()) {
            return true;
        }
        if (iter_str1 == s1.length())
            return false;
        if (dp[iter_str1][iter_str2] != -1) {
            return dp[iter_str1][iter_str2] == 1;
        }

        if (s1.charAt(iter_str1) == s2.charAt(iter_str2)) {
            boolean incr1 = findOccurence(iter_str1+1, iter_str2, s1, s2, dp);
            boolean incr2 = findOccurence(iter_str1 + 1, iter_str2+1, s1, s2, dp);
            dp[iter_str1][iter_str2] = incr1 || incr2 ? 1 : 0;
            return incr1 || incr2;
        } else {
            boolean occurence = findOccurence(iter_str1+1, 0, s1, s2, dp);
            dp[iter_str1][iter_str2] = occurence ? 1 : 0;
            return occurence;
        }
    }

    //Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x)
    {
        int dp[][] = new int[s.length()][x.length()];
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<x.length(); j++) {
                dp[i][j] = -1;
            }
        }
        findOccurence(0, 0, s, x, dp);
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<x.length(); j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return 0;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        strStr.strstr("GeeksForGeeks", "rGee");
    }
}
