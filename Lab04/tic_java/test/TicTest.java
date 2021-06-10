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
        Assert.assertEquals("_\n",ticGame.to_String());
    }

    @Test
    public void TicTestToStringColumn1(){
        Tic ticGame = new Tic(5,1);
        Assert.assertEquals("_\n_\n_\n_\n_\n",ticGame.to_String());
    }

    @Test
    public void TicTestToStringRow1(){
        Tic ticGame = new Tic(1,5);
        Assert.assertEquals("_|_|_|_|_",ticGame.to_String());
    }
}
