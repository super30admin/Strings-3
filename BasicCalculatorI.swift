//
//  BasicCalculatorI.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/11/26.
//

import Foundation
class BasicCalculatorI {
    
    init() {
        
    }
    
    //input - 1 - (2 + (3 - (2 - 6)) + 2) + 6
    /*
     These doesn't have brackets - to solve this.
     take 2 varibales
     last sign, current
     
     Before opening bracket, push the sign in the stack. for opening bracket - push Int.max in the stack. Right after Int.max, push + and 0 for lastSign and current
     1. for + sign - +1 (store +1 in stack before the opening bracket which is Int.max)
     2. for - sign - -1
     3. for * sign = +2
     4. for division - -2
     Resolve stack on enoutering the closing bracket. Remove Int.max (for opening bracket) from the stack. Take out the sign and multiply it with the intermediate result. Then push it again on the stack
     Once a closing bracket is resolved, then update lastSign to + and current to 0
     when opening braket is encountered - update to + and 0
     time - O(n)
     space - O(n)
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

    //O(n) time , space - O(n)
    var i = 0
    func calculate(_ s: String) -> Int {
        let s = s.trimmingCharacters(in: .whitespaces)
        let sArr = Array(s)
        let n = sArr.count

        var current = 0
        var lastSign: Character = "+"
        var stack = Stack<Int>()

        for i in 0..<n {
            let ch = sArr[i]
            //if digit then set it in current
            if let cNum = Int(String(ch)) {
                current = current * 10 + cNum
            } else if (ch == "(") {
                if (lastSign == "+") {
                    stack.push(1)
                } else if (lastSign == "-") {
                    stack.push(-1)
                } else if (lastSign == "*") {
                    stack.push(2)
                } else if (lastSign == "/") {
                    stack.push(-2)
                }
                stack.push(Int.max) //opening bracket
                current = 0
                lastSign = "+" //after pushing (, mark current to 0 bz it's not a number, make lastSign to + (default)
            } else if (ch == ")") {
                //find intermediate result upto the opening bracket
                //process the num. Number will be processed based on + or -
                if (lastSign == "+") {
                    stack.push(current)
                } else if (lastSign == "-") {
                    stack.push(-current)
                }
                //for divide and multiply as well

                //unwrap the stack till openin gbracket.
                var inter = 0 //intermediate result
                while (stack.peek() != Int.max) {
                    inter += stack.pop()!
                }
                let _ = stack.pop()! //pop out infinity
                let popped = stack.pop()! //equivalent of sign below (
                if (popped == 1 || popped == -1) {
                    inter = inter * popped
                } else if (popped == 2) { //multiplication

                } else {

                }
                stack.push(inter)
                current = 0
                lastSign = "+" // In case of closing bracket also, push current as 0 and lastSign as +
            } else if (!ch.isNumber && ch != " ") {
                if (lastSign == "+") {
                    stack.push(current)
                } else {
                    stack.push(-current)
                }
                //for multiple and divide as well
                current = 0
                lastSign = ch
            }
        }

        var calc = 0
        if (sArr[n-1] != ")") {
            if (lastSign == "+") {
                stack.push(current)
            } else {
                stack.push(-current)
            }
            //multiply and division
        }
        while (!stack.isEmpty()) {
            calc += stack.pop()!
        }
        return calc
    }
}

//MARK: Use recursive solution for above one
class BasicCalculatorIUsingRecursion {
    var i = 0
    func calculate(_ s: String) -> Int {
        var s = s.trimmingCharacters(in: .whitespaces)
        let sArr = Array(s)
        return helper(sArr)
    }
    
    func helper(_ sArr: [Character]) -> Int {
        var current = 0
        var lastSign: Character = "+"
        var calc = 0
        while (i < sArr.count) {
            let ch = sArr[i]
            if let cNum = Int(String(ch)) {
                current = current * 10 + cNum
                i += 1
            } else if (ch == "(") {
                i += 1
                current = helper(sArr)
            } else if (ch == ")") {
                i += 1
                //If we are at closing brack, first process the curent number and return calc to the bracket
                if (lastSign == "+") {
                    calc += current
                } else if (lastSign == "-") {
                    calc -= current
                }
                return calc
            } else if (ch == "+" || ch == "-"){
                if (lastSign == "+") {
                    calc += current
                } else if (lastSign == "-") {
                    calc -= current
                }
                current = 0
                lastSign = ch
                i += 1
            } else {
                i += 1
            }
        }
        if (lastSign == "+") {
            calc += current
        } else if (lastSign == "-") {
            calc -= current
        }
        return calc
    }
}
