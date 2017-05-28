import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PermuteStringRegex {
    static String permuteReadStringRegex(String input) {
        StringBuffer permutedString = new StringBuffer();
        int arrowsPosition;
        Pattern pat = Pattern.compile("⇄");
        Matcher mat = pat.matcher(input);
        boolean arrowsFound = mat.find();
        if (!arrowsFound)
            return input;
        arrowsPosition = mat.start();
        if (arrowsPosition == 0 || arrowsPosition == input.length())
            return input;
        String[] leftSubstring = input.substring(0, arrowsPosition).split(" ");
        String word1 = leftSubstring[leftSubstring.length - 1];
        String[] rightSubstring = input.substring(arrowsPosition + 1).split(" ");
        String word2 = rightSubstring[0];
        int word1Ind = leftSubstring.length - 1;
        for (int i = leftSubstring.length - 1; i <= 0; i--) {
            if (leftSubstring[i].length() != 0) {
                word1 = leftSubstring[i];
                word1Ind = i;
                break;
            }
        }
        int word2Ind = 0;
        for (int i = 0; i < rightSubstring.length; i++) {
            if (rightSubstring[i].length() != 0) {
                word2 = rightSubstring[i];
                word2Ind = i;
                break;
            }
        }
        leftSubstring[word1Ind] = word2;
        rightSubstring[word2Ind] = word1;
        for (String str : leftSubstring) {
            permutedString.append(str);
            permutedString.append(" ");
        }
        permutedString.append("⇄");
        for (String str : rightSubstring) {
            permutedString.append(str);
            permutedString.append(" ");
        }
        return permutedString.toString();
    }
}
