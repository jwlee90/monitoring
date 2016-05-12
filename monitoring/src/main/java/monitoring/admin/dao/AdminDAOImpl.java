package monitoring.admin.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import monitoring.admin.vo.AdminVO;

public class AdminDAOImpl extends SqlMapClientDaoSupport implements AdminDAO{
	@Override
	public AdminVO checkLoginInfo(String id, String password){
		Map<String, Object> map = new HashMap();
		map.put("id", id);
		map.put("password", password);
		
		AdminVO adminVO = null;
		adminVO = (AdminVO)getSqlMapClientTemplate().queryForObject("user.checkLoginInfo", map);
		
		if(adminVO ==null || adminVO.getId().equals("") || adminVO.getId() == null){
			throw new DataRetrievalFailureException("ID 또는 PASSWORD가 정확하지 않습니다.");
		}
		
		return adminVO;
	}
}
