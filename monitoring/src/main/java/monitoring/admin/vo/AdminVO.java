package monitoring.admin.vo;

import java.io.Serializable;

public class AdminVO implements Serializable {
	private String id;
	private String password;
	private String name;
	private String phoneNumber;
	private String email;
	private String deptCode;
	private String admNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getAdmNum() {
		return admNum;
	}

	public void setAdmNum(String admNum) {
		this.admNum = admNum;
	}
}
