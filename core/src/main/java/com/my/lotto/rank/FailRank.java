package com.my.lotto.rank;

import com.my.lotto.LottoNumber;
import com.my.lotto.LottoRank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FailRank implements LottoRank {

    @Override
    public int getRank() {
        return -1;
    }

    @Override
    public String getText() {
        return "꽝입니다! 다음기회에...";
    }

    @Override
    public Boolean match(List<LottoNumber> sameNumbers, List<LottoNumber> differentNumbers, LottoNumber specialNumber) {
        return null;
    }
}
