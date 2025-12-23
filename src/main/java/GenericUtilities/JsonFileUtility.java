package GenericUtilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileUtility {
	
	public String fetchDataFromJsonFile(String key) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parse=new JSONParser();
		Object obj = parse.parse(new FileReader("./src/test/resources/VtigerCMData.json"));
		JSONObject js=(JSONObject)obj;
		String data = js.get(key).toString();
		return data;
	}

}
