package com.my.lotto.domain.rank;

import com.my.lotto.domain.LottoNumber;
import com.my.lotto.domain.LottoNumbers;
import com.my.lotto.domain.LottoRank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThirdRank implements LottoRank {

    @Override
    public int rank() {
        return 3;
    }

    @Override
    public String text() {
        return "정말 축하합니다. 3등입니다!";
    }

    @Override
    public Boolean match(List<LottoNumber> sameNumbers, List<LottoNumber> differentNumbers, LottoNumber specialNumber) {
        return sameNumbers.size() == LottoNumbers.getSize() - 1;
    }
}
