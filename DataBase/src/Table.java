import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

public class Table {
	
	ArrayList<VectorModified> indecees2;
	int n;
	String tableName;
	String strClusteringKeyColumn;
	Hashtable<String , String> htblColNameType;

	
	
	
	
	
	public Table(String tableName , String strClusteringKeyColumn , Hashtable<String,String> h) {
		
		this.tableName = tableName;
		this.strClusteringKeyColumn = strClusteringKeyColumn;
		this.htblColNameType = h;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
