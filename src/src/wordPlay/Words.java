package wordPlay;
import java.util.*;

public class Words{
	
	//to get user input
	public static String UserInput(){
		System.out.println("Enter lengthy text like a paragraph: ");
		@SuppressWarnings("resource")
		//closing this scanner creates a bug
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	//Find the number of characters and display
	public static int charCount(String text) {
		return text.length();
	}
	
	//Similar method for whole words
	public static int wordCount(String text) {
		String[] words = text.trim().split("\\s+");
		return words.length;
	}
	
	//Find the most common character
	public static char mostComC(String text) {
		//most common character
		text = text.toLowerCase();
		Map<Character, Integer> frequencyMap = new HashMap<>();
		
		for(char c : text.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
			}
		}
		
		//finding the frequency of of Most Common Char
		char mostCommon = ' ';
		int maxFrequency = 0;
		for (Map.Entry<Character, Integer> entry :frequencyMap.entrySet()) { 
			if (entry.getValue() > maxFrequency) { mostCommon = entry.getKey(); maxFrequency = entry.getValue(); } }
		 
        return mostCommon;
	}
	
	//Find the frequency of Characters
	public static int charFrequency(String text, char charFind) {
		text = text.toLowerCase();
		charFind = Character.toLowerCase(charFind);
		int count = 0;
		for(char c : text.toCharArray()) {
			if(c == charFind){
				count++;
			}
		}
		return count;
		
	}
	
	//Frequency of words
	public static int wordFrequency(String text, String wordFind) {
		text = text.toLowerCase();
		wordFind = wordFind.toLowerCase();
		String[] words = text.split("\\s+");
		int counter = 0;
		for(String word : words) {
			if(word.equals(wordFind)) {
				counter++;
			}
		}
		return counter;
	}
	
	//number of unique words
	public static int uniqueWords(String text) {
		text = text.toLowerCase();
		String[] words = text.split("\\s+");
		Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
		return uniqueWords.size();
	}
	
	//utilize all areas 
	public static void main(String[] args) {
		String text = UserInput();
		
		System.out.println("Total number of Characters: " + charCount(text));
		
		System.out.println("Total number of words: " + wordCount(text));
		
		System.out.println("Most Common Character(s): " + mostComC(text));
		
		System.out.println("Number of Unique Words: " + uniqueWords(text));
		
		Scanner scannerC = new Scanner(System.in);
		System.out.println("Input a character to find out frequency: ");
		char charFind = scannerC.next().charAt(0);
		System.out.println("Frequency of " + charFind + " is: " + charFrequency(text, charFind));
		
		scannerC.nextLine();
		System.out.println("Enter a word to find out frequency: ");
		String wordFind = scannerC.nextLine();
		System.out.println("Frequency of " + wordFind + " is: " + wordFrequency(text, wordFind));
		
		scannerC.close();
	}
}
