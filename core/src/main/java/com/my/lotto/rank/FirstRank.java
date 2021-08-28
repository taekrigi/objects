package com.my.lotto.rank;

import com.my.lotto.LottoNumber;
import com.my.lotto.LottoRank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FirstRank implements LottoRank {

    @Override
    public int getRank() {
        return 1;
    }

    @Override
    public String getText() {
        return "정말 축하합니다. 1등입니다!";
    }

    @Override
    public Boolean match(List<LottoNumber> sameNumbers, List<LottoNumber> differentNumbers, LottoNumber specialNumber) {
        return null;
    }
}
