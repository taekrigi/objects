package com.my.lotto.domain;

public class LottoNumber {

    private int number;

    private static final int MIN = 1;
    private static final int MAX = 45;

    public LottoNumber(int number) {
        checkIfValidNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void checkIfValidNumber(int number) {
        if (!(MIN <= number && number <= MAX)) {
            throw new IllegalArgumentException("number must be between " + MIN + " and " + MAX);
        }
    }
}
