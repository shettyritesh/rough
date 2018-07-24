package com.rit.roman;

public class RomanConvertor {
	//$ -->> Unit
	//# -->> Five
	//@ -->> Tens
 	private String[] cache={"$","$$","$$$","$#","#","#$","#$$","#$$$","$@","@"};
	public String toRoman(int number){
		
		//Mapping table
//		------------------------------------
//			1			|		I
//		------------------------------------
//			5			|		V
//			10			|		X
//		------------------------------------		
//			50			|		L
//		------------------------------------		
//			100			|		C
//		------------------------------------		
//			500			|		D
//		------------------------------------		
//  		1000		|		M
//		------------------------------------		
		
		StringBuilder result=new StringBuilder(50);
		int thousandcount=number/1000;
		for(int i=0;i<thousandcount;i++){
			result.append("M");
		}
		int lessthanthausand=number%1000;
		if(lessthanthausand>100)
		{
			result.append(getString(100,"C","D","M",lessthanthausand));
		}

		int lessthanhundred=lessthanthausand%100;
		if(lessthanhundred==0 && lessthanthausand==100) {
			lessthanhundred=100;
		}
		if(lessthanhundred>10){
			result.append(getString(10,"X","L","C",lessthanhundred));
		}

		int lessthanten=lessthanhundred%10;
		if(lessthanten==0 && lessthanhundred==10) {
			lessthanten=10;
		}
		if(lessthanten>0){
			result.append(getString(1,"I","V","X",lessthanten));
		}
		return result.toString();
		
	}
	private String getString(int unit, String unitschar, String fiveschar, String tenschar, int number)
	{
		int index=number/unit-1;
		String basstring=cache[index];
		basstring=basstring.replace("$",unitschar);
		basstring=basstring.replace("@",tenschar);
		basstring=basstring.replace("#",fiveschar);
		return basstring;
	}
}
