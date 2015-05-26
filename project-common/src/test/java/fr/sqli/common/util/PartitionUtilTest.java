package fr.sqli.common.util;

/**
 * Class validate partitionUtil Class implementation
 *
 * @author Mohamed Djemaa
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class PartitionUtilTest {
	private int size;
	private List<Integer> dataInputList;
	private List<List<Integer>> expecteddataList;

	public PartitionUtilTest(List<Integer> dataInputList, int size, List<List<Integer>> expecteddataList) {
		this.size = size;
		this.dataInputList = dataInputList;
		this.expecteddataList = expecteddataList;
	}

	@Parameters(name = "{index}: partition({0},{1})={2}")
	public static Collection<Object[]> params() {
		// contain a test case input and output
		return Arrays.asList(
				new Object[] { Arrays.asList(1, 2, 3), 2, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3)) },
				new Object[] { Arrays.asList(1, 2, 3, 4, 5), 2,
						Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5)) },
				new Object[] { Arrays.asList(1, 2, 3, 4, 5), 3,
						Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5)) },
				new Object[] {
						Arrays.asList(1, 2, 3, 4, 5),
						1,
						Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList(4),
								Arrays.asList(5)) },
				new Object[] { Arrays.asList(1, 2, 3, 4, 5), 6, Arrays.asList(Arrays.asList(1, 2, 3, 4, 5)) },
				new Object[] { null, 2, null }, new Object[] { Arrays.asList(), 2, Arrays.asList(Arrays.asList()) });
	}

	@Test
	public void testPartitions() {
		PartitionUtil<Integer> partitionUtil = new PartitionUtil<Integer>();
		assertEquals(expecteddataList, partitionUtil.partition(dataInputList, size));
	}

	@Test//(expected = IllegalArgumentException.class)
	public void testpartitionException() throws IllegalArgumentException {
		PartitionUtil<Integer> pu = new PartitionUtil<Integer>();
		pu.partition(dataInputList, 0);

	}
}
