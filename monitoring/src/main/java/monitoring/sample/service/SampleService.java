package monitoring.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {

	List<Map<String, Object>> serviceList(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> adminList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;

	void updateBoard(Map<String, Object> map) throws Exception;

	void insertBoard(Map<String, Object> map) throws Exception;

	void deleteBoard(Map<String, Object> map) throws Exception;
}