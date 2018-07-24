import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class MyRegex {

	public static void main(String[] args) {
		String regex="[a-z]+";
		Pattern allsmall = Pattern.compile(regex);
		System.out.println(allsmall.matcher("anbsddd").matches());		
		regex="[a-zA-Z]+";
		Pattern smallandcaps = Pattern.compile(regex);
		System.out.println(smallandcaps.matcher("ssqsqwsqwA").matches());
		

		Boolean alllet="akjdnskjcnsc".chars().allMatch(Character::isLetter);
		System.out.println(alllet);
		
		Pattern numpat= Pattern.compile("[0-9]+");
		System.out.println(numpat.matcher("-21444").matches());
		Boolean allnumbers="21444".chars().allMatch(Character::isDigit);
		System.out.println(allnumbers);
		
		allnumbers="-5".substring(1).chars().allMatch(Character::isDigit);
		System.out.println(allnumbers);
		
		Pattern newpattern= Pattern.compile("[a-zA-Z]+");
		System.out.println(newpattern.matcher("abcsd").matches());
	}

}

