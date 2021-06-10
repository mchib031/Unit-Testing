import org.junit.Assert;
import org.junit.Test;

public class TicTest {
    @Test
    public void TicTestSizeDefault(){
        Tic ticGame = new Tic();
        Assert.assertEquals(9,ticGame.size());
    }

    @Test
    public void TicTestSizeFinder(){
        Tic ticGame = new Tic(4,4);
        Assert.assertEquals(16,ticGame.size());
    }

    @Test
    public void TicTestToString1(){
        Tic ticGame = new Tic(1,1);
        Assert.assertEquals("_",ticGame.to_String());
    }

    @Test
    public void TicTestToStringColumn1(){
        Tic ticGame = new Tic(5,1);
        Assert.assertEquals("_\n_\n_\n_\n_",ticGame.to_String());
    }

    @Test
    public void TicTestToStringRow1(){
        Tic ticGame = new Tic(1,5);
        Assert.assertEquals("_|_|_|_|_",ticGame.to_String());
    }

    @Test
    public void TicTestToStringColumnsRowAny(){
        Tic ticGame = new Tic(6,5);
        String expected= "_|_|_|_|_\n_|_|_|_|_\n_|_|_|_|_\n_|_|_|_|_\n_|_|_|_|_\n_|_|_|_|_";
        Assert.assertEquals(expected,ticGame.to_String());
    }

    @Test
    public void TicTestToStringDefault(){
        Tic ticGame = new Tic();
        Assert.assertEquals("_|_|_\n_|_|_\n_|_|_",ticGame.to_String());
    }

    @Test
    public void TicTestShowPositionsDefault(){
        Tic ticGame = new Tic();
        Assert.assertEquals("0|1|2\n3|4|5\n6|7|8",ticGame.showPositions());
    }

    @Test
    public void TicTestShowPositions1x1(){
        Tic ticGame = new Tic(1,1);
        Assert.assertEquals("0",ticGame.showPositions());
    }
}
