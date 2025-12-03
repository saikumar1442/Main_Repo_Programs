package DateTimeAPI;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class DateTimeAPIEx {

	public static void main(String[] args) {
		
		LocalDate currentDate = LocalDate.now();
		
		System.out.println("Current Date : " + currentDate);
		
		LocalTime currentTime = LocalTime.now();
		
		System.out.println("Current Time : " +currentTime);
		
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("Current date and time : "+now);
		
		
		Month month = currentDate.getMonth();
		int dayOfMonth = currentDate.getDayOfMonth();
		DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
		int dayOfYear = currentDate.getDayOfYear();
		
		System.out.println(month + " "+dayOfMonth+" "+dayOfWeek+ " "+dayOfYear);
		
		
		DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		String format = currentDate.format(simpleDateFormat);
		
		System.out.println("DATE FORMAT :::: "+format);
		
		/*
		 *  Below code is to calculate the difference between two LocalDate by using Period
		 * 
		 */
		
		LocalDate from = LocalDate.of(2024, 05, 24);
		
		LocalDate to = LocalDate.of(2024, 06, 27);
		
		Period period = Period.between(from, to);
		
		System.out.println("PERIOD DATE AND TIME :" +period.getYears());
		
		System.out.println("PERIOD DATE AND TIME :" +period.getMonths());
		
		System.out.println("PERIOD DATE AND TIME :" +period.getDays());
		
		/*
		 *  Below code is to calculate the difference between two LocalDateTime by using Duration
		 * 
		 */
		
		LocalDateTime fro = LocalDateTime.of(2024, 04, 20, 12, 30, 10);
		
		LocalDateTime too = LocalDateTime.now();
		
		Duration duration = Duration.between(fro, too);
		
		long days = duration.toDays();
		
		long hours = duration.toHours();
		
		long minutes = duration.toMinutes();
		
		long seconds2 = duration.getSeconds();
		
		System.out.println(days + " " + hours +" " + minutes + " " + seconds2);
		
		

	}

}
