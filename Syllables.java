
/** 
 * Counts vowels and sets that as the original number of syllables
 * Then subtracts count for any exceptions 
 *  Exceptions include when e is the last letter
 *  Also when there are two vowels next to each other
 * There are times where it has to add 1 to count too
 *  When y is before a consonant, it counts as a vowel so we add 1 to count
 *  When the word ends in consonant-le then we add 1 to count. E.x. cradle
 */
public class Syllables
{
    public static void main (String[] args) {
        System.out.println(countVowels("created"));
    }
    
    public static int countVowels (String arg) {
        int first = 0;
        int second = 1;
        String prevChar = "z";
        int count = 0;
        while (second <= arg.length()) {
            System.out.println(arg.substring(first,second));
            if (arg.substring(first,second).equals("a") | arg.substring(first,second).equals("e") | arg.substring(first,second).equals("i") | arg.substring(first,second).equals("o") | arg.substring(first,second).equals("u")) {
                if (prevChar.equals("a") | prevChar.equals("e") | prevChar.equals("i") | prevChar.equals("o") | prevChar.equals("u")) {
                    //NOTHING
                } else {
                    count += 1;
                }
            }
            if (arg.substring(first,second).equals("y")) {
                if (second < arg.length()) {
                    if (arg.substring(first+1, second+1).equals("a") | arg.substring(first+1, second+1).equals("e") | arg.substring(first+1, second+1).equals("i") | arg.substring(first+1, second+1).equals("o") | arg.substring(first+1, second+1).equals("u")) {
                        //NOTHING
                    } else {
                        count += 1;
                    }
                } else {
                    count += 1;
                }
            }
            prevChar = arg.substring(first,second);
            first += 1;
            second += 1;
        }
        String lastChar = arg.substring(arg.length() - 1, arg.length());
        if (lastChar.equals("e")) {
            count -= 1;
            if (arg.substring(arg.length() - 2, arg.length() - 1).equals("l")) {
                String prevTwo = arg.substring(arg.length() - 3, arg.length() - 1);
                if (prevTwo.equals("al") | prevTwo.equals("el") | prevTwo.equals("il") | prevTwo.equals("ol") | prevTwo.equals("ul")) {
                    //NOTHING
                } else {
                    count += 1;
                }
            }
        }
        return count;
    } 
}