package com.my.lotto;

import java.util.List;

public class LottoDetailResult {

    private LottoRank rank;
    private List<LottoNumber> sameNumbers;
    private List<LottoNumber> differentNumbers;

    public LottoDetailResult(
        LottoRank rank,
        List<LottoNumber> sameNumbers,
        List<LottoNumber> differentNumbers
    ) {
        this.rank = rank;
        this.sameNumbers = sameNumbers;
        this.differentNumbers = differentNumbers;
    }

    public LottoRank getRank() {
        return rank;
    }

    public List<LottoNumber> getSameNumbers() {
        return sameNumbers;
    }

    public List<LottoNumber> getDifferentNumbers() {
        return differentNumbers;
    }
}
