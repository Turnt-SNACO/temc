package SendMsg;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import com.google.gson.*;

public class PrepMsg {
	public String prep(String jsonStr,String realPath) {
		Gson gson = new Gson();
		System.out.println(jsonStr);
		Request request = gson.fromJson(jsonStr, Request.class);
		String uname = request.getUname();
		try{
			File file = new File(realPath+"/messages/"+uname);
			BufferedReader br = new BufferedReader(new FileReader(file));
			return br.readLine();
		} catch (Exception e) {
			return null;
		}
	}
}
