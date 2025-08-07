import java.util.*;

public class TicTacToeBoard {
    char[][] board = new char[3][3];

    public TicTacToeBoard() {
        for (char[] row : board) Arrays.fill(row, '-');
    }

    public boolean place(int r, int c, char mark) {
        if (r < 0 || c < 0 || r >= 3 || c >= 3 || board[r][c] != '-') return false;
        board[r][c] = mark;
        return true;
    }

    public boolean checkWin(char mark) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) return true;
            if (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark) return true;
        }
        return (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
               (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark);
    }

    public boolean isFull() {
        for (char[] row : board)
            for (char c : row)
                if (c == '-') return false;
        return true;
    }
}