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
        for (int i= 0; i < rows-1; i++) {
            for (int j= 0; j < columns; j++) {
                if (j==columns-1){
                    board = board + "_";
                }
                else {
                    board = board + "_|";
                }
            }
            board = board + "\n";
        }
        return board;
    }
}
