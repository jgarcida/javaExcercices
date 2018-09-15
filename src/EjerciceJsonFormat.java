import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EjerciceJsonFormat {

	public void writeJson() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("amount", "50.50");
		jsonObject.put("description", "Joes tacos");

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());

		jsonObject.put("date", date);
		jsonObject.put("userId", "1");
		UUID idOne = UUID.randomUUID();
		jsonObject.put("transaction_id", idOne.toString());

		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("amount", "500");
		jsonObject2.put("description", "Joes tacos2");

		String date2 = simpleDateFormat.format(new Date());

		jsonObject2.put("date", date2);
		jsonObject2.put("userId", "1");
		UUID idTwo = UUID.randomUUID();
		jsonObject2.put("transaction_id", idTwo.toString());
		
		JSONObject jsonObject3 = new JSONObject();
		jsonObject3.put("amount", "1520.00");
		jsonObject3.put("description", "Joes tacos3");

		String date3 = simpleDateFormat.format(new Date());

		jsonObject3.put("date", date3);
		jsonObject3.put("userId", "3");
		UUID idThree = UUID.randomUUID();
		jsonObject3.put("transaction_id", idThree.toString());


		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject2);
		jsonArray.add(jsonObject3);

		JSONObject saveJson = new JSONObject();
		saveJson.put("userTransaction", jsonArray);

		try {
			FileWriter fileWriter = new FileWriter(
					"/home/martin/Documents/Cursos de spring/workspace/FileTest/user.json");
			fileWriter.write(saveJson.toJSONString());
			fileWriter.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Formato json " + saveJson);
	}

	public String listTransactions() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser
					.parse(new FileReader("/home/martin/Documents/Cursos de spring/workspace/FileTest/user.json"));

			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray userList = (JSONArray) jsonObject.get("userTransaction");
			Iterator<JSONObject> iterator = userList.iterator();
			while (iterator.hasNext()) {
				JSONObject userObject = (JSONObject) iterator.next();
				System.out.println(userObject);
				System.out.println("************");
				System.out.println(userObject.get("transaction_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Exito";
	}

	public String searchUser(String userId) {
		
		JSONParser parser = new JSONParser();
		boolean flagExist = Boolean.FALSE;
		try {
			Object obj = parser
					.parse(new FileReader("/home/martin/Documents/Cursos de spring/workspace/FileTest/user.json"));

			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray userList = (JSONArray) jsonObject.get("userTransaction");
			Iterator<JSONObject> iterator = userList.iterator();
			while (iterator.hasNext()) {
				JSONObject userObject = (JSONObject) iterator.next();
				
				if(userObject.get("userId").equals(userId)) {
					flagExist = Boolean.TRUE;
					System.out.println(" User encontrado"+ userObject);
		
				}else {
					flagExist= Boolean.FALSE;
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!flagExist) {
			System.out.println("Transaction not found");
		}
		
		return "";
	}

	public Double sumAmount(String userId) {
		
		JSONParser parser = new JSONParser();
		Double sum = 0d;
		try {
			Object obj = parser
					.parse(new FileReader("/home/martin/Documents/Cursos de spring/workspace/FileTest/user.json"));

			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray userList = (JSONArray) jsonObject.get("userTransaction");
			Iterator<JSONObject> iterator = userList.iterator();
			while (iterator.hasNext()) {
				JSONObject userObject = (JSONObject) iterator.next();
				
				if(userObject.get("userId").equals(userId)) {
					if(!userObject.get("amount").toString().equals("")) {
						Double d = Double.parseDouble(userObject.get("amount").toString());
						System.out.println("Cantidad: " +d);
						sum = sum + d;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("TOTAL: " +sum);
		return sum;
	}

}
