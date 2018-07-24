package com.rit.binaryconvertor;

public class BinaryConvertor {
	
	public String convertToBinary(float fullNumber)
	{
		//Get the sign bit
		String sign=(fullNumber<0?"1":"0");

		String input=String.valueOf(fullNumber);
		if(sign.equals("1")){
			fullNumber=Float.parseFloat(input.substring(1));
		}
		System.out.println("input is "+fullNumber);
		//get Integer part
		int number=(int)fullNumber;
		
		//get Binary of the fraction
		String fraction = getFranctionToBinary(fullNumber-number);
		
		//get Binary of the Integer
		String mantissastring=getIntegerToBinary(number);
		
		//Get Binary of Mantissa
		String mantissaresult= mantissastring+fraction;
	
		
		int exponent=0;
		//Find the first 1  
		int startindex=mantissastring.indexOf('1');
		
		//Calculate the exponent
		exponent=mantissastring.length()-startindex-1;
		//Add a bias to the exponent
		exponent=exponent+127;
		//Get Binary of the exponent
		String exponentstring= getIntegerToBinary(exponent);
		//Lpad the exponent
		exponentstring=String.format("%8s", exponentstring).replace(' ', '0');
		
		//Get 23 bits of the Mantissa
		mantissaresult=(mantissaresult.length()>=24?mantissaresult.substring(startindex+1,24):mantissaresult.substring(startindex+1));
		//Rpad mantissa
		mantissaresult=String.format("%-23s", mantissaresult).replace(' ', '0');
		return sign+exponentstring+mantissaresult;
	}

	private String getFranctionToBinary(float number) {
		StringBuffer fraction= new StringBuffer();
		while(number>0)
		{
			if (fraction.length()>=23){
				break;
			}
			float r= number*2;
			if(r>=1){
				fraction.append("1");
				number=r-1;
			}
			else
			{
				fraction.append("0");
				number=r;
			}
		}
		return fraction.toString();
	}

	public String getIntegerToBinary(int mantisa) {
		StringBuffer mantisastr= new StringBuffer();
		while(mantisa>0){
			if(mantisastr.length()>23){
				break;
			}
			String bit=(mantisa%2==1?"1":"0");
			mantisastr.append(bit);
			mantisa= mantisa/2;
		}
		return mantisastr.reverse().toString();
	}

}
