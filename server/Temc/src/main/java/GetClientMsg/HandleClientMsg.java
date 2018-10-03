package GetClientMsg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import com.google.gson.*;

public class HandleClientMsg {
		public static void main(String args[]) {
			String jsonStr = "{ \"rec\": \"rob\", \"msg\": \"you\" }";
			new HandleClientMsg().work(jsonStr,"");
			//System.out.println(temp);
		}
		public String work(String jsonStr, String realPath) {
//			Gson gson = new Gson();
//			System.out.println(jsonStr);
//			DataIn in = gson.fromJson(jsonStr, DataIn.class);
			
			try {
				Gson gson = new Gson();
				System.out.println(jsonStr);
				DataIn in = gson.fromJson(jsonStr, DataIn.class);
			   // String fileName = "World";
				//TODO: add support for windows 
				String msgFolder = "messages/"; 
				File temp = new File(realPath+msgFolder);
				if(!temp.exists()) {
					temp.mkdir();
				}
				String location = realPath + msgFolder+ in.getRec(); // writes to the messages folder to a file name by the recipient.
			    System.out.println("this is " + location);
				BufferedWriter writer = new BufferedWriter(new FileWriter(location, true));
			    writer.append(in.getSender()+",");
			    writer.append(in.getMsg());
			    writer.append("\n");
			    writer.close();
			}
			catch(IOException e) {
				System.out.println( e.getStackTrace().toString());
				System.out.println(realPath);
				return "File IO ERR";
			}
			catch(JsonParseException e ) {
				return "Gson parssing errr";
			}
			
			return "Msg Stored";
		}
}
