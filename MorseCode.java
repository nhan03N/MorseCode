import java.util.Scanner;
public class MorseCode {

    //this is an array that stores the letters and numbers
    private static final char[] morseLetters = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    //this is an array that contains the morse code corresponding to each letter and number
    private static final String[] morseCode = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
            "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."
    };


    //this is my method to print the menu options
    public static void Menu() {
        System.out.println("Please select one of the below option");
        System.out.println("*** Enter 't' for encoding text");
        System.out.println("*** Enter 'm' for decoding morse code");
        System.out.println("*** Enter 'e' to exit the program");
    }
    //this is my method that converts a word to morse code
    // This is my method that converts a word to Morse code
    public static void WordToMorseCode(Scanner userInput) {
        System.out.println("Please enter a phrase: ");

        String userPhrase = userInput.nextLine().toUpperCase();
        StringBuilder convertMorseCode = new StringBuilder();

        // Split the input phrase into words
        String[] words = userPhrase.split(" ");

        // Convert each word to Morse code
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String wordMorseCode = "";

            // Convert each letter of the word to Morse code
            for (int j = 0; j < word.length(); j++) {
                char character = word.charAt(j);
                String userCode = GetMorseCode(character);
                if (userCode != null) {
                    wordMorseCode += userCode + " "; // Add Morse code for the letter
                }
            }

            // Append the Morse code for the word to the result
            convertMorseCode.append(wordMorseCode.trim());

            // Add three spaces after each Morse-coded word, except for the last one
            if (i < words.length - 1) {
                convertMorseCode.append("   ");
            }
        }

        // Print the Morse code with separated Morse-coded words
        System.out.println(" ");
        System.out.println("MorseCode:");
        System.out.println(convertMorseCode.toString());
        System.out.println(" ");
    }


    //this is my method that converts a morse code to a word
    public static void MorseCodeToWord(Scanner userInput) {
        System.out.println("Please enter a morse Code");
        String userMorseCode = userInput.nextLine();
        StringBuilder convertedText = new StringBuilder();

        String[] userWords = userMorseCode.split("  ");
        for(String userWord : userWords) {
            String[] userLetters = userWord.split(" ");
            for(String userLetter : userLetters) {
                char character = GetMorseCharacter(userLetter);
                convertedText.append(character);
            }
            convertedText.append("");
        }
        System.out.println(" ");
        System.out.println("Normal Text:");
        System.out.println(convertedText.toString());
        System.out.println(" ");
    }

    //this is my method that helps get a morse code for a single character
    public static String GetMorseCode(char character) {
        for(int c = 0; c < morseLetters.length; c++) {
            if(morseLetters[c] == character) {
                return morseCode[c];
            }
        }
        return null;
    }
    //this is my method that helps get a character for a single a morse code
    public static char GetMorseCharacter(String userMorse) {
        for(int c = 0; c < morseCode.length; c++) {
            if(morseCode[c].equals(userMorse)) {
                return morseLetters[c];
            }
        }
        return ' ';
    }

    //this is my main method part of the program
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        char userCharChoice;
        System.out.println("Hello, this program allows you to translate text to morse code or translate morse code to text.");
        System.out.println(" ");
        Menu();
        do {
            userCharChoice = userInput.nextLine().charAt(0);
            switch (userCharChoice) {
                case 't':
                    WordToMorseCode(userInput);
                    System.out.println("Hello, this program allows you to translate text to morse code or translate morse code to text.");
                    System.out.println(" ");
                    Menu();
                    break;
                case 'm':
                    MorseCodeToWord(userInput);
                    System.out.println("Hello, this program allows you to translate text to morse code or translate morse code to text.");
                    System.out.println(" ");
                    Menu();
                    break;
                case 'e':
                    System.out.println("Thanks for using this program!");
                    break;
                default:
                    System.out.println("*** Invalid Option ***");
                    System.out.println("Please enter a valid option: ");
            }
        }while(userCharChoice != 'e');
        userInput.close();

    }

}
