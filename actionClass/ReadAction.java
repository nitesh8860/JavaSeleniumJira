package actionClass;

import utility.Constants;
import utility.ExcelRead;


public class ReadAction {

	public static void main(String[] args) throws Exception {
		
		String[][] a = ExcelRead.read(Constants.path, Constants.sheet);
		for(int i=0;i<a.length;i++){
			for(int j = 0 ; j<a[i].length;j++){
				System.out.print(a[i][j]+"                           	");
				
			}
			System.out.println();
		}
		System.out.println(a.length);
	//Log.info("Data read from excel");
	
	

	}

}
