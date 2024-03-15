import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private Symbol currentStepSymbol = Symbol.X;

    public void start() {
        TicTacToe ticTacToe = new TicTacToe();
        this.nextStep(ticTacToe);
    }

    private void nextStep(TicTacToe ticTacToe) {
        System.out.println(ticTacToe.getTicTacToe());
        System.out.println("Ход за" + " " + this.currentStepSymbol);
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер по горизонтали:");
        int row = in.nextInt() - 1;
        System.out.print("Введите номер по вертикали:");
        int col = in.nextInt() - 1;

        CellStatus cellStatus = ticTacToe.checkCellStatus(row, col);

        switch (cellStatus) {
            case VALID -> {
                ticTacToe.setSymbol(row, col, currentStepSymbol);

                String winner = ticTacToe.getWinner();

                if (winner != null) {
                    System.out.println(ticTacToe.getTicTacToe());
                    System.out.println("Победитель" + " " + winner + "!");
                    System.exit(0);
                }

                switch (this.currentStepSymbol) {
                    case X -> this.currentStepSymbol = Symbol.O;
                    case O -> this.currentStepSymbol = Symbol.X;

                }
            }
            case INVALID -> System.out.println("Выбрано некорректное значение, введите числа от 1 до 3.");
            case BUSY -> System.out.println("Это поле уже занято! Выберите другое.");
        }

        this.nextStep(ticTacToe);
    }
}
