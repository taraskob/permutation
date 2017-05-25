import java.io.*;
import java.text.ParseException;

class ReadFromFile {
    private static File file;

    static void sourcexists(String fileName) throws IOException {
        file = new File(fileName);
        if (!file.exists()) {
            String line = "bed bug dad yes zoo now for tip ilk ⇄ dim tag jot sob nob sky hut men egg few " +
                    "jay owl joy rap gig wee";

            FileWriter writer = new FileWriter(fileName);
            {
                writer.write(line);
            }
            writer.close();
        }
    }

    static String readString() throws IllegalAccessException, ParseException {
        String filename = "words.txt";
        StringBuilder line = new StringBuilder();
        try {
            sourcexists(filename);
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    line.append(s);
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line.toString();
    }

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
        endOfWord = input.length();
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
