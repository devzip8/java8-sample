package java8.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;

/**
 * Sample for Time
 * 
 * @author dev-neko
 * @since 2016/07/16
 */
public class TimeSample {

	public static void main(String[] args) {
		TimeSample main = new TimeSample();
		
		main.sampleElapsed(1000);
		main.sampleElapsed(5000);
		
		main.sampleLocalDate(2016, Month.JULY, 20);
		main.sampleLocalDate(2015, Month.JUNE, 1);
		
	}
	
	private void sampleElapsed(long waitMilliSec) {
		
		Instant start = Instant.now();
		try {
			Thread.sleep(waitMilliSec);
		} catch (InterruptedException e) {
		}
		
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		long millis = timeElapsed.toMillis();
		
		System.out.println("Elapaseed : " + millis);
	}
	
	private void sampleLocalDate(int year, Month month, int day) {
		LocalDate today = LocalDate.now();
		LocalDate targetDate = LocalDate.of(year, month, day);

		System.out.println("Today      : " + today);
		System.out.println("targetDate : " + targetDate);
		
		System.out.println("isLeapYear: " + targetDate.isLeapYear());
		System.out.println("isAfter   : " + targetDate.isAfter(today));
		System.out.println("isBefore  : " + targetDate.isBefore(today));
	}
}
