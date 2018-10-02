package SendMsg;

import java.util.ArrayList;
import java.util.Hashtable;
import com.google.gson.*;

public class PrepMsg {
	
//		public static void main(String args[]) {
//			String jsonStr = "{ \"rec\": \"rob\", \"msg\": \"poop\" }";
//			new PrepMsg().work(jsonStr);
//			//System.out.println(temp);
//		}
	
		public String work(String jsonStr) {
			Gson gson = new Gson();
			System.out.println(jsonStr);
			DataOut in = gson.fromJson(jsonStr, DataOut.class);
			System.out.println(in.getMsg());
			return "sent sent";
		}
}
