// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number} num
 * @return {string}
 */
var numberToWords = function(num) {
    if (num == 0) return 'Zero';
    
    const billion = Math.floor(num / 1000000000);
    num = num % 1000000000;
    const million = Math.floor(num / 1000000);
    num = num % 1000000;
    const thousand = Math.floor(num / 1000);
    const rest = num % 1000;

    let result = "";
    
    if (billion != 0) result += helper(billion) + " Billion";
    if (million != 0) {
        if (result.length > 0) result += " ";
        result += helper(million) + " Million";
    }
    if (thousand != 0) {
        if (result.length > 0) result += " ";
        result += helper(thousand) + " Thousand";
    }
    if (rest != 0) {
        if (result.length > 0) result += " ";
        result += helper(rest);
    }
    return result;
};
    
var helper = function(num) {
    const below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];
    const tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];
    let result = "";
    
    const hundredsDigit = Math.floor(num / 100);
    num = num % 100;

    if (num < 20 && num != 0) {
        if (hundredsDigit != 0) result += below20[hundredsDigit] + " Hundred ";
        return result + below20[num];
    }

    const tensDigit = Math.floor(num / 10);
    const onesDigit = num % 10;

    if (hundredsDigit != 0) result += below20[hundredsDigit] + " Hundred";
    if (tensDigit != 0) {
        if (result.length > 0) result += " ";
        result += tens[tensDigit];
    }
    if (onesDigit != 0) {
        if (result.length > 0) result += " ";
        result += below20[onesDigit];
    }
    return result;
}
