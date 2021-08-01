class IntegerToEnglishWords {
    public String numberToWords(int num) {

        Map<Integer, String> tens = new HashMap<>();

        map.put(1, "Ten");
        map.put(2, "Hundred");
        map.put(3, "Thousand");
        map.put(4, "Hundred Thousand");
        map.put(5, "Million");
        map.put(6, "Billion");

        Map<Integer, String> digits = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "five");
        map.put(6, "Six");
        map.put(6, "Seven");
        map.put(6, "Eight");
        map.put(6, "Nine");

        String number = num.toString();
        StringBuilder answer = new StringBuilder();

        for (int i=number.length; i>=0; i--) {

            answer.append(digits.get(number.charAt(i)));

        }

        return answer;

    }
}