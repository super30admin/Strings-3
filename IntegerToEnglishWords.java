//Time complexity : O(n)
//Space Complexity : O(1)
//Did it run on leetcode : yes

public class IntegerToEnglishWords {

    String[] b_20 = {"","One","Two","Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] tens = {"","Ten","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"","Thousand", "Million", "Billion" };

    public String numberToWords(int num) {

        if(num == 0) return "Zero";

        String result = "";
        int i = 0; // for suffixes
        while(num > 0){
            if(num % 1000 != 0){ //decipher only if triplet != 000
                //ex: 456,123 - Four Hundred Fifty six (helper result) thousand (suffix from thousands) One hundred twenty three(prev result)
                result = helper(num % 1000) + thousands[i] + " " +result; //pass the triplet and append suffix
            }
            num = num/1000;
            i++;
        }

        return result.trim();
    }

    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return b_20[num] + " "; //Generates Three -- (3)
        else if(num < 100) return tens[num/10] + " " + helper(num % 10); // Generates 'Twenty' -- (2)
        else return b_20[num/100] + " Hundred " + helper(num%100); //---- (1)
        //Ex: 123 - One Hundred Twenty Three(23 - generate it using recursion)
    }

}
