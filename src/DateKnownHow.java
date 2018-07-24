import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class DateKnownHow {
	public static void main(String args[]) {
		LocalTime time= LocalTime.now();
		LocalDate date= LocalDate.now();
		LocalDateTime nowdatetime= LocalDateTime.now();
		
		LocalDateTime datetime= LocalDateTime.now();
		ZonedDateTime nowzdatetime= ZonedDateTime.now();
		
		ZonedDateTime zdatetime=ZonedDateTime.of(datetime,ZoneId.systemDefault());
		System.out.println(zdatetime);
		Map<String, String> mapofzones= new HashMap<String,String>();
		
		//ZoneId.getAvailableZoneIds().forEach(zone->mapofzones.put(zone, zone));
		//mapofzones.keySet().forEach(zone->System.out.println(zone));
		String[] arr={"AA","BB","CC"};
		
		
		List<String> mylist= Arrays.asList(arr);
		System.out.println(String.join(",",mylist));
		
		
		
//		for(String zone:zdatetime.getZone().getAvailableZoneIds()) {
//			System.out.println(zone);
//		}

	}
}
