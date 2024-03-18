package week8.day1;
//TC - O(1) , as fixed no of operations
//SC - recursive stack space
class Solution17 {
	String[] below20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	String[] thousands = { "", " Thousand ", " Million ", " Billion " };

	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		String result = new String();
		int i = 0;
		while (num != 0) {
			int triplet = num % 1000; // 314432745 //314432
			if (triplet != 0)
				result = helper(triplet).trim() + thousands[i] + result;
			num = num / 1000;
			i++;
		}
		return result.trim();
	}

	private String helper(int num) {
		if (num < 20) {
			return below20[num] + " ";
		} else if (num < 100) {
			int digit2 = num / 10;
			return tens[digit2] + " " + helper(num % 10);
		} else if (num >= 100) {
			int digit1 = num / 100;
			return below20[digit1] + " Hundred " + helper(num % 100);
		}
		return "";
	}
}

public class NumberToWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution17 s = new Solution17();
		System.out.println(s.numberToWords(123));

	}

}
