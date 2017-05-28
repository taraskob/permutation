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
}
