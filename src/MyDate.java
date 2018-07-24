import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class MyDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime datetime= LocalDateTime.of(2018,4,30,10,15,5);
		ZonedDateTime fromdateTime = ZonedDateTime.parse("2017-01-12T15:00:00Z");
		ZonedDateTime todateTime = 	 ZonedDateTime.parse("2017-01-16T19:00:00Z");
		
		
		//ZonedDateTime zdatetime= ZonedDateTime.of(datetime,ZoneId.);
		//System.out.println(dateTime);
		System.out.println(Duration.between(fromdateTime, todateTime).toHours());
		
//		System.out.println(zdatetime.getYear());
//		
//		LocalDate localdate= LocalDate.of(2018, 6, 4);
//		LocalDate localdatenow= LocalDate.now();
//		Period period=Period.between(localdatenow,localdate);
//		System.out.println(period.getMonths()+" Month");
//		System.out.println(period.getDays()+" Days");
//		System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()));
	}

}
