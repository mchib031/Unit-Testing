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
        for (int i= 0; i < rows; i++) {
            board = board + "_\n";
        }
        return board;
    }
}
