package com.my.lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers;

    private final int LOTTO_SIZE = 6;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        checkIfValidNumbers();
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> get() {
        return lottoNumbers;
    }

    private void checkIfValidNumbers() {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("LottoNumbers must be size of " + LOTTO_SIZE);
        }
    }
}
