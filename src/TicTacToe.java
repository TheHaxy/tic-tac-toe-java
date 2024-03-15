import java.util.Arrays;
import java.util.Objects;

public class TicTacToe {
    String[][] ticTacToe = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};

    public String getTicTacToe() {
        return Arrays.deepToString(ticTacToe[0])
                + "\n" + Arrays.deepToString(ticTacToe[1])
                + "\n" + Arrays.deepToString(ticTacToe[2]);
    }

    public void setSymbol(int row, int col, Symbol symbol) {
        this.ticTacToe[col][row] = symbol.getValue();
    }

    public CellStatus checkCellStatus(int row, int col) {
//        Проверка на значения, выходящие за пределы матрицы
        if (row < 0 || row > 2 || col < 0 || col > 2) return CellStatus.INVALID;

//        Проверка на занятую клетку
        if (!Objects.equals(this.ticTacToe[col][row], Symbol.Null.getValue())) return CellStatus.BUSY;

        return CellStatus.VALID;
    }

    public String getWinner() {
        String winner = null;

        String[][] array = this.ticTacToe;

        for (int i = 0; i < this.ticTacToe.length; i++) {
//            Проверка комбинации по горизонтали (в рамках одного массива)
            if (array[i][0] == array[i][1] && array[i][0] == array[i][2] && array[i][0] != Symbol.Null.getValue()) {
                winner = array[i][0];
            }
//            Проверка комбинации по вертикали (в рамках определенного индекса каждого массива)
            if (array[0][i] == array[1][i] && array[0][i] == array[2][i] && array[0][i] != Symbol.Null.getValue()) {
                winner = array[0][i];
            }
        }

//        Проверка комбинации по диагонали
        if (((array[0][0] == array[1][1] && array[0][0] == array[2][2]) || (array[0][2] == array[1][1] && array[0][2] == array[2][0])) && array[1][1] != Symbol.Null.getValue()) {
            winner = array[1][1];
        }

//        Проверка на ничью
        boolean isDraw = !Arrays.stream(array).anyMatch(row -> Arrays.stream(row).anyMatch(symbol -> symbol == Symbol.Null.getValue()));

        if (isDraw) {
            winner = "никто";
        }

        return winner;
    }
}

