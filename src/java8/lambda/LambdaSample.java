package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
		List<String> list = new ArrayList(Arrays.asList(elements));
		
		LambdaSample main = new LambdaSample();
		System.out.println("#--- Start");
		main.printlnAll(list);
		
		main.sampleUpperCase(list);
		main.sampleUpperCase2(list);
		main.sampleShorterThan(list);
		main.sampleSort(list);
		main.sampleReplaceAll(list);
		main.sampleRemoveIf(list);
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
	
	public void sampleSort(List<String> list){
		System.out.println("# sampleSort Asc");
		list.sort((o1, o2) -> o1.compareTo(o2));
		list.forEach(System.out::println);
		
		System.out.println("# sampleSort Desc");
		list.sort((o1, o2) -> o2.compareTo(o1));
		list.forEach(System.out::println);
	}
	
	public void sampleReplaceAll(List<String> list){
		System.out.println("# sampleReplaceAll");
		list.replaceAll(city -> city.startsWith("k") ? city + "+" : city);
		list.forEach(System.out::println);
	}
	
	// use Predicate. 'And' 'Or'
	public void sampleRemoveIf(List<String> list){
		System.out.println("# sampleRemoveIf");
		Predicate<String> predicate1 = city->{ return city.startsWith("n");};
		Predicate<String> predicate2 = city->{ return city.endsWith("a");};
		
		//list.removeIf(predicate1.and(predicate2)); 	// AND
		list.removeIf(predicate1.or(predicate2));		// OR
		list.forEach(System.out::println);
	}
}
