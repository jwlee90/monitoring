package monitoring.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import monitoring.admin.service.AdminService;
import monitoring.admin.vo.AdminVO;

public class AdminController extends SimpleFormController {
	private AdminService adminInfo = null;

	public void setUserInfo(AdminService adminInfo) {
		this.adminInfo = adminInfo;
	}

	// POST요청에 대한 처리
	@RequestMapping(value = "/admin/login.do")
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		AdminVO adminVo = (AdminVO) command;

		System.out.println("userid : " + adminVo.getId());
		System.out.println("password : " + adminVo.getPassword());

		try {
			AdminVO loginAdmin = adminInfo.getAdminInfo(adminVo.getId(), adminVo.getPassword());

			ModelAndView mv = new ModelAndView("admin/login");
			Map<String, Object> map = new HashMap();
			map.put("id", loginAdmin.getId());
			map.put("password", loginAdmin.getPassword());
			
			mv.addObject("map", map);
			
			return mv; // loginSuccess.jsp로 이동

		} catch (DataRetrievalFailureException e) { // Dao에서 발생시킨 exception
			System.out.println("exception message : " + e.toString());

			// 다시 로그인 화면으로 이동
			return showForm(request, response, errors); // login.jsp로 이동
		}
	}

}