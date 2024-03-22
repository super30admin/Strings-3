// Time Complexity : O(1), worst case num = 113,999,999,999, will have 12 digits and for each triplet we are only taking 3 steps
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Divide bigger problem into smaller problems by finding the triplets and turning them into english.



class Solution {
    String[] below20Arr = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
            
    String[] tensArr = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};

    String[] suffArr = {"", "Thousand ", "Million ", "Billion "};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        String result = "";
        int i = 0;

        while(num != 0){
            int triplet = num%1000; // find the triplets
            if(triplet != 0)
                result = helper(triplet) + suffArr[i] + result;
            
            num = num/1000; // Reduce the number to process next triplets
            i++;
        }

        return result.trim();
    }

    private String helper(int num){
        if(num < 20){
            return below20Arr[num];
        }
        else if(num < 100){ //two digits
            return tensArr[num/10] + helper(num%10);
        }
        else{
            return below20Arr[num/100] + "Hundred " + helper(num%100);
        }
    }
}