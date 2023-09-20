package J1SP0011;

import java.math.BigInteger;

public class Number {

    private int base;
    private String value;

    public Number() {
    }

    public Number(int base, String value) {
        this.base = base;
        this.value = value;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //    convert
    public String convert(int outputBase) {
        BigInteger decimal;
        switch (base) {
            case 2:
                decimal = new BigInteger(BinToDec());
                break;
            case 10:
                decimal = new BigInteger(value);
                break;
            case 16:
                decimal = new BigInteger(HexToDec());
                break;
            default:
                return "Invalid";
        }

        switch (outputBase) {
            case 2:
                return DecToBin(decimal);
            case 10:
                return decimal.toString();
            case 16:
                return DecToHex(decimal);
            default:
                return "Invalid";
        }
    }

    public String BinToDec() {
        BigInteger result = BigInteger.ZERO;
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char tmp = value.charAt(i);
            int digit = Character.getNumericValue(tmp);
            result = result.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(digit));
        }
        return result.toString();
    }

    public String HexToDec() {
        BigInteger result = BigInteger.ZERO;
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char tmp = value.charAt(i);
            int digit = Character.isDigit(tmp) ? tmp - '0' : tmp - 'A' + 10;
            result = result.multiply(BigInteger.valueOf(16)).add(BigInteger.valueOf(digit));
        }
        return result.toString();
    }

    public String DecToBin(BigInteger input) {
        if (input.equals(BigInteger.ZERO)) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (!input.equals(BigInteger.ZERO)) {
            BigInteger tmp = input.mod(BigInteger.valueOf(2));
            result.insert(0, tmp.intValue());
            input = input.divide(BigInteger.valueOf(2));
        }
        return result.toString();
    }

    public String DecToHex(BigInteger input) {
        if (input.equals(BigInteger.ZERO)) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        String hexStr = "0123456789ABCDEF";
        while (!input.equals(BigInteger.ZERO)) {
            BigInteger tmp = input.mod(BigInteger.valueOf(16));
            result.insert(0, hexStr.charAt(tmp.intValue()));
            input = input.divide(BigInteger.valueOf(16));
        }
        return result.toString();
    }

}
