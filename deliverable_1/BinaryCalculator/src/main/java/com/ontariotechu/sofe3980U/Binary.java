package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 */
public class Binary {
    private String number = "0";  // string containing the binary value '0' or '1'

    /**
     * A constructor that generates a binary object.
     *
     * @param number a String of the binary values. It should contain only zeros or ones with any length and order.
     *               otherwise, the value of "0" will be stored.
     *               Trailing zeros will be excluded and empty string will be considered as zero.
     */
    public Binary(String number) {
        for (int i = 0; i < number.length(); i++) {
            // check each character if it's not 0 or 1
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                number = "0"; // if not store "0" and end the function
                return;
            }
        }
        // remove any trailing zeros
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') break;
        }
        //beg has the index of the first non-zero digit in the number
        this.number = number.substring(beg); // exclude the trailing zeros if any

        // uncomment the following code
        if (this.number == "") { // replace empty strings with a single zero
            this.number = "0";
        }
    }

    /**
     * Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
     *
     * @param num1 The first addend object
     * @param num2 The second addend object
     * @return A binary variable with a value of <i>num1+num2</i>.
     */
    public static Binary add(Binary num1, Binary num2) {
        // the index of the first digit of each number
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        //initial variable
        int carry = 0;
        String num3 = "";  // the binary value of the sum
        while (ind1 >= 0 || ind2 >= 0 || carry != 0) // loop until all digits are processed
        {
            int sum = carry; // previous carry
            if (ind1 >= 0) { // if num1 has a digit to add
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
                ind1--; // update ind1
            }
            if (ind2 >= 0) { // if num2 has a digit to add
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // convert the digit to int and add it to sum
                ind2--; //update ind2
            }
            carry = sum / 2; // the new carry
            sum = sum % 2;  // the resultant digit
            num3 = ((sum == 0) ? "0" : "1") + num3; //convert sum to string and append it to num3
        }
        Binary result = new Binary(num3);  // create a binary object with the calculated value.
        return result;

    }

    /**
     * Bit Wise or two binary variables.
     *
     * @param number1 The first or'd object
     * @param number2 The second or'd object
     * @return A binary variable with a value of <i>number1||number2</i>.
     */
    public static Binary or(Binary number1, Binary number2) {
        String num1 = number1.number;
        String num2 = number2.number;
        String result = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (num1.charAt(i) == '1' || num2.charAt(j) == '1') {
                    result = "1" + result;
                } else {
                    result = "0" + result;
                }
                i--;
                j--;
            } else if (i >= 0) {
                result = num1.charAt(i) + result;
                i--;
            } else if (j >= 0) {
                result = num2.charAt(j) + result;
                j--;
            }
        }
        return new Binary(result);
    }

    /**
     * Bit Wise and two binary variables.
     *
     * @param number1 The first and'd object
     * @param number2 The second and'd object
     * @return A binary variable with a value that had and the input params.
     */
    public static Binary and(Binary number1, Binary number2) {
        String num1 = number1.number;
        String num2 = number2.number;
        String result = "";
        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;

        // Make number same length by adding leading zeros
        if (num1Index > num2Index) {
            int diff = num1Index - num2Index;
            for (int i = 0; i < diff; i++) {
                num2 = "0" + num2;
            }
            num2Index = num1Index;
        } else if (num2Index > num1Index) {
            int diff = num2Index - num1Index;
            for (int i = 0; i < diff; i++) {
                num1 = "0" + num1;
            }
            num1Index = num2Index;
        }



        while (num1Index >= 0 || num2Index >= 0) {
            if (num1Index >= 0 && num2Index >= 0) {
                if (num1.charAt(num1Index) == '1' && num2.charAt(num2Index) == '1') {
                    result = "1" + result;
                } else {
                    result = "0" + result;
                }
                num1Index--;
                num2Index--;
            } else if (num1Index >= 0) {
                result = num1.charAt(num1Index) + result;
                num1Index--;
            } else if (num2Index >= 0) {
                result = num2.charAt(num2Index) + result;
                num2Index--;
            }
        }
        return new Binary(result);
    }

    /**
     * Bit Wise multiply two binary variables.
     *
     * @param number1 The first multiplied object
     * @param number2 The second multiplied object
     * @return A binary variable with a value of <i>number1 * number2</i>.
     */
    public static Binary multiply(Binary number1, Binary number2) {
        String num1 = number1.number;
        String num2 = number2.number;
        String result = "";
        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;

        // Make number same length by adding leading zeros
        if (num1Index > num2Index) {
            int diff = num1Index - num2Index;
            for (int i = 0; i < diff; i++) {
                num2 = "0" + num2;
            }
            num2Index = num1Index;
        } else if (num2Index > num1Index) {
            int diff = num2Index - num1Index;
            for (int i = 0; i < diff; i++) {
                num1 = "0" + num1;
            }
            num1Index = num2Index;
        }

        // Multiply
        int number1Int = Integer.parseInt(num1, 2);
        int number2Int = Integer.parseInt(num2, 2);

        int resultInt = number1Int * number2Int;
        result = Integer.toBinaryString(resultInt);

        return new Binary(result);

    }

    /**
     * Get the value of the binary variable.
     *
     * @return the value of the binary variable as a string.
     */
    public String getValue() {
        return number;
    }
}

