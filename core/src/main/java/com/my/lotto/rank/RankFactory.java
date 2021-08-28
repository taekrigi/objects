package com.my.lotto.rank;

import com.my.lotto.LottoNumber;
import com.my.lotto.LottoNumbers;
import com.my.lotto.LottoRank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RankFactory {

    private List<LottoRank> lottoRanks;

    public RankFactory(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public LottoRank call(
        List<LottoNumber> sameNumbers,
        List<LottoNumber> differentNumbers,
        LottoNumber specialNumber
    ) {
        return lottoRanks.stream()
                .filter(rank -> rank.match(sameNumbers, differentNumbers, specialNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("lotto rank invalid"));
    }
}
