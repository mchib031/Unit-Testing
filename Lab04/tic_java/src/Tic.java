public class Tic {

    private int rows = 3;
    private int columns = 3;
    private String board ="";

    public Tic() {
    }

    public Tic(int r, int c) {
        this.rows = r;
        this.columns = c;
    }



    public int size() {
        return rows * columns;
    }

    public String to_String() {
        if (rows == 1 && columns == 1){
            return "_";
        }
        for (int i= 0; i < rows; i++) {
            for (int j= 0; j < columns; j++) {
                if (j==columns-1){
                    board = board + "_";
                }
                else {
                    board = board + "_|";
                }
            }
            if (i==rows-1){
                return board;
            }
            board = board + "\n";
        }
        return board;
    }
}
