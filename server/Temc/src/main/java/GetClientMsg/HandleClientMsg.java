package GetClientMsg;

import java.util.ArrayList;
import java.util.Hashtable;
import com.google.gson.*;

public class HandleClientMsg {
		public static void main(String args[]) {
			String jsonStr = "{ \"rec\": \"rob\", \"msg\": \"poop\" }";
			new HandleClientMsg().work(jsonStr);
			//System.out.println(temp);
		}
		public String work(String jsonStr) {
			Gson gson = new Gson();
			System.out.println(jsonStr);
			DataIn in = gson.fromJson(jsonStr, DataIn.class);
			System.out.println(in.getMsg());
			return "sent sent";
		}
}
