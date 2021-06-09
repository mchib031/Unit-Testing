
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public  class FizzBuzzTest {
		public  String fizzBuzz(int num){
		if (num%3==0 && num%5==0){
			return "FizzBuzz";
		}else if (num % 3 == 0){
			return "Fizz";
		} else if (num % 5 == 0){
			return "Buzz";
		}
		return String.valueOf(num);
	}
	@Test
	public void test_1passed(){
	assertEquals("FizzBuzz", fizzBuzz(0));
	}
  	@Test
	public void test_2passed(){
	assertEquals("1", fizzBuzz(1));
	}

	@Test
	public void test_3failed(){
		String actual= "1";
		String expected= fizzBuzz(2);
	assertEquals(actual,expected );
	}
}