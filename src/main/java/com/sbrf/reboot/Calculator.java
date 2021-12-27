package com.sbrf.reboot;

public class Calculator {

    public <T extends Number> double getAddition(T firstNumber, T secondNumber) {
        if (firstNumber.doubleValue() % 1 != 0 || secondNumber.doubleValue() % 1 != 0) {
            return Double.sum(firstNumber.doubleValue(), secondNumber.doubleValue());
        } else {
            if (((Math.abs(firstNumber.doubleValue()) + Math.abs(secondNumber.doubleValue())) > Integer.MAX_VALUE) &&
                    Math.signum(firstNumber.doubleValue()) == Math.signum(secondNumber.doubleValue())) {
                return Double.sum(firstNumber.doubleValue(), secondNumber.doubleValue());
            }
            return Integer.sum(firstNumber.intValue(), secondNumber.intValue());
        }
    }

    public <T extends Number> double getSubtraction(T firstNumber, T secondNumber) {
        if (firstNumber.doubleValue() % 1 != 0 || secondNumber.doubleValue() % 1 != 0) {
            return firstNumber.doubleValue() - secondNumber.doubleValue();
        } else {
            if (((Math.abs(firstNumber.doubleValue()) + Math.abs(secondNumber.doubleValue())) > Integer.MAX_VALUE) &&
                    Math.signum(firstNumber.doubleValue()) != Math.signum(secondNumber.doubleValue())) {
                return firstNumber.doubleValue() - secondNumber.doubleValue();
            }
            return (int) (firstNumber.doubleValue() - secondNumber.doubleValue());
        }
    }

    public <T extends Number> double getMultiplication(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() * secondNumber.doubleValue();
    }

    public <T extends Number> double getDivision(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() / secondNumber.doubleValue();
    }

    public <T extends Number> double getExponentiation(T firstNumber, T power) {
        if (firstNumber.doubleValue() % 1 != 0 || power.doubleValue() % 1 != 0) {
            return Math.pow(firstNumber.doubleValue(), power.doubleValue());
        } else {
            int result = 1;
            int numberOfMultiplications = power.intValue();
            do {
                result *= firstNumber.doubleValue();
                numberOfMultiplications--;
            } while (numberOfMultiplications != 0);
            return result;
        }
    }

    public <T extends Number> double getNthRoot(T number, T rootNumber) {
        return Math.pow(number.doubleValue(), 1 / rootNumber.doubleValue());
    }

    public <T extends Number> double getLogarithm(T number, T base) {
        double answer = Math.log(number.doubleValue()) / Math.log(base.doubleValue());
        int numberOfDigitsInAnswer = Double.toString(answer).length() - 1;
        int correctNumberOfDigits = numberOfDigitsInAnswer - 2;
        double exactAnswer = (Math.round(answer * Math.pow(10, correctNumberOfDigits))) / (Math.pow(10, correctNumberOfDigits));
        double plus = answer + 0.000000000000001;
        double minus = plus - Math.floor(answer);
        if (minus == 1) {
            return plus;
        } else {
            return exactAnswer;
        }
    }

}
