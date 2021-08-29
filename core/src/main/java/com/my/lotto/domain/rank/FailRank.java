package com.my.lotto.domain.rank;

import com.my.lotto.domain.LottoNumber;
import com.my.lotto.domain.LottoNumbers;
import com.my.lotto.domain.LottoRank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FailRank implements LottoRank {

    @Override
    public int rank() {
        return -1;
    }

    @Override
    public String text() {
        return "꽝입니다! 다음기회에...";
    }

    @Override
    public Boolean match(List<LottoNumber> sameNumbers, List<LottoNumber> differentNumbers, LottoNumber specialNumber) {
        return sameNumbers.size() < LottoNumbers.getSize() - 3;
    }
}
