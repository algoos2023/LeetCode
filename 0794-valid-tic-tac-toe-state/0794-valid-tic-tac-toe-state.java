class Solution {
    public boolean validTicTacToe(String[] board) {

        int numO = (int) String.join("", board).chars().filter(ch -> ch == 'O').count();
        int numX = (int) String.join("", board).chars().filter(ch -> ch == 'X').count();

        // X가 먼저이므로 X의 수가 작으면 false
        if(numX<numO) return false;
        // X가 먼저이므로 X의 수는 O의 수와 같거나 +1
        if(numX!=numO && numX!=numO+1) return false;
        // X와 O가 모두 WIN이면 false
        if(findTTT("X", board) && findTTT("O", board)) return false;
        // X가 WIN인데 O와 숫자가 같으면 false
        if(findTTT("X", board) && numX==numO) return false;
        // O가 WIN인데 X가 O+1이면 false
        if(findTTT("O", board) && numX==numO+1) return false;

        return true;
    }

    public boolean findTTT(String character, String[] board) {
        String diagonal1 = "";
        String diagonal2 = "";
        String winStr = character.repeat(3);

        // 가로
        for (String str : board) {
            if(str.equals(winStr)) return true;
            diagonal1+=str.charAt(diagonal1.length());
            diagonal2+=str.charAt(board.length-1-diagonal2.length());
        }

        // 세로
        for (int i = 0; i < board.length; i++) {
            String vert = "";
            for (int j = 0; j < board.length; j++) {
                vert += board[j].charAt(i);
            }
            if(vert.equals(winStr)) return true;
        }

        // 대각선
        if(diagonal1.equals(winStr)) return true;
        if(diagonal2.equals(winStr)) return true;

        return false;
    }
}