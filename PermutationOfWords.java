import java.text.ParseException;

public class PermutationOfWords {
    public static void main(String[] arguments) {
        char arrows = '⇄'; //8644
        try {
            String stringOfWords = ReadFromFile.readString();
            if (stringOfWords.indexOf(arrows) == -1)
                System.out.println("In the read string no character '" + arrows + "'");
            else
                System.out.println("Read string before and after permutation");
            System.out.println(stringOfWords);
            System.out.println(PermuteString.permuteReadString(stringOfWords));
            System.out.println(PermuteStringRegex.permuteReadStringRegex(stringOfWords));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
