package presentationLayer;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.UserDTO;

@Path("json")
public class UserService {
	ObjectMapper mapper = new ObjectMapper();
	 
	@Path("createUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String createUser(String json){
		
		try {
			UserDTO res = mapper.readValue(json, UserDTO.class);
			System.out.println(res.toString());
			
			return "User received.";
//			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
