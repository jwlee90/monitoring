package monitoring.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import monitoring.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectServiceList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectServiceList", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectAdminList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectAdminList", map);
	}

	public void updateHitCnt(Map<String, Object> map) throws Exception {
		update("sample.updateHitCnt", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		return (Map<String, Object>) selectOne("sample.selectBoardDetail", map);
	}

	public void updateBoard(Map<String, Object> map) throws Exception {
		update("sample.updateBoard", map);
	}

	public void insertBoard(Map<String, Object> map) throws Exception {
		insert("sample.insertBoard", map);
	}

	public void deleteBoard(Map<String, Object> map) throws Exception {
		update("sample.deleteBoard", map);
	}
}