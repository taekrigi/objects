package com.my.lotto;

import com.my.lotto.rank.RankFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LottoServiceTest {

    @Autowired
    RankFactory rankFactory;

    @Test
    @DisplayName("로또 결과에 따라 적절한 Rank 구현 객체를 반환해야 한다.")
    void should_return_proper_Rank_impl_class() {
        assertAll(
            () ->  testRank(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, 1),
            () ->  testRank(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7), 7, 2),
            () ->  testRank(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 8), 7, 3),
            () ->  testRank(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 9, 8), 7, 4),
            () ->  testRank(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 10, 9, 8), 7, 5),
            () ->  testRank(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 11, 10, 9, 8), 7, -1)
        );
    }

    private void testRank(List<Integer> answers, List<Integer> inputs, int specialNumber, int expectedRank) {
        LottoResult lottoResult = LottoResult.builder()
                .answers(new LottoNumbers(answers.stream().map(LottoNumber::new).collect(Collectors.toList())))
                .inputs(new LottoNumbers(inputs.stream().map(LottoNumber::new).collect(Collectors.toList())))
                .specialNumber(new LottoNumber(specialNumber))
                .build();

        lottoResult.getDetail(rankFactory);

        assertEquals(lottoResult.getDetail(rankFactory).getRank().rank(), expectedRank);
    }
}
