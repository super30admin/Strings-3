class IntegerToEnglish {
    String[] thousands = new String[]{"", " Thousand ", " Million ", " Billion "};
    String[] below_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

public String numberToWords(int num) {
    if(num == 0)
        return "Zero";
    int i=0; 
    StringBuilder sb = new StringBuilder();

    while(num > 0){
        int triplet = num %1000;
        if(triplet > 0){
            sb.insert(0, helper(triplet).trim()+thousands[i]);
        }
        num = num / 1000;
        i++;
    }
        return sb.toString().trim();
}

private String helper(int num){
    StringBuilder res = new StringBuilder();

    if(num < 20){
        res.append(below_20[num]);
    }

    else if(num < 100)
    {
         res.append(tens[num/10]).append(" ").append(below_20[num%10]);
    }
    else
    res.append(below_20[num/100]).append(" Hundred ").append(helper(num%100));

    return res.toString();
}
}
