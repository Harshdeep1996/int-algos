import java.util.Scanner;

/*
	Z Algorithm is a pattern matching algorithm, with the time complexity of 
	O(M + N), where M is the length of the pattern and N is the length of the 
	text. 

	It is basically used with the pattern to be found in the text added as a
	prefix to the text for something like:

	bluemix = text
	mix = pattern

	pattern plus text = mix + "$" + bluemix => mix$bluemix
	For this pattern plus text, we form a Z array, which stores how many 
	elements on a particular index matches starting from the prefix of the
	string.

	lets say for 
	
	index  = 0 1 2 3 4 5 6 7 8 9 10
	text   = m i x $ b l u e m i x
	Zvalue = 0 0 0 0 0 0 0 0 3 0 0

	if the Z value is equal to the length of the string we are trying to find
	in the pattern plus text we have found the string. 

	We always set the value of the first character to be 0, considering there is
	no prefix before it. 
	
	An important case we need to consider in this algorithm is: for a matched
	string, it is contained inside a `LR` window, now for the above example
	there is a LR window starting from m to x -> `mix` from indexes 8 to 10. 

	if the corresponding Z value in the prefix is greater than the length of the 
	string left, then we need to consider finding new Z value and form a new LR
	window. 
*/
public class ZAlgorithm
{
	static int [] z_array;
	public static void if_pattern_in_text(String text, String pattern){
		String pattern_plus_text = new StringBuilder().append(
			pattern).append("$").append(text).toString();

		int pattern_length = pattern.length();
		int length_ppt = pattern_plus_text.length();

		z_array = new int[length_ppt];
		getZArray(z_array, pattern_plus_text);

		for(int i = 0; i < length_ppt; i++){
			if(z_array[i] == pattern.length())
				System.out.println(
					"The value is present at index: " + (i - pattern_length - 1)
				);
		}
		System.out.println("The search in the string has been finished");
	}

	public static void getZArray(int[] z_array, String text){
		int left, right, k;
		left = right = 0;
		char[] textArray;
		textArray = text.toCharArray();
		int len_text = textArray.length;

		// Starting from 1,  because intially the first element will have no
		// prefix
		for(int i = 1; i < len_text; i++)
		{
			if(i > right){
				left = right = i;
				while (right < len_text
						&& textArray[right - left] == textArray[right]){
					right++;
				}
				z_array[i] = right - left;
				right--;
			}
			else{
				// Gives the index of the prefix it is matching with
				k = i - left;
				// For if the matching index in the prefix if that value is 
				// smaller than that of the right interval
				if(z_array[k] < right - i + 1){
					z_array[i] = z_array[k];
				}
				else{
					left = i;
					while (right < len_text
						&& textArray[right - left] == textArray[right]){
						right++;
					}
					z_array[i] = right - left;
					right--;
				}
			}
		}
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		// System.out.print("Text by the user: ");
		// //String text = scanner.next();
		// // scanner.nextLine();
		// String text = "GEEKS FOR GEEKS";
		// System.out.print("Pattern by the user: ");
		// String pattern = "GEEK";
		// // String pattern = scanner.next();

		System.out.print("Text by the user: ");
		//String text = scanner.next();
		// scanner.nextLine();
		String text = "baabaa";
		System.out.print("Pattern by the user: ");
		String pattern = "aab";

		if_pattern_in_text(text, pattern);
	}
}