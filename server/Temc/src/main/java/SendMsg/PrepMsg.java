package SendMsg;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import com.google.gson.*;

public class PrepMsg {
	
//		public static void main(String args[]) {
//			String jsonStr = "{ \"rec\": \"rob\", \"msg\": \"poop\" }";
//			new PrepMsg().work(jsonStr);
//			//System.out.println(temp);
//		}
	
		public String prep(String jsonStr,String realPath) {
			Gson gson = new Gson();
			System.out.println(jsonStr);
			DataOut message = gson.fromJson(jsonStr, DataOut.class);
			try{
				File file = new File(realPath+"/messages/"+message.getRec());
				BufferedReader br = new BufferedReader(new FileReader(file));
				return br.readLine();
			} catch (Exception e) {
				return null;
			}
		}
}
