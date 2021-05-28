import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class DateNextDateOkTest
{
	/**
	 * date value for using year month and day variables
	 */
	private Date date;
	/**
	 * expected date value for non exception 15 dates
	 */
	private Date expectedResult;
	/**
	 * Constructor for a parameterized test case.
	 * </p>
	 * <p>
	 * The constructor stores the parameters in instance variables for use by
	 * whichever test method is being run. Because we don't know exactly which
	 * method will be run (in general), the parameters have to be set up for all
	 * possible test methods for the set of values.
	 *
	 * @param year
	 *            Year value
	 * @param month
	 *            Month value
	 * @param day
	 *            Day value
	 * @param expectedYear
	 *            Expected year value for the result
	 * @param expectedMonth
	 *            Expected month value for the result
	 * @param expectedDay
	 *            Expected day value for the result
	 */
	public DateNextDateOkTest(int year, int month, int day, int expectedYear, int expectedMonth, int expectedDay)
	{
		this.date = new Date(year,month,day);
		this.expectedResult = new Date(expectedYear,expectedMonth,expectedDay);
	}
	/**
	 * Set up parameters for the test cases.
	 * <p>
	 * The parameters are for nextDate. Set up 15 possible
	 * combinations of the date, and the expected date result.
	 * Therefore, there should be 6 parameters for each
	 * case:
	 * </p>
	 * <ol>
	 * <li>Year, month and day values</li>
	 * <li>The expected year month and day values for nextDate</li>
	 * </ol>
	 * @return A list of integer arrays containing 15 combinations for each test run.
	 */
	@Parameters
	public static List<Integer[]> data()
	{
		List<Integer[]> params = new LinkedList<Integer[]>( );
		params.add(new Integer[] { 1700,6,20, 1700,6,21 });
		params.add(new Integer[] { 2005,4,15, 2005,4,16 });
		params.add(new Integer[] { 1901,7,20, 1901,7,21 });
		params.add(new Integer[] { 3456,3,27, 3456,3,28 });
		params.add(new Integer[] { 1500,2,17, 1500,2,18 });
		params.add(new Integer[] { 1700,6,29, 1700,6,30 });
		params.add(new Integer[] { 1800,11,29, 1800,11,30 });
		params.add(new Integer[] { 3453,1,29, 3453,1,30 });
		params.add(new Integer[] { 444,2,29, 444,3,1 });
		params.add(new Integer[] { 2005,4,30, 2005,5,1 });
		params.add(new Integer[] { 3453,1,30, 3453,1,31 });
		params.add(new Integer[] { 3456,3,30, 3456,3,31 });
		params.add(new Integer[] { 1901,7,31, 1901,8,1 });
		params.add(new Integer[] { 3453,1,31, 3453,2,1 });
		params.add(new Integer[] { 3456,12,31, 3457,1,1 });
		return params;
	}

	@Test
	public void testNextDate()
	{
		Date actualDate = date.nextDate();
		Assert.assertEquals(expectedResult, actualDate);
	}

}
