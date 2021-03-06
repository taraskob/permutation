class PermuteString {
    static String permuteReadString(String input) {
        StringBuffer permutedString = new StringBuffer();
        int arrowsPosition = input.indexOf("⇄");
        if (arrowsPosition == 0 || arrowsPosition == input.length())
            return input;
        int endOfWord = arrowsPosition - 1;
        int startOfWord = 0;
        int countOfSpace = 2;
        if (input.charAt(arrowsPosition - 1) != ' ') {
            endOfWord = arrowsPosition;
            countOfSpace = 1;
        }
        for (int i = endOfWord; i >= 0; i--) {
            if (input.charAt(i) == ' ')
                countOfSpace--;
            if (countOfSpace == 0)
                break;
            startOfWord = i;
        }
        String word1 = input.substring(startOfWord, endOfWord);
        permutedString.append(input.substring(0, startOfWord));
        startOfWord = arrowsPosition + 1;
        endOfWord = input.length()-1;
        countOfSpace = 0;
        if (input.charAt(startOfWord) != ' ')
            countOfSpace = 1;
        for (int i = startOfWord; i < input.length(); i++, endOfWord = i) {

            if (input.charAt(i) == ' ')
                countOfSpace++;
            if (countOfSpace == 2)
                break;

        }
        String word2 = input.substring(startOfWord, endOfWord);
        permutedString.append(word2.trim());
        permutedString.append(" ⇄ ");
        permutedString.append(word1.trim());
        permutedString.append(input.substring(endOfWord));
        return permutedString.toString();
    }
}
