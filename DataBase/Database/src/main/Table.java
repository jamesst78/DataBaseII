package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.StringTokenizer;

public class Table {
	ArrayList<String> columnNames = new ArrayList<String>();
	ArrayList<String> columnTypes = new ArrayList<String>();
	ArrayList<String> pages = new ArrayList<String>();
	String tableName;
	String tableKey;
	int N = 20;
	public Table(String tableName, String tableKey, Hashtable ht) {
		this.tableName = tableName;
		this.tableKey = tableKey;
		Enumeration<String> enumeration = ht.keys();
        // iterate using enumeration object
        while(enumeration.hasMoreElements()) {
 
            String key = enumeration.nextElement();
            columnNames.add(key);
			columnTypes.add((String)ht.get(key));
        }
		//DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    //Date dateobj = new Date();
	    columnNames.add("TouchDate");
		columnTypes.add("java.util.Date");
	}
	
	public static Table createTable(String tableName, String key, Hashtable ht) {
		return new Table(tableName, key, ht);
	}
	
	public void insertIntoTable(String tableName, Hashtable<String, Comparable> ht) throws IOException {
		Tuple t = new Tuple(ht, tableKey);
		System.out.println("b4");
		if(pages.size()==0) {
			System.out.println("in");
			Random random = new Random();
			int r = random.nextInt(2147000000);
			String directory = "C:\\Users\\eiade\\Desktop\\" + tableName + r + ".txt";
			Page p = new Page(t, N, tableKey);
			File file = new File(directory);
			file.createNewFile();
			FileOutputStream fileO = new FileOutputStream(directory, true);
            ObjectOutputStream out = new ObjectOutputStream(fileO);
            pages.add(directory);
            out.writeObject(p); 
            
            out.close(); 
            fileO.close(); 
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("id", "java.lang.Integer");
		ht.put("name", "java.lang.String");
		ht.put("gpa", "java.lang.double");
		Table table = createTable("Student", "id", ht);
		Table t = createTable("People", "id", ht);
		Hashtable<String, Comparable> theTuple = new Hashtable<String, Comparable>();
		theTuple.put("id", new Integer(1));
		theTuple.put("name", new String("Mohab"));
		theTuple.put("gpa", new Double(0.99));
		t.insertIntoTable("People", theTuple);
		System.out.println("Hi");
	}
}
