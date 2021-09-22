package practice;

import com.genericUtils.JSONFileUtil;

public class FileReader {

	public static void main(String[] args) throws Throwable {
		JSONFileUtil j=new JSONFileUtil();
		String value = j.readDataFromJSON("username");
		System.out.println(value);

	}

}
