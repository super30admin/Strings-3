//Time Complexity : O(1), helper has fixed 3 length number and when dividing the number in partition of 3, (Max billion, so length = 4)
//Space Complexity :O(1), length of triplet = 3
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Key thing here is divide the number by groups of 3 digits, 
 * and call a function to take care of these 3 digits number
 * ***/

public class Integer_to_English_Words {
	String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	String[] tens = {"","", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	String[] thousands = {"", "Thousand", "Million", "Billion"};
	
	public String numberToWords(int num) {
		if(num == 0)
			return "Zero";
		String result = "";
		int i=0;
		while(num > 0){ // till number is greater than zero
			if(num % 1000 > 0){
				result = helper(num % 1000) + thousands[i] + " " + result;
			}
			i++;
			num = num / 1000;
		}
		return result.trim();
	}

	private String helper(int num){
		if(num == 0)    // if number has become zero string would be empty
			return "";
		else if(num < 20)   // if less than 20, get from below 20 array directly based on num

			return below_20[num] + " "; 
		else if(num < 100)  // if num is less than 100, then get the prefix from tens(eg 56/10 = 5 which gives fifty) and call helper on 6
			return tens[num / 10] + " " + helper(num % 10);
		else    // num = 543 then below_20 gives three (543/100 = 43) and add hundred and call helper on rest part ie. num%100
			return below_20[num / 100] + " Hundred " + helper(num  % 100);
	}

}