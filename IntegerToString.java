//Time Complexity : O(1) 
//Space Complexity :O(1) 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

public class IntegerToString {
	String[] below20 = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	String[] below100 = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };
	String[] thArr = new String[] { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {
		String str = "";
		if (num == 0)
			return "Zero";
		int i = 0;
		while (num > 0) {
			if (num % 1000 > 0)
				str = getStr(num % 1000).trim() + " " + thArr[i] + " " + str;
			num = num / 1000;
			i++;
		}
		return str.trim();
	}

	private String getStr(int num) {
		if (num < 20) {
			return below20[num];
		} else if (num < 100) {
			return below100[num / 10] + " " + getStr(num % 10);
		} else {
			return below20[num / 100] + " Hundred " + getStr(num % 100);
		}
	}

	public static void main(String[] args) {
		System.out.println(new IntegerToString().numberToWords(1204567891));
	}
}
