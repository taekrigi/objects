package com.my.lotto;

import com.my.lotto.rank.RankFactory;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {

    private LottoNumbers answers;
    private LottoNumbers inputs;
    private LottoNumber specialNumber;

    private LottoResult(Builder builder) {
        this.answers = builder.answers;
        this.inputs = builder.inputs;
        this.specialNumber = builder.specialNumber;
    }

    public static Builder builder() {
        return new Builder();
    }

    public LottoDetailResult getDetail(RankFactory rankFactory) {
        Set<Integer> set = new LinkedHashSet<>(convertLottoNumberToInteger(answers.get()));
        List<LottoNumber> sameNumbers = getSameNumbers(set);
        List<LottoNumber> differentNumbers = getDifferentNumbers(set);

        return new LottoDetailResult(
            rankFactory.call(sameNumbers, differentNumbers, specialNumber),
            sameNumbers,
            differentNumbers
        );
    }

    private List<Integer> convertLottoNumberToInteger(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
    }

    private List<LottoNumber> getSameNumbers(Set<Integer> set) {
        return inputs.get().stream().filter(i -> set.contains(i.getNumber())).collect(Collectors.toList());
    }

    private List<LottoNumber> getDifferentNumbers(Set<Integer> set) {
        return inputs.get().stream().filter(i -> !set.contains(i.getNumber())).collect(Collectors.toList());
    }

    public static class Builder {
        private LottoNumbers answers;
        private LottoNumbers inputs;
        private LottoNumber specialNumber;

        private Builder() { }

        public Builder answers(LottoNumbers answers) {
            this.answers = answers;
            return this;
        }

        public Builder inputs(LottoNumbers inputs) {
            this.inputs = inputs;
            return this;
        }

        public Builder specialNumber(LottoNumber specialNumber) {
            this.specialNumber = specialNumber;
            return this;
        }

        public LottoResult build() {
            return new LottoResult(this);
        }
    }
}
