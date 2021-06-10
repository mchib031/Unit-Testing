import org.junit.Assert;
import org.junit.Test;

public class TicTest {
    @Test
    public void TicTest1(){
        Tic ticGame = new Tic();
        Assert.assertEquals(9,ticGame.size());
    }
}
