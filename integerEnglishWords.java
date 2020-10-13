// TC: O(N) where N is number of integers in NUm
// SC : O(1) for constant space and String array we are using is also constant

public class integerEnglishWords {

	private String[] LESS_THAN_20 = {"", "One", "Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] TENS = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty", "Ninety"};
    private String[] THOUSANDS = {"","Thousand","Million","Billion"};
    
	public String numberWords(int num) {
		
		if(num == 0)
			return "Zero";  // if the number is 0, return Zero
		
		String words = ""; // string where will store our result
		int i = 0;
		// loop over the number
		while(num > 0) {
			if(num%1000 != 0) { // check for value less than 1000 since our string array is limited to THOUSANDS
				words = helper(num%1000) + THOUSANDS[i]+" "+ words;  // call a function if num is less than 1000 and
			//add ith index value from thousands array and append the previous calculated words to current string
			}
			num /= 1000;  // divide the number by 1000 so that we can check for the remaining integer values in number
			i++;
		}
		return words.trim();
		
	}
	
	public String helper(int num) {
		if(num == 0)  // if the number is 0, we have nothing to append to string
			return "";
		else if(num < 20) // if the number is less than 20, we directly fetch the value from LESS_THAN_ 20 string array
			return LESS_THAN_20[num]+" ";
		else if(num < 100)  // if the value is less than 100, loop recurse over the function till we find our values present in array
			// since we know values less than hundred will be in TENS, we add our TENS value into string and recurse over the remaining value
			return TENS[num/10] +" "+ helper(num%10);
		else // if the value is greater than 100, we retrieve the number from LESS_THAN_20 and add hundreds to it and recurse over the remaining integer values
			return LESS_THAN_20[num/100] + " Hundred "+ helper(num%100);
	}
}
