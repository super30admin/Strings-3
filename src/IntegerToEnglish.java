// Time Complexity:  O(n)
// Space Complexity: O(1)
// where n is length of given string

class IntegerToEnglish {

    private String[] below20 = {"","One","Two","Three","Four","Five",
            "Six","Seven","Eight","Nine","Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen",
            "Sixteen","Seventeen","Eighteen","Nineteen"};

    private String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty",
            "Sixty","Seventy","Eighty","Ninety"};

    private String[] suffix = {"","Thousand","Million","Billion","Trillion"};

    public String numberToWords(int num) {

        if(num == 0)
            return "Zero";

        String res = "";
        int i=0;

        while(num > 0) {
            int temp = num % 1000;
            if(temp != 0) {                                            // if num != 100, 000, 000
                String cur = getWord(temp).trim();
                if(suffix[i] == null)                                  // part "789" for num = 123, 456, 789
                    res = cur + res;
                else                                                   // part "123" and "456" for num = 123, 456, 789
                    res = cur + " " + suffix[i] + " " + res;             // suffixes "Thousand" for "456" and "Million" for "123"
            }
            i++;
            num /= 1000;
        }
        return res.trim();
    }
    private String getWord(int num) {
        if(num < 20)
            return below20[num];
        if(num < 100)
            return tens[num/10] + " " + getWord(num%10);               // Recursive call for "1" in num = "91"
        return getWord(num/100) + " Hundred " + getWord(num%100);      // Recursive calls for "1" and "23" in num = "123"
    }
}