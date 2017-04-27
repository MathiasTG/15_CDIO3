package DTO;

import java.io.Serializable;
import java.util.List;

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
	private int userId;
	/** Bruger navn (user_name) min. 2 max. 20 karakterer */
	private String userName;
	/** Bruger-initialer min. 2 max. 3 karakterer */
	private String ini;
	/** Brugers cpr-nr 10 karakterer */
	private String cpr;
	/** Bruger password min. 7 max. 8 karakterer */
	private String password;
	
	private RoleDTO role;

	public UserDTO(int userId, String userName, String ini, String cpr, String password, RoleDTO roles) {
		this.userId = userId;
		this.userName = userName;
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
	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "User ID:	" + userId + "\n" + "Username:	" + userName + "\n" + "Initials:	" + ini + "\n"
				+ "Role(s):\t" + roleString + "\n" + "CPR:		" + cpr + "\n" + "Password:	" + password + "\n \n";
	}
}
