import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.json.simple.JSONObject;

public class TestJson {
	
	public static void main(String[] args) {
		EjerciceJsonFormat ejerciceJsonFormat = new EjerciceJsonFormat();
		//ejerciceJsonFormat.writeJson();
		//ejerciceJsonFormat.listTransactions();
		//ejerciceJsonFormat.sumAmount("1");
		//ejerciceJsonFormat.searchUser("3");
	
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("amount", "1500");
		jsonObject.put("description", "test 2");

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());

		jsonObject.put("date", date);
		jsonObject.put("userId", "7");
		UUID idOne = UUID.randomUUID();
		jsonObject.put("transaction_id", idOne.toString());
		
		ejerciceJsonFormat.addUser(jsonObject);	
		
	}

}
