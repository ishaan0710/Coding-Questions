package GeeksForGeeks.Strings;

// https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1

/**
 * Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S).
 * Palindrome string: A string which reads the same backwards.
 * More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).
 */
class LongestPalindromeInString {

    static String longestPalin(String input){
        if(input.isEmpty())
            return "";
        int[][] palinLength = new int[input.length()][input.length()];

        for (int currentLength = 1; currentLength <= input.length(); currentLength++) {
            for(int start = 0; start + currentLength -1 < input.length(); start ++) {
                int end = start + currentLength - 1;
                boolean sameCharFound = input.charAt(start) == input.charAt(end);
                if (currentLength == 1) {
                    palinLength[start][end] = 1;
                    continue;
                } else if (currentLength == 2 && sameCharFound) {
                    palinLength[start][end] = 2;
                    continue;
                }
                if (sameCharFound && palinLength[start+1][end-1] != 0) {
                    palinLength[start][end] = palinLength[start + 1][end - 1] + 2;
                }
            }
        }

        int largest = 1;
        int starting = 0;
        int ending = 0;
        for(int i=0; i<input.length(); i++) {
            for (int j=0; j<input.length(); j++) {
                if (palinLength[i][j] > largest) {
                    largest = palinLength[i][j];
                    starting = i;
                    ending = j;
                }
            }
        }
        return input.substring(starting, ending + 1);
    }

    public static void main(String[] args) {
        String input = "rfkqyuqfjkxy";
        System.out.println(longestPalin(input));
    }

}
