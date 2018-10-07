package SendMsg;

import java.io.*;
import com.google.gson.*;
import java.util.Scanner;


public class PrepMsg {
	//debugging
	// public static void main(String[] args){
	// 	try{
	// 		File file = new File(System.getProperty("user.dir")+"/test");
	// 		Scanner fs = new Scanner(file);
	// 		fs.nextLine();
	// 		//rewrite file without the message it took out
	// 		FileWriter fw = new FileWriter(file);
	// 		BufferedWriter bw = new BufferedWriter(fw);
	// 		while(fs.hasNextLine()) {
	// 			String next = fs.nextLine();
	// 			bw.write(next);
	// 			bw.newLine();
	// 		}
	// 		bw.close();
	// 		fs.close();
	// 	}
	// 	catch (IOException e){
	// 		System.out.println("Error opening file");
	// 	}
	// }
	public String prep(String jsonStr,String realPath) {
		Gson gson = new Gson();
		System.out.println(jsonStr);
		Request request = gson.fromJson(jsonStr, Request.class);
		String uname = request.getUname();
		try{
			File file = new File(realPath+"/messages/"+uname);
			Scanner fs = new Scanner(file);
			message = fs.nextLine();
			//rewrite file without the message it took out
			BufferedWriter bw = new BufferedWriter(file);
			FileWriter fw = new FileWriter(file);
			while(fs.hasNextLine()) {
				String next = fs.nextLine();
				bw.write(next);
				bw.newLine();
			}
			return message;
		} catch (Exception e) {
			return null;
		}
	}
}
