package monitoring.admin.dao;

import monitoring.admin.vo.AdminVO;

public interface AdminDAO {
	AdminVO checkLoginInfo(String id, String password);
}
