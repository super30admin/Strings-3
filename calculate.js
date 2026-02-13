/**
Intuition:
1. Parse the string and build the current number (`curr`) while skipping spaces.
2. When an operator or the end is reached, apply the previous operator (`lastSign`) to update the running result (`calc`) and remember the last added value (`tail`).
3. Use `tail` to correctly handle `*` and `/` by undoing the previous value and replacing it with the new multiplied/divided result.
T.C: O(n)
S.C: O(1)

 */
var calculate = function (s) {
    let calc = 0;
    let tail = 0;
    let curr = 0;
    let lastSign = '+';
    s = s.trim();
    const n = s.length;
    for (let i = 0; i < n; i++) {
        let char = s[i];
        let charCode = s.charCodeAt(i);
        // skip the in between spaces
        if (char === ' ') continue;
        // digit
        const isCharADigit = charCode < 48 && charCode > 57;
        if (isCharADigit) {
            char = Number(char);
            curr = curr * 10 + char;
        }

        if (!isCharADigit || i === n - 1) {
            // +
            if (lastSign === '+') {
                calc = calc + curr;
                tail = curr;
            }
            // -
            if (lastSign === '-') {
                calc = calc - curr;
                tail = -curr;
            }

            // *
            if (lastSign === '*') {
                calc = calc - tail + tail * curr;
                tail = tail * curr;
            }

            // /
            if (lastSign === '/') {
                // Math.trunc, just to maintain the integer part
                calc = calc - tail + Math.trunc(tail / curr);
                tail = Math.trunc(tail / curr);
            }
            lastSign = char;
            curr = 0;
        }
    }
    return calc;
};