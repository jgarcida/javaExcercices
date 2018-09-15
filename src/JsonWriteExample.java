import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriteExample {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();

		// JSON object and values
		jsonObject.put("name", "Atul Rai");
		jsonObject.put("occupation", "Blogger");
		jsonObject.put("location", "India");
		jsonObject.put("website", "www.websparrow.org");

		// JSON array and values
		JSONArray jsonArray = new JSONArray();
		jsonArray.add("Java");
		jsonArray.add("Struts");
		jsonArray.add("jQuery");
		jsonArray.add("JavaScript");
		jsonArray.add("Database");

		jsonObject.put("technology", jsonArray);

		// writing the JSONObject into a file(info.json)
		try {
			FileWriter fileWriter = new FileWriter("/home/martin/Documents/Cursos de spring/workspace/FileTest/info.json");
			fileWriter.write(jsonObject.toJSONString());
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
	}

}
