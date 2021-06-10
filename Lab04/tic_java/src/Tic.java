public class Tic {

    private int rows = 3;
    private int columns = 3;
    private String board ="";
    private String positions= "";

    public Tic() {
    }

    public Tic(int r, int c) {
        this.rows = r;
        this.columns = c;
        this.positions="";
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


    public String showPositions() {
        int occ = 0;
        positions = board;
        for (int i=0; i < positions.length(); i++){
            if (positions.charAt(i) == '_'){
                positions = positions.substring(0,i) + String.valueOf(occ) + positions.substring(i+1);
                occ++;
            }
        }
        return positions;
    }
}
