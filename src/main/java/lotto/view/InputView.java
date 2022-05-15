package lotto.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String ASK_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println(ASK_PRICE_MESSAGE);
        int price = scanner.nextInt();
        scanner.nextLine();
        return price;
    }

    public static String inputWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }

}
