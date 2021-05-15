// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
  String[] below20, below100, thousand;

  public String numberToWords(int num) {
    if (num == 0)
      return "Zero";

    below20 = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    below100 = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    thousand = new String[] { "", "Thousand", "Million", "Billion" };

    int i = 0;
    String result = "";
    while (num > 0) {
      if (num % 1000 > 0) {
        result = helper(num % 1000) + thousand[i] + " " + result;
      }
      num = num / 1000;
      i++;
    }

    return result.trim();

  }

  private String helper(int num) {
    if (num == 0)
      return "";

    else if (num < 20)
      return below20[num] + " ";

    else if (num < 100)
      return below100[num / 10] + " " + helper(num % 10);

    else
      return below20[num / 100] + " Hundred " + helper(num % 100);
  }
}