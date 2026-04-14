//
//  BasicCalculatorII.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/9/26.
//

/*
 we can do things on the go likein expression add operators
 sign     current    calculated     tail
 
 
 -> Process things when we hit a new sign. Nowehere we will be processing things when encountering digit.
 -> only at the last digit of the expression, we will process things based on the last sign.
 single pass algorithm
 time complexity - O(n)
 space complexity - O(1)
 */
import Foundation
class BasicCalculatorII {
    
    
    init() {
        let result = calculate("3+2*2")
        print("result \(result)")
    }
    
    //input - 3 + 2 * 2
    /*
     These doesn't have brackets - to solve this.
     take 4 variables - sign, current, calculated, tail
     */
    
    //time - O(n), space - O(1)
    func calculate(_ s: String) -> Int {
        var s = s.trimmingCharacters(in: .whitespaces)
        let sArr = Array(s)
        let n = sArr.count

        var prevSign: Character = "+"
        var calc = 0
        var tail = 0
        var current = 0

        for i in 0..<n {

            //to get the digit - we need to do 0 * 10 + digit.

            let ch: Character = sArr[i]
            
            //calculated and tail will remain same if it is a digit.
            if let num = Int(String(ch)) {
                current = current * 10 + num
            }

            //if it is a number
            //a new sign is enountered
            if (i == n - 1 || (!ch.isNumber && ch != " ")) {
                if (prevSign == "+") {
                    calc = calc + current
                    tail = current
                } else if (prevSign == "-") {
                    calc = calc - current
                    tail = -current
                } else if (prevSign == "*") {
                    calc = calc - tail + tail * current
                    tail = tail * current
                } else if (prevSign == "/") {
                    calc = calc - tail + tail / current
                    tail = tail / current
                }
                current = 0
                prevSign = ch
            }
        }
        return calc
    }
    
    //another approach - using stack (with extra space)
    /*
     process things on devisiion and multiplication
     
     3 + 6/3 - 2*3 + 2
     when a new sign comes up. then add the (lastSign)current in the stack. Update last sign to the new sign and current to 0.
     When we hit a new sign and last sign is devision or multiplication, take out last in from the stack and process it with current. Pu result inside the stack
     
     At the last digit, push (lastsign)digit in stack.
     it's integer stack. Take sum of all
     time complexity - O(n)
     space complexity - O(n) for stack
     */
    class Stack<T> {
        var elements: [T]
        var count: Int = 0
        init() {
            elements = []
        }

        func push(_ val: T) {
            elements.append(val)
            count += 1
        }

        func pop() -> T? {
            return elements.removeLast()
        }

        func peek() -> T? {
            return elements.last
        }

        func isEmpty() -> Bool {
            return elements.count == 0
        }
    }

    func calculateUsingStack(_ s: String) -> Int {
        let s = s.trimmingCharacters(in: .whitespaces)
        let sArr = Array(s)
        let n = sArr.count
        var stack = Stack<Int>()
        var lastSign: Character = "+"
        var current = 0

        for i in 0..<n {
            let ch = sArr[i]
            //if it's a digit
            if let num = Int(String(ch)) {
                current = current * 10 + num //if we hit "123" then it will formm the whole number 123 and save it in current. When the sign arrives then push lastSign<current> in the stack.
            }
            if (i == n - 1 || (!ch.isNumber && ch != " ")) {
                //We need to wait until the whole number e.g. 123 is processed. Then when + arrives, will push +123 to the stack.
                if (lastSign == "+") {
                    stack.push(current)
                } else if (lastSign == "-") {
                    stack.push(-current)
                } else if (lastSign == "*") {
                    let popped = stack.pop()!
                    stack.push(popped * current)
                } else if (lastSign == "/") {
                    let popped = stack.pop()!
                    stack.push(popped/current)
                }
                lastSign = ch
                current = 0
            }
        }
        var result = 0
        while (!stack.isEmpty()) {
            result += stack.pop()!
        }
        return result
    }
}
