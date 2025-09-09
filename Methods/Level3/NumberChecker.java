public class NumberChecker {
    public static void main(String[] args) {
        int number = 153;

        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + countDigits(number));

        int[] digits = storeDigits(number);
        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        System.out.println("Is duck number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong number: " + isArmstrongNumber(digits));
        System.out.println("Largest element: " + findLargest(digits));
        System.out.println("Second largest: " + findSecondLargest(digits));
        System.out.println("Smallest element: " + findSmallest(digits));
        System.out.println("Second smallest: " + findSecondSmallest(digits));
    }

    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int[] digits) {
        int sum = 0;
        int power = digits.length;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        int original = 0;
        for (int digit : digits) {
            original = original * 10 + digit;
        }
        return sum == original;
    }

    public static int findLargest(int[] digits) {
        int max = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > max) {
                max = digit;
            }
        }
        return max;
    }

    public static int findSecondLargest(int[] digits) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > max) {
                secondMax = max;
                max = digit;
            } else if (digit > secondMax && digit < max) {
                secondMax = digit;
            }
        }
        return secondMax;
    }

    public static int findSmallest(int[] digits) {
        int min = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < min) {
                min = digit;
            }
        }
        return min;
    }

    public static int findSecondSmallest(int[] digits) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < min) {
                secondMin = min;
                min = digit;
            } else if (digit < secondMin && digit > min) {
                secondMin = digit;
            }
        }
        return secondMin;
    }
}