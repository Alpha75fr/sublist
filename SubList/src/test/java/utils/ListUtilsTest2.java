package utils;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ListUtilsTest2 {

	private List<Object> listIntput;
	private int size;
	private List<List<Object>> listExpected;
	
	// Parameters pass via this constructor
	public ListUtilsTest2(List<Object> listIntput, int size, List<List<Object>> listExpected) {
		this.listIntput = listIntput;
		this.size = size;
		this.listExpected = listExpected;
	}
	
	@Parameters(name = "{index}: partition({0},{1})={2}")
	public static Collection<Object[]> params() {
		// contain a test case input and output
		return Arrays.asList(
				new Object[] { Arrays.asList(1, 2, 3), 2, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3)) },
				new Object[] { Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 4,
						Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8), Arrays.asList(9, 10)) },
				new Object[] {Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"),  4, 
						Arrays.asList(Arrays.asList("a", "b", "c", "d"), Arrays.asList("e", "f", "g", "h"), Arrays.asList("i", "j")) }
						
//				new Object[] { null, 1, null },
//				new Object[] {  Arrays.asList(1, 2, 3), 0,  null }
			);
	}
	
	@Test
	public void partitionTest() {
		assertEquals(listExpected, ListUtils.partition(listIntput, size));
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void nullPointerExceptionTest() {
		exception.expect(NullPointerException.class);
	    exception.expectMessage("'list' must not be null");
		ListUtils.partition(null, 1);
	}
	
	@Test//(expected = IllegalArgumentException.class)
	public void illegalArgumentExceptionTest() {
		exception.expect(NullPointerException.class);
	    exception.expectMessage("'list' must not be null");
		ListUtils.partition(Arrays.asList(1, 2, 3), 0);
	}
}
