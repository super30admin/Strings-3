// Time Complexity : O(1)
// Space Complexity : O(1)
class Solution {
    String[] below20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	String[] thousands = { "", "Thousand", "Million", "Billion" };
	String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}

		StringBuilder res = new StringBuilder();
		int index = 0;

		while (num > 0) {
			if (num % 1000 != 0) {
				res.insert(0, new StringBuilder(" "));
				res.insert(0, thousands[index]);
				res.insert(0, helper(num % 1000));
			}
			num /= 1000;
			index++;
		}

		return res.toString().trim();
	}

	private StringBuilder helper(int num) {
		if (num == 0) {
			return new StringBuilder();
		}

		if (num < 20) {
			// Case 1: num < 20
			return new StringBuilder().append(below20[num]).append(" ");
		} else if (num < 100) {
			// Case 2: 20 <= num < 100
			return new StringBuilder().append(tens[num / 10]).append(" ").append(helper(num % 10));
		} else {
			// Case 3: num > 100
			return new StringBuilder().append(below20[num / 100]).append(" Hundred ").append(helper(num % 100));
		}

	}
}