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
}
