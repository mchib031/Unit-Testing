public class Tic {

    private int rows = 3;
    private int columns = 3;

    public Tic() {

    }

    public Tic(int r, int c) {
        this.rows = r;
        this.columns = c;
    }



    public int size() {
        return rows * columns;
    }
}