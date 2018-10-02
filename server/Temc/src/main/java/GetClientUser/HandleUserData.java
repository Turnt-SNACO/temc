package GetClientUser;
import java.util.ArrayList;
import java.util.Hashtable;

import com.google.gson.*;

public class HandleUserData {
	public String work(String jsonStr) {
		Gson gson = new Gson();
		System.out.println(jsonStr);
		//InList dataIn = gson.fromJson(jsonStr, InList.class);
		//System.out.println(dataIn.getInList(0));
		return "message got";
	}
}
