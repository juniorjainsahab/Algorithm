//https://leetcode.com/problems/asteroid-collision/
package leetCode;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }

        int[] output = new int[stack.size()];
        for (int i = output.length - 1; i >= 0; i--) {
            output[i] = stack.pop();
        }
        return output;
    }
}
