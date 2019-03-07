package leetcode;

import java.util.Stack;

public class twoStackSort {
    public static Stack<Integer> sortstack(Stack<Integer> input) {
        Stack<Integer> temp = new Stack<>();
        while (!input.isEmpty()) {
            if (temp.isEmpty() || temp.peek() >= input.peek()) {
                temp.push(input.pop());
            } else {
                int topOfInput = input.pop();
                while (!temp.isEmpty() && temp.peek() < topOfInput) {
                    input.push(temp.pop());
                }
                temp.push(topOfInput);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.push(34);
        input.push(3);
        input.push(31);
        input.push(98);
        input.push(92);
        input.push(23);
        for (Integer num : sortstack(input)) {
            System.out.println(num);
        }
    }
}
