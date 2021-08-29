package com.my.lotto.rank;

import com.my.lotto.LottoNumber;
import com.my.lotto.LottoNumbers;
import com.my.lotto.LottoRank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FifthRank implements LottoRank {

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public String text() {
        return "정말 축하합니다. 5등입니다!";
    }

    @Override
    public Boolean match(List<LottoNumber> sameNumbers, List<LottoNumber> differentNumbers, LottoNumber specialNumber) {
        return sameNumbers.size() == LottoNumbers.getSize() - 3;
    }

}
