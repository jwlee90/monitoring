package monitoring.sample.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import monitoring.common.common.CommandMap;
import monitoring.sample.service.SampleService;

@Controller
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "sampleService")
	private SampleService sampleService;
	
	// 서비스 리스트 출력
	@RequestMapping(value = "/sample/showServiceList.do")
	public ModelAndView showServiceList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/serviceList");

		List<Map<String, Object>> list = sampleService.serviceList(commandMap);
		mv.addObject("serviceList", list);

		return mv;
	}
	// API 리스트 출력
	@RequestMapping(value = "/sample/showApiList.do")
	public ModelAndView showApiList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/apiList");

		List<Map<String, Object>> list = sampleService.apiList(commandMap);
		mv.addObject("apiList", list);

		return mv;
	}
	//관리자 리스트 출력
	@RequestMapping(value = "/sample/showAdminList.do")
	public ModelAndView showAdminList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/adminList");

		List<Map<String, Object>> list = sampleService.adminList(commandMap);
		mv.addObject("adminList", list);

		return mv;
	}
	
	//관리자 리스트 출력 (API설정 페이지)
	@RequestMapping(value = "/sample/showManager.do")
	public ModelAndView showManager(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/managerSetting");

		List<Map<String, Object>> list = sampleService.managerSetting(commandMap);
		List<Map<String, Object>> list2 = sampleService.adminList(commandMap);
		List<Map<String, Object>> list3 = sampleService.serviceList(commandMap);
		
		mv.addObject("managerSetting", list);
		mv.addObject("adminList", list2);
		mv.addObject("serviceList", list3);

		return mv;
	}

	@RequestMapping(value = "/sample/openBoardDetail.do")
	public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/boardDetail");

		Map<String, Object> map = sampleService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map);

		return mv;
	}

	@RequestMapping(value = "/sample/openBoardUpdate.do")
	public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/boardUpdate");

		Map<String, Object> map = sampleService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map);

		return mv;
	}

	@RequestMapping(value = "/sample/openBoardWrite.do")
	public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/boardWrite");

		return mv;
	}

	@RequestMapping(value = "/sample/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");

		sampleService.insertBoard(commandMap.getMap());

		return mv;
	}

	@RequestMapping(value = "/sample/updateBoard.do")
	public ModelAndView updateBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardDetail.do");

		sampleService.updateBoard(commandMap.getMap());

		mv.addObject("IDX", commandMap.get("IDX"));
		return mv;
	}

	@RequestMapping(value = "/sample/deleteBoard.do")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");

		sampleService.deleteBoard(commandMap.getMap());

		return mv;
	}

	@RequestMapping(value = "/sample/testMapArgumentResolver.do")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");

		if (commandMap.isEmpty() == false) {
			Iterator<Entry<String, Object>> iterator = commandMap.getMap().entrySet().iterator();
			Entry<String, Object> entry = null;
			while (iterator.hasNext()) {
				entry = iterator.next();
				log.debug("key : " + entry.getKey() + ", value : " + entry.getValue());
			}
		}
		return mv;
	}

}
