package com.company;
class ReverseInteger {
    public static int reverse(int x) {
        try {
            if (x == 0) {
                return 0;
            }
            int absX = Math.abs(x);
            int result = 0;
            int remainder = 0;
            int dividend = 0;
            while (absX > 0) {
                remainder = absX % 10;
                result = Math.addExact(Math.multiplyExact(result, 10), remainder);
                absX = absX/10;
            }
            result = result * (Math.abs(x)/x);
            return result;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}