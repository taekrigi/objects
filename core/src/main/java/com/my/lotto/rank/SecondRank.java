package com.my.lotto.rank;

import com.my.lotto.LottoNumber;
import com.my.lotto.LottoRank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecondRank implements LottoRank {

    @Override
    public int getRank() {
        return 2;
    }

    @Override
    public String getText() {
        return "정말 축하합니다. 2등입니다!";
    }

    @Override
    public Boolean match(List<LottoNumber> sameNumbers, List<LottoNumber> differentNumbers, LottoNumber specialNumber) {
        return null;
    }
}
