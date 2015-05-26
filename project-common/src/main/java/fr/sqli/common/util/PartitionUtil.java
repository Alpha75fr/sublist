package fr.sqli.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition utility implement partition list operation. this Class take a
 * generic parameter.
 * 
 * 
 * @author Mohamed Djemaa
 *
 */
public class PartitionUtil<E> {

	/**
	 * Building {@code dataOutpuSubList} from {@code dataInputList} .
	 * {@code dataOutpuSubList} contain a list of sublists in
	 * {@code dataInputList}, where each sublist has at most {@code size}
	 * elements.
	 * For example :
	 * Example 1: partition([1,2,3,4,5], 2) --> [ [1,2], [3,4], [5] ]
     * Example 2: partition([1,2,3,4,5], 3) --> [ [1,2,3], [4,5] ]
     * Example 3: partition([1,2,3,4,5], 1) --> [ [1], [2], [3], [4], [5] ]
	 */

	private void partition(List<E> dataInputList, int size, List<List<E>> dataOutpuSubList) {

		if (dataInputList.size() <= size) {
			dataOutpuSubList.add(dataInputList);
			return;
		}
		List<E> subList = dataInputList.subList(0, dataInputList.size() < size ? dataInputList.size() : size);
		dataOutpuSubList.add(subList);
		// call partition method recursively
		partition(dataInputList.subList(size, dataInputList.size()), size, dataOutpuSubList);

	}

	/**
	 * Return a list of sublist. This method call {@link #partition(List<E>,
	 * int,List<List<E>>)} for building sublist.
	 * 
	 * @throws IllegalArgumentException
	 */
	public List<List<E>> partition(List<E> dataList, int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("size must be > 0");
		}
		if (dataList == null) {
			return null;
		}

		List<List<E>> dataOutputSubList = new ArrayList<List<E>>();
		partition(dataList, size, dataOutputSubList);
		return dataOutputSubList;

	}

}
