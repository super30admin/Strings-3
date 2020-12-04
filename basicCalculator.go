// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
have an int stack
and num =0, lastsign = +
loop over s
if its a digit then append to num in next position
if its not digit and not  space
check for sign if + then push num to stack else if its - then push -num to stack
else if its * pop multiply to num and push to stack else if its / pop divide by num and push to stack
set num to 0 and update lastsign to current

set res to 0
while stack not empty add all elements of stack and return res
*/
package main

import "fmt"

func calculate(s string) int {
	if len(s) == 0 {
		return 0
	}
	st := []int{}
	n := len(s)
	num := 0
	lastSign := '+'
	for i:=0;i<n;i++ {
		if s[i] - '0' < 10 {
			num = num * 10 + int(s[i] - '0')
		}
		if (!(s[i] - '0' < 10) && s[i] != ' ') || i == n - 1  {
			if lastSign == '+' {
				st = append(st, num)
			} else if lastSign == '-' {
				st = append(st, -1 * num)
			} else if lastSign == '*' {
				v := st[len(st) - 1]
				st = st[:len(st) - 1]
				st = append(st, v * num)

			} else if lastSign == '/' {
				v := st[len(st) - 1]
				st = st[:len(st) - 1]
				st = append(st, v / num)
			}
			num = 0
			lastSign = rune(s[i])
		}
	}

	res := 0
	for len(st) > 0 {
		v := st[len(st) - 1]
		st = st[:len(st) - 1]
		res += v
	}
	return res
}

func MainCalculator() {
	fmt.Println(calculate("3+2*2")) //expected 7
}
