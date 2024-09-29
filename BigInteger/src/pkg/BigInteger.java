package pkg;

import java.util.Arrays;

public class BigInteger {
	private int[] digits;

    public BigInteger(String number) {
    	//IF ANYTHING OTHER THAN AN INT IS ENTERED, WILL THROW EXCEPTION
    	 if (!number.matches("-?\\d+")) {
             throw new IllegalArgumentException("Must be a Number");
         }
    	 //IF A NUMBER IS NEGATIVE, WILL THROW EXCEPTION
    	 if (number.charAt(0) == '-') {
    		 throw new IllegalArgumentException("Must be a Positive Number");
         }
        digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = number.charAt(i) - '0';
        }
    }
    //ADD TWO BIG NUMS TOGETHER
    public BigInteger add(BigInteger other) {
        int maxLength = Math.max(this.digits.length, other.digits.length);
        int[] result = new int[maxLength + 1];
        int carry = 0;
        //ADDS EACH DIGIT IN THE CORRECT LOCATION
        for (int i = 0; i < maxLength; i++) {
            int sum = carry;
            if (i < this.digits.length) {
                sum += this.digits[this.digits.length - 1 - i];
            }
            if (i < other.digits.length) {
                sum += other.digits[other.digits.length - 1 - i];
            }
            result[maxLength - i] = sum % 10;
            carry = sum / 10;
        }
        result[0] = carry;
        //RETURNS THE SUM OF THE NUMBERS
        return new BigInteger (Arrays.toString(result).replaceAll("[^0-9]", ""));
        
    }
    //CONVERT BIG NUM TO STRING
    public String toString() {
        return Arrays.toString(digits).replaceAll("[^0-9]", "");
    }
	
}

