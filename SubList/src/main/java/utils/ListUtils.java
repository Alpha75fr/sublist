package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe utilitaire pour des fonctionnalités de type List
 *
 */
public class ListUtils {
	
	/**
	 * Découpe une liste en sous-liste de dimension size
	 * @param list La liste originale
	 * @param size La dimension des sous-listes
	 * @return Une liste contenant les sous-listes de dimension size
	 */
	public static <E> List<List<E>> partition(List<E> list, int size) {
		
	     if (list == null)
	         throw new NullPointerException("'list' must not be null");
	       if (!(size > 0))
	         throw new IllegalArgumentException("'size' must be greater than 0");

		List<List<E>> result = new ArrayList<List<E>>();
		
		int start = 0;
		int initialSize = list.size();
		
		List<E> subList = null;
		
		for (int i = 0; i < (initialSize / size); i++) {

			subList = list.subList(start, start + size);
			
			result.add(subList);
			start += size;
		}
		
		if (initialSize % size != 0) {
			subList = list.subList(start, initialSize);
			
			result.add(subList);
		}
		
		return result;
	} 
}
