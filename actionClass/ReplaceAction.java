package actionClass;

import utility.Constants;
import utility.ExcelRead;
import utility.ExcelUpdate;
import utility.SearchMatrix;

public class ReplaceAction {

	public static void main(String[] args) throws Exception {
		if(SearchMatrix.search(ExcelRead.read(Constants.path, Constants.sheet), "tulsi")==SearchMatrix.tar){
		ExcelUpdate.update(SearchMatrix.a, SearchMatrix.b, "nitesh");
		//Log.info("a value is replaced with other value in excel");
		}

	

	}

}
