package stacks.medium;

import util.Utils;

import java.util.Arrays;
import java.util.Stack;

public class CollidingAsteroids {

    public int[] collidingAsteroids(int[] asteroids) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || stack.peek() < 0 || asteroids[i] > 0)
                stack.push(asteroids[i]);
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(asteroids[i]))
                    stack.pop();
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroids[i]);
                else if (Math.abs(stack.peek()) == Math.abs(asteroids[i]))
                    stack.pop();
            }

        }
        int[] remainingAsteroids = new int[stack.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = stack.pop();
        }
        return remainingAsteroids;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-3, 5, -8, 6, 7, -4, -7};
        int[] expected = new int[]{-3, -8, 6};
        int[] actual = new CollidingAsteroids().collidingAsteroids(input);
        Utils.assertTrue(expected.length == actual.length);

        for (int i = 0; i < expected.length; i++) {
            Utils.assertTrue(expected[i] == actual[i]);
        }
        System.out.println(Arrays.toString(actual));
    }
}
