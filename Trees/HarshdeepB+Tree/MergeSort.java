import java.util.*;

public class MergeSort {

	public void sort(ArrayList<Integer> input) {
		if(input.size() == 1) {
			return ;
		}
		else { 
			int mid = input.size() / 2;
			ArrayList<Integer> left = new ArrayList<Integer>(mid);
			ArrayList<Integer> right = new ArrayList<Integer>(input.size() - mid);
			for(int i = 0; i < mid; i++) {
				left.add(input.get(i));
			}
			for(int i = mid; i < input.size(); i++) {
				right.add(input.get(i));
			}
			sort(left);
			sort(right);
			// Merges the sorted lists
			merge(left, right, input);
		}
	}

	public void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> input) {
		int l = 0, r = 0, i = 0;
		while(l < left.size() && r < right.size()) {
			if(left.get(l) <= right.get(r)) {
				input.set(i, left.get(l));
				l = l + 1;
			}
			else {
				input.set(i, right.get(r));
				r = r + 1;
			}
			i = i + 1;
		}
		// Add the left over elements in the split arrays to the input
		while(l < left.size()) {
			input.set(i, left.get(l));
			l = l + 1;
			i = i + 1;
		}
		while(r < right.size()) {
			input.set(i, right.get(r));
			r = r + 1;
			i = i + 1;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>(10);
		input.add(4);
		input.add(2);
		input.add(10);
		input.add(11);
		input.add(1);
		input.add(0);
		input.add(-4);
		input.add(34);
		input.add(7);
		input.add(6);

		MergeSort ms = new MergeSort();
		System.out.println("Array to be sorted is : " + input);
		ms.sort(input);

		System.out.println("Sorted array is : " + input);
	}
}