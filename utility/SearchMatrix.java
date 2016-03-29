package utility;

public class SearchMatrix {

	public static int a;
	public static int b;
	public static String tar;

	public static String search(String[][] data, String target) {
		
		//Find target value from a 2 dimensional array. eg: fetch data from excel 
		
		int i = 0;
		int j = 0;
		tar=null;

		for (i = 0; i < data.length; i++) {

			for (j = 0; j < data[0].length; j++) {
				if (data[i][j].equalsIgnoreCase(target)) {
					System.out.println(data[i][j] + " is matching at (" + i + "," + j + ")");
					a=i;
					b=j;
					tar=target;
					break;
				}
					

				}
			}
		if(tar==null){
			System.out.println("Data not found");
		}

		return target;

	}
}