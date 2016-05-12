package monitoring.admin.service;

import monitoring.admin.dao.AdminDAO;
import monitoring.admin.vo.AdminVO;

public class AdminServiceImpl implements AdminService{
	private AdminDAO adminDAO = null;
	
	public void setAdminDAO(AdminDAO userDAO){
		this.adminDAO = adminDAO;
	}
	
	@Override
	public AdminVO getAdminInfo(String id, String password){
		return adminDAO.checkLoginInfo(id, password);
	}
}
