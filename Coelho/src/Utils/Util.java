package Utils;

public class Util {
	
	public static int stringToInt(String str) {
		int retorno = -1;
		
		if (str != null && str != "") {
			retorno = Integer.parseInt(str);
		}
		
		return retorno;
	}
	
}
