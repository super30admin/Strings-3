// TC : O(log num)
// SC : O(log num)
class IntegerToEnglish {

    String[] below_20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

        String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

        String[] thousands = {"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int index = 0;
        String words = "";
        while(num > 0) {
            int triplet = num % 1000;
            if(triplet != 0)
                words = processtriplet(triplet) + thousands[index] + " "+ words;
            index++;
            num = num / 1000;
        } 
        return words.trim();
    }

    private String processtriplet(int triplet) {
        String result = new String();
        if(triplet >= 100) {
            result = below_20[triplet / 100] + " Hundred ";
            triplet = triplet % 100;
        }
        if(triplet >= 20) {
            result += tens[triplet / 10] + " ";
            triplet = triplet % 10;
        }
        if(triplet > 0) {
            result += below_20[triplet % 20] + " ";
        }
        return result;
    }
}