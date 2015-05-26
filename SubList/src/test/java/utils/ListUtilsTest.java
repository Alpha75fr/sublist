package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListUtilsTest {

    /**
     * La liste est null 
     */
    @Test
    public void partitionListNullTest() {
        
    	List<Integer> list = null;
    	int size = 1;
    	
    	List<List<Integer>> result = ListUtils.partition(list, size);
    	assertNull(result);
    }
    
    /**
     * La dimension des sous-listes est égale à 0
     */
    @Test
    public void partitionSizeZeroTest() {
    	List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] {1}));
    	int size = 0;
    	
    	List<List<Integer>> result = ListUtils.partition(list, size);
    	assertNull(result);
    }
    
    /**
     * Liste d'Integer de longueur 1
     * La dimension des sous-listes est égale à 1
     */
    @Test
    public void partitionListUnSizeUn() {
    	List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] {1}));
    	int size = 1;
    	
    	List<List<Integer>> result = ListUtils.partition(list, size);
    	assertEquals(1, result.size());
    }
    
    @Test
    /**
     * Liste d'Integer de longueur 4
     * La dimension des sous-listes est égale à 1
     */
    public void partitionListNSizeUn() {
    	List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4}));
    	int size = 1;
    	
    	List<List<Integer>> result = ListUtils.partition(list, size);
    	assertEquals(4, result.size());
    }
    
    @Test
    /**
     * Liste d'Integer de longueur 8
     * La dimension des sous-listes est égale à 4
     */
    public void partitionList8Size4() {
    	List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}));
    	int size = 4;
    	
    	List<List<Integer>> result = ListUtils.partition(list, size);
    	assertEquals(2, result.size());
    }
    
    @Test
    /**
     * Liste d'Integer de longueur 10
     * La dimension des sous-listes est égale à 4
     */
    public void partitionList10Size4() {
    	List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    	int size = 4;
    	
    	List<List<Integer>> result = ListUtils.partition(list, size);
    	assertEquals(3, result.size());
    }
    
    // Test avec des lettres
    @Test
    /**
     * Liste de lettre (character) de longueur 10
     * La dimension des sous-listes est égale à 4
     */
    public void partitionListA10Size4() {
    	List<Character> list = new ArrayList<Character>(Arrays.asList(new Character[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}));
    	int size = 4;
    	
    	List<List<Character>> result = ListUtils.partition(list, size);
    	assertEquals(3, result.size());
    }
}
