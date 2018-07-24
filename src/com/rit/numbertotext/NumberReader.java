package com.rit.numbertotext;

public class NumberReader {
// 10 
// 100 is a hundred
// 1000 is a thousand
// 100 1000 is 1 hundred thousand
// 999 000 is a nine hundred and ninety nine thousand
// 1000 000 is a 1 Million
// 999 000 000 is 9 hundred and 99 million
// 1000 000 000 is a 1 Billion

//	1000 000 000 Tenth  Digit is Billion
//	XXX1 000 000 Seventh Ninth  Digit is Million
//	XXXX 001 000 Fourth  to Sixth Digit is Thousand
//	XXXX XXX 100 Third  to Third Digit is Thousand
	
	String[] unitstext={"One","Two","Three","Four","Five","Six","Seven","Eigth","Nine"};
	String[] Tenstext={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eigthteen","Nineteen"};
	String[] TensMultipletext={"Ten","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eigthty","Ninety","Hundred"};
	public String getText(final long number){
		String text="";
		final long billions= number;
		final long billionsCount=billions/1000000000;
		if (billionsCount>0){
			text=text+getText(billionsCount)+" Billion ";
		}
		
		final long millions= billions-(1000000000*billionsCount);
		final long millonsCount=millions/1000000;
		if (millonsCount>0){
			text=text+getText(millonsCount)+" Million ";
		}

		final long thousands=millions-millonsCount*1000000;
		final long thousandsCount=thousands/1000;
		if (thousandsCount>0){
			text=text+getText(thousandsCount)+"Thousand ";
		}
		long hundreds=thousands-thousandsCount*1000;
		long hundredsCount=hundreds/100;
		if (hundredsCount>0){
			text=text+unitstext[(int)hundredsCount-1]+" Hundred ";
		}
	
		long lessthanhundred=hundreds-(hundredsCount*100);
		
		if (lessthanhundred>0){
			long tensindex= lessthanhundred/10;
			long units=lessthanhundred%10;
			if(tensindex==1){
				text=text+Tenstext[(int)units];
			}
			else if(tensindex==0)
			{
				text=text+unitstext[(int)units-1];
			}
			else if (tensindex>1)
			{
				text=text+TensMultipletext[(int)tensindex-1]+" " +unitstext[(int)units-1];
			}
		}
		return text;
	}
}
