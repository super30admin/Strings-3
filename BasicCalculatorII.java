class BasicCalculatorII {
    public int calculate(String s) {

        int sum = Integer.parseInt(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == '+') {
                sum = Integer.parseInt(s.charAt(i)) + sum;
            } else if (s.charAt(i) == '-') {
                sum = sum - Integer.parseInt(s.charAt(i));
            } else if (s.charAt(i) == '*') {
                sum = sum * Integer.parseInt(s.charAt(i));
            } else {
                sum = sum / Integer.parseInt(s.charAt(i));
            }
        }



        return sum;

    }
}