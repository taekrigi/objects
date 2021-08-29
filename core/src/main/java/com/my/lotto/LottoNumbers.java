package com.my.lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers;

    private static final int LOTTO_SIZE = 6;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        checkIfValidNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> get() {
        return lottoNumbers;
    }

    public static int getSize() {
        return LOTTO_SIZE;
    }

    private void checkIfValidNumbers(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("LottoNumbers must be size of " + LOTTO_SIZE);
        }
    }
}
