package DTO;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Operatoer Data Access Objekt
 * 
 * @author mn/tb
 * @version 1.2
 */

public class UserDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1454430751000635992L;
	/**
	 * Bruger-identifikationsnummer (user_id) i omraadet 11-99. Vaelges
	 * af brugerne
	 */
	@JsonProperty("userId") private int userId;
	@JsonProperty("username") private String username;
	@JsonProperty("ini") private String ini;
	@JsonProperty("cpr") private String cpr;
	@JsonProperty("password") private String password;
	@JsonProperty("role") private RoleDTO role;
	
	public UserDTO(){}

	public UserDTO(int userId, String username, String ini, String cpr, String password, RoleDTO roles) {
		this.userId = userId;
		this.username = username;
		this.ini = ini;
		this.cpr = cpr;
		this.password = password;
		this.role = roles;
	}

//	public UserDTO(UserDTO user) {
//		this.userId = user.getUserId();
//		this.userName = user.getUserName();
//		this.ini = user.getIni();
//		this.cpr = user.getCpr();
//		this.password = user.getPassword();
//		this.roles = user.getRoles();
//	}
	
	@JsonProperty("userId")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@JsonProperty("ini")
	public String getIni() {
		return ini;
	}

	public void setIni(String ini) {
		this.ini = ini;
	}
	@JsonProperty("cpr")
	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@JsonProperty("role")
	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	public String toString() {
		String roleString="["+role.getRoleName();
//		if(roles.size()>1){
//			for(int i=1;i<roles.size();i++){
//				roleString=roleString+", "+roles.get(i).getRoleName();
//			}
//		}
		roleString=roleString+"]";
		return "User ID:	" + userId + "\n" + "Username:	" + username + "\n" + "Initials:	" + ini + "\n"
			+ "CPR:		" + cpr + "\n"+ "Password:	" + password + "\n"+"Role(s):\t" + roleString + "\n" ;
	}
}
