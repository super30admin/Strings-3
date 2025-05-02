
//TC: O(1)
//SC:O(1)
class IntegerToEnglishWords {
    static String[] thousands=new String[]{"","Thousand","Million","Billion"};
	static String[] below_20=new String[] {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
			"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	static String[] tens=new String[] {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	//183 222 432
	public String numberToWords(int num) {

		if(num==0) {
			return "Zero";
		}
		int i=0;
		String res="";
		while(num>0) {
			int curr=num%1000;
			if(curr!=0) {
				res=magic(curr).trim()+" "+thousands[i]+" "+res;
			}
			num=num/1000;
			i++;
		}
		return res.trim();
	}
	
	private String magic(int curr) {
		if(curr<20) {
			return below_20[curr];
		}else if(curr<100) {
			return tens[curr/10]+" "+magic(curr%10);
		}else {
			return below_20[curr/100]+" "+"Hundred"+" "+magic(curr%100);
		}
	}

}