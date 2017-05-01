package presentationLayer;

import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import DTO.UserDTO;

@Path("json")
public class UserService {
	ObjectMapper mapper = new ObjectMapper();
	private static ArrayList<UserDTO> allUsers = new ArrayList<UserDTO>() {
		private static final long serialVersionUID = -6607099362887584352L;
	};
	 
	@Path("createUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String createUser(String json){
		
		try {
			UserDTO res = mapper.readValue(json, UserDTO.class);
			System.out.println(res.toString());
			allUsers.add(res);
			return "User received.";
//			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Path("loadUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<UserDTO> getUserList(){
		return allUsers;
	}
	
	@Path("deleteUser")
	@DELETE
	public boolean delete(UserDTO request) {
		for (int i = 0; i<allUsers.size();i++) {
			if (allUsers.get(i).getUserId() == request.getUserId()) {
				allUsers.remove(i);
				return true;
			}
		}
		return false;
	}
}
