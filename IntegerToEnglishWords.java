//Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
class IntegerToEnglishWords {
    private int[] parts;
    private String[] suffixes;
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;

        this.suffixes = new String[] {" Billion", " Million", " Thousand"};
        this.parts = new int[] {billion, million, thousand};

        StringBuilder result = new StringBuilder();
        boolean prefixFound = false;

        for(int i=0; i<3; i++){
            int currentPart = parts[i];
            prefixFound = false;
            if(num / currentPart > 0){
                prefixFound = true;
                result.append(getWordsFromDigits(num/currentPart));
                result.append(suffixes[i]);
            }
            num = num % currentPart;
            if(num > 0 && prefixFound){
                result.append(" ");
            }
        }
        if(num > 0){
            result.append(getWordsFromDigits(num));
        }
        return result.toString();
    }

    private String getWordsFromDigits(int num){
        StringBuilder words = new StringBuilder();
        boolean prefixFound = false;
        while(num > 0){
            if(num / 100 > 0){
                prefixFound = true;
                words.append(getWordForDigit( num / 100));
                words.append(" Hundred");
                num = num % 100;
            }else if( num / 10 > 0){
                if(prefixFound){
                    words.append(" ");
                }
                prefixFound = true;
                if(num / 10 == 1){
                    words.append(getTensWordForOneSeries(num));
                    break;
                }else{
                    words.append(getTensWordForDigit( num / 10));
                    num = num % 10;
                }
            }else{
                if(prefixFound) words.append(" ");
                words.append(getWordForDigit(num));
                num = num % 1;
            }
        }
        return words.toString();
    }

    private String getWordForDigit(int digit){
        String word = "";
        switch (digit) {
            case 1 -> word = "One";
            case 2 -> word = "Two";
            case 3 -> word = "Three";
            case 4 -> word = "Four";
            case 5 -> word = "Five";
            case 6 -> word = "Six";
            case 7 -> word = "Seven";
            case 8 -> word = "Eight";
            case 9 -> word = "Nine";
        }
        return word;
    }

    private String getTensWordForDigit(int digit){
        String word = "";
        switch (digit) {
            case 1 -> word = "Ten";
            case 2 -> word = "Twenty";
            case 3 -> word = "Thirty";
            case 4 -> word = "Forty";
            case 5 -> word = "Fifty";
            case 6 -> word = "Sixty";
            case 7 -> word = "Seventy";
            case 8 -> word = "Eighty";
            case 9 -> word = "Ninety";
        }
        return word;
    }

    private String getTensWordForOneSeries(int digit){
        String word = "";
        switch (digit) {
            case 10 -> word = "Ten";
            case 11 -> word =  "Eleven";
            case 12 -> word = "Twelve";
            case 13 -> word = "Thirteen";
            case 14 -> word = "Fourteen";
            case 15 -> word = "Fifteen";
            case 16 -> word = "Sixteen";
            case 17 -> word = "Seventeen";
            case 18 -> word = "Eighteen";
            case 19 -> word = "Nineteen";
        }
        return word;
    }

}