//Approach - String arrays with basic numeral words are used.
//The number is divided into batch of 3s, helper function will convert this three into words, then thousand or million or billion is appended based on the level.
//Time Complexity - O(N) - length of the num integer
//Space Complexity - O(1) - asymptotically

class Solution {

  String[] lessThan20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};

  public String numberToWords(int num) {

    if(num == 0){
      return "Zero";
    }

    String result = "";
    int level = 0;

    while(num > 0){

      if(num%1000 != 0){
        result = helper(num%1000)+thousands[level]+" "+result;
      }
      level++;
      num = num/1000;
    }

    return result.trim();
  }

  public String helper(int num){
    if(num == 0){
      return "";
    }
    else if(num < 20){
      return lessThan20[num]+" ";
    }
    else if(num < 100){
      return tens[num/10]+" "+helper(num%10);
    }
    else{
      return lessThan20[num/100]+" Hundred "+helper(num%100);
    }
  }

}
