package com.my.lotto;

import java.util.List;

public interface LottoRank {

    int getRank();

    String getText();

    Boolean match(List<LottoNumber> sameNumbers, List<LottoNumber> differentNumbers, LottoNumber specialNumber);
}
