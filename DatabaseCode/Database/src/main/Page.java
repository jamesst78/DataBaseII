package main;

import java.util.Hashtable;
import java.util.Vector;

public class Page extends Vector {
	int N;
	String key;
	public Page(Tuple tuple ,int N, String key) {
		this.N = N;
		this.key = key;
		this.add(tuple);
	}
	
	public Tuple insertIntoPage(Tuple t) {
		
		
		
		return null;
	}
	
	
}
