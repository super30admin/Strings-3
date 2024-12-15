// Time : O(1) # constant time - just num length
class Solution {
    String[] thousands = new String[]{""," Thousand "," Million "," Billion "};
    String[] below20 = new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven",
    "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String result = "";
        int i = 0;
        // 123
        // 243 789
        // Keep forming the triplets untill the number > 0
        while (num > 0) {
            int triplet = num % 1000;
            System.out.println("triplet " + triplet);
            if (triplet > 0) {
                result = helper(triplet).trim() + thousands[i] + result;
            }
            num = num / 1000;
            System.out.println("num " + num);
            i++;
            System.out.println("i " + i);
        }
        return result.trim();
    }

    public String helper(int num) {
        if (num < 20) {
            // 3 - three
            // 11
            return below20[num];
        } else if (num < 100) {
            // 23 - twenty three
            // 89
            return tens[num / 10] + " " + below20[num % 10];
        } else {
            // 123 - one hundred
            // 789
            return below20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}