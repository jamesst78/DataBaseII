package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class Tuple implements Comparable, Serializable{
	Hashtable<String, Comparable> theTuple;
	String keyS;
	public Tuple(Hashtable<String, Comparable> theTuple, String keyS) {
		this.theTuple = theTuple;
		this.keyS = keyS;
	}
	@Override
	public int compareTo(Object o) {
		Tuple t = (Tuple) o;
		return this.theTuple.get(keyS).compareTo(t.theTuple.get(keyS));
	}	
}
