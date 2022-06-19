package GeeksForGeeks.Strings;

/**
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
 * For Example:
 * ab: Number of insertions required is 1. bab or aba
 * aa: Number of insertions required is 0. aa
 * abcd: Number of insertions required is 3. dcbabcd
 * https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1
 */


public class FormPalindrome {

    static int getCountToPalin(String str, int start, int end, int[][] countToPalin) {
        if (start >= end) {
            return 0;
        }
        if(countToPalin[start][end] != -1) {
            return countToPalin[start][end];
        }
        if (str.charAt(start) == str.charAt(end)) {
            return (countToPalin[start][end] = getCountToPalin(str, start + 1, end - 1, countToPalin));
        } else {
            return (countToPalin[start][end] = 1 + Math.min(getCountToPalin(str, start + 1, end, countToPalin),
                                                            getCountToPalin(str, start, end -1 , countToPalin)));
        }
    }

    static int countMin(String str)
    {
        int length = str.length();
        int countToPalin[][] = new int[length][length];
        for(int i=0; i<length; i++)
            for(int j=0; j<length; j++)
                countToPalin[i][j] = -1;

        return getCountToPalin(str, 0, length - 1, countToPalin);

    }

    public static void main(String[] args) {
        System.out.println(FormPalindrome.countMin(""));
    }
}
