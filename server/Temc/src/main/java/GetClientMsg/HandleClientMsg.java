package GetClientMsg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import com.google.gson.*;

public class HandleClientMsg {
		public static void main(String args[]) {
			String jsonStr = "{ \"rec\": \"rob\", \"msg\": \"you\" }";
			new HandleClientMsg().work(jsonStr);
			//System.out.println(temp);
		}
		public String work(String jsonStr) {
			Gson gson = new Gson();
			System.out.println(jsonStr);
			DataIn in = gson.fromJson(jsonStr, DataIn.class);
			System.out.println(in.getMsg());
			
			try {
			   // String fileName = "World";
				String msgFolder = "messages/"; 
				String location = msgFolder + in.getRec(); // writes to the messages folder to a file name by the recipient.
			    BufferedWriter writer = new BufferedWriter(new FileWriter(location, true));
			    
			    writer.append(in.getMsg());
			    writer.append("\n");
			    writer.close();
			}
			catch(Exception IOException ) {
				return "ERR";
			}
			
			return "Msg Stored";
		}
}
