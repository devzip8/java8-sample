package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sample for Lambda
 * 
 * @author dev-neko
 * @since 2015/10/11
 */
public class LambdaSample {

	public LambdaSample(){
	}
	
	public static void main(String[] args) {
		String[] elements = {
				"tokyo",
				"osaka",
				"nagoya",
				"kyoto",
				"kobe",
				"nagasaki",
				"fukuoka",
				"chitose",
			
		};
		List<String> list = Arrays.asList(elements);
		
		LambdaSample main = new LambdaSample();
		System.out.println("#--- Start");
		main.printlnAll(list);
		
		main.sampleUpperCase(list);
		main.sampleUpperCase2(list);
		main.sampleShorterThan(list);
	}
	
	private void printlnAll(List<String> list){
		list.forEach(e -> System.out.println(e));
	}
	
	private void sampleUpperCase(List<String> list){
		System.out.println("#--- sampleUpperCase");
		list.forEach(e -> System.out.println(e.toUpperCase()));
	}
	
	/**
	 * Use map
	 * 
	 * @param list
	 */
	private void sampleUpperCase2(List<String> list){
		System.out.println("#--- sampleUpperCase2");
		printlnAll(getUpperCaseList(list));
	}
	
	/**
	 * Get a new UPPER CASE list.
	 * 
	 * @param list
	 * @return
	 */
	private List<String> getUpperCaseList(List<String> list) {
		List<String> newList = new ArrayList<String>();
		list.stream().map(String::toUpperCase).forEach(e -> newList.add(e));
		return newList;
	}
	
	private void sampleShorterThan(List<String> list){
		System.out.println("# sampleShorterThan ");
		System.out.println(isAllShorterThan(list, 9)); 
		System.out.println(isAllShorterThan(list, 8));

		System.out.println(isAnyShorterThan(list, 5));
		System.out.println(isAnyShorterThan(list, 4));
	}
	
	// Try to use 'allMatch'
	private boolean isAllShorterThan(List<String> list, int length){
		return list.stream().allMatch(e -> e.length() < length);
	}
	
	// Try to use 'anyMatch'
	private boolean isAnyShorterThan(List<String> list, int length){
		return list.stream().anyMatch(e -> e.length() < length);
	}
}
