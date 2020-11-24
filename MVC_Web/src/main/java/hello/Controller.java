package hello;

import static spark.Spark.post;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Controller {
	
	private Model model;
	
	public Controller(Model model){
		this.model = model;
	}
	
	public void login(){
		post("/login", (request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
        	
	        JSONObject json = new JSONObject(request.body());
	        String email = json.getString("user"); 
	        String password = json.getString("senha");
	        User user = model.login(email, password);
	        
	        if(user != null) {
	        	return new Gson().toJson(user);
	        } else {
        	    JSONObject jsonObj = new JSONObject();
        	    jsonObj.put("status", 0);
       		
            	return jsonObj;
	        }
		});
	}
}
