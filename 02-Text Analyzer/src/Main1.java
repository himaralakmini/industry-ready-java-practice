import java.util.Scanner;

public class Main1{

    public static int countWords(String sentence){
        String trimmed = sentence.trim();

        if(trimmed.isEmpty()){
            return 0;
        }

        String []words = trimmed.split("\\s+");
        return words.length;
    }

    //character count

    public static int countAllCharacters(String sentence){

        return sentence.length();
    }

    //count characters without space
    public static int countCharactersWithoutSpaces(String sentence){

        return sentence.replaceAll("\\s","").length();
    }

    //count vowels
    public static int countVowels(String sentence){
        int count = 0;

        sentence = sentence.toLowerCase();

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }


    //find longest word
    public static String findLongestWord(String sentence){
        String trimmed = sentence.trim();

        if (trimmed.isEmpty()) {
            return "No words";
        }

        String[] words = trimmed.split("\\s+");
        String longest = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        return longest;
    }

    //find shortest word

    public static String findShortestWord(String sentence) {
        String trimmed = sentence.trim();

        if (trimmed.isEmpty()) {
            return "No words";
        }

        String[] words = trimmed.split("\\s+");
        String shortest = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < shortest.length()) {
                shortest = words[i];
            }
        }

        return shortest;
    }


    //count secharacters
    public static int countCharacter(String sentence, char searchChar) {
        int count = 0;

        sentence = sentence.toLowerCase();
        searchChar = Character.toLowerCase(searchChar);

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == searchChar) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        String searchInput;

        do {
            System.out.print("Enter a character to search: ");
            searchInput = input.nextLine().trim();
        } while (searchInput.isEmpty());

        char searchChar = searchInput.charAt(0);

        System.out.println("\n----- TEXT ANALYSIS RESULTS -----");

        System.out.println("Word count: " + countWords(sentence));

        System.out.println("All characters: " + countAllCharacters(sentence));

        System.out.println("Characters without spaces: "+ countCharactersWithoutSpaces(sentence));

        System.out.println("Vowel count: " + countVowels(sentence));

        System.out.println("Longest word: " + findLongestWord(sentence));

        System.out.println("Shortest word: " + findShortestWord(sentence));

        System.out.println("Occurrences of '" + searchChar + "': "+ countCharacter(sentence, searchChar));

        input.close();
    }
}

