import java.util.Scanner;

// TODO: Full explaination in comments
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