package GeeksForGeeks.Strings;

//https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1

/**
 * Given a string s, remove all its adjacent duplicate characters recursively.
 */

class RemoveAdjacentDuplicateRecursively {

    String removeAdjacent(String input) {
        boolean[] needRemoval = new boolean[input.length()];
        for (int i=0; i<input.length() - 1 ; i++) {
            if (input.charAt(i) == input.charAt(i+1)) {
                needRemoval[i] = needRemoval[i+1] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<input.length(); i++) {
            if (!needRemoval[i]) {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    String remove(String s) {
        String removedString = s;
        String currentString;
        do {
            currentString = removedString;
            removedString = removeAdjacent(currentString);
        } while (!removedString.equals(currentString));
        return removedString;
    }

    public static void main(String[] args) {
        String input = "acbaabaabbca";
        RemoveAdjacentDuplicateRecursively removeAdjacentDuplicateRecursively = new RemoveAdjacentDuplicateRecursively();

        System.out.println(removeAdjacentDuplicateRecursively.remove(input));
    }
}
