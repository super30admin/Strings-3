// Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)

// Time Complexity : O(N)
// Space Complexity : O(1) //Constant
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

let below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];

let tens = ["", "ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];

var helper = (num) => {
    if (num === 0)
        return "";
    // If number is less than 20, it has a unique word
    if (num < 20) {
        return below_20[num] + " ";
    } else if (num < 100) {
        // If less than 100, get the word for hundredth position and call helper again for 2 digit number
        return tens[Math.floor(num / 10)] + " " + helper(num % 10);
    } else {
        return below_20[Math.floor(num / 100)] + " Hundred " + helper(num % 100);
    }
}

/**
 * @param {number} num
 * @return {string}
 */
var numberToWords = function (num) {
    if (num === 0)
        return "Zero";
    let result = "";
    let thousands = ["", "Thousand", "Million", "Billion"];
    let i = 0;
    while (num > 0) {
        // Divide number into 3 units
        if (num % 1000 > 0) {
            result = helper(num % 1000) + thousands[i] + " " + result;
        }
        num = Math.floor(num / 1000);
        i++;
    }
    return result.trim()
};