package monitoring.admin.service;

import monitoring.admin.vo.AdminVO;

public interface AdminService {
	AdminVO getAdminInfo(String id, String password);
}
