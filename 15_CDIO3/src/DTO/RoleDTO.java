package DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
public class RoleDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9037583273597740464L;
	private int roleId;
	private String roleName;
	public RoleDTO(){}

	public RoleDTO(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@JsonProperty("roleName")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@JsonProperty("roleId")
	public int getRoleId() {
		return roleId;
	}

}
