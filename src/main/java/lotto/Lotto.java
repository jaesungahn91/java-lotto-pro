package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int NUMBER_SIZE = 6;

    private final List<Number> numbers = new ArrayList<>();

    public Lotto(int[] numbers) {
        checkSize(numbers);
        Arrays.stream(numbers).forEach(number -> this.addNumber(new Number(number)));
    }

    public Lotto(String[] numbers) {
        this(Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray());
    }

    public Lotto(List<Number> numbers) {
        this.numbers.addAll(numbers);
    }

    public int getCount(Lotto winningLotto) {
        return (int) winningLotto.getNumber().stream()
                .filter(numbers::contains)
                .count();
    }

    private void checkSize(int[] numbers) {
        if (numbers.length != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또의 번호는 6개만 가능합니다.");
        }
    }

    private void addNumber(Number number) {
        if (isContains(number)) {
            throw new IllegalArgumentException("중복된 숫자는 사용할 수 없습니다.");
        }
        this.numbers.add(number);
    }

    public boolean isContains(Number number) {
        return numbers.contains(number);
    }

    public Rank getRank(WinningLotto winningLotto) {
        int count = (int) this.numbers.stream()
                .filter(number -> winningLotto.getLotto().isContains(number))
                .count();
        boolean isBonusMatch = numbers.contains(winningLotto.getBonus());
        return Rank.fromCountAndIsBonusMatch(count, isBonusMatch);
    }

    public List<Integer> getNumberValues() {
        return numbers.stream().map(Number::getValue).sorted().collect(Collectors.toList());
    }

    public List<Number> getNumber() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return String.valueOf(getNumberValues());
    }

}
