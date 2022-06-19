package GeeksForGeeks.Strings;

// https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1

/**
 * Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.
 */

class CheckIfStringRotateTwoPlaces {

    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        if (str1.length() != str2.length())
            return false;
        int l = str1.length();
        boolean rotationPossible = true;
        for (int i = 0; i<l; i++) {
            if (str1.charAt(i) != str2.charAt((i + 2) % l)) {
                rotationPossible = false;
                break;
            }
        }
        if (rotationPossible)
            return true;
        rotationPossible = true;
        for (int i = 0; i<l; i++) {
            if (str1.charAt(i) != str2.charAt(Math.floorMod(i - 2, l))) {
                rotationPossible = false;
                break;
            }
        }
        return rotationPossible;
    }

    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "geeksgeeksfor";

        System.out.println(isRotated(str1, str2));
    }
}
