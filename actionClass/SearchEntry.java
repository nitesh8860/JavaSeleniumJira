package actionClass;

import utility.Constants;
import utility.ExcelRead;
import utility.SearchMatrix;

public class SearchEntry {

	public static void main(String[] args) throws Exception {
		
			SearchMatrix.search(ExcelRead.read(Constants.path, Constants.sheet), "nitesh");
			
			
	}
	
	
	
}


