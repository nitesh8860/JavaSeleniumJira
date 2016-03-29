package actionClass;

import utility.ExcelUpdate;

public class UpdateAction {

	public static void main(String[] args) throws Exception {
		ExcelUpdate.update(1, 0, "tulsi");
		System.out.println(ExcelUpdate.getData(1, 0));

	}

}
