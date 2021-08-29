package com.my.lotto.domain;

import java.util.List;

public interface LottoRank {

    int rank();

    String text();

    Boolean match(List<LottoNumber> sameNumbers, List<LottoNumber> differentNumbers, LottoNumber specialNumber);

    default boolean hasSpecialNumber(List<LottoNumber> differentNumbers, LottoNumber specialNumber) {
        return differentNumbers.stream().anyMatch(number -> number.getNumber() == specialNumber.getNumber());
    }
}
