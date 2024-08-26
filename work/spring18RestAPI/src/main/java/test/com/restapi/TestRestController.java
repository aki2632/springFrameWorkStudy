package test.com.restapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestRestController {
	
	@ResponseBody // RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test.do", method = RequestMethod.GET)
	public String json_test() {
		log.info("/json_test.do");
		
		return "{\"result\":\"OK\"}";
	}
	
	@ResponseBody // RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test2.do", method = RequestMethod.GET)
	public Map<String, String> json_test2() {
		log.info("/json_test2.do");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "Not OK");
		
		return map;
	}
	
	@ResponseBody // RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test3.do", method = RequestMethod.GET)
	public TestVO json_test3() {
		log.info("/json_test3.do");
		
		TestVO vo = new TestVO();
		vo.setName("kim");
		vo.setAge(33);
		
		return vo;
	}
	
	@ResponseBody // RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test4.do", method = RequestMethod.GET)
	public List<TestVO> json_test4() {
		log.info("/json_test4.do");
		
		List<TestVO> list = new ArrayList<TestVO>();
		
		for (int i = 0; i < 3; i++) {
			TestVO vo = new TestVO();
			vo.setName("kim" + i);
			vo.setAge(33 + i);
			list.add(vo);
		}
        
		return list;
	}
	
	@ResponseBody // RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test5.do", method = RequestMethod.GET)
	public Map<String, TestVO> json_test5() {
		log.info("/json_test5.do");
		
		Map<String, TestVO> map = new HashMap<String, TestVO>();
		
		for (int i = 0; i < 3; i++) {
			TestVO vo = new TestVO();
			vo.setName("kim" + i);
			vo.setAge(33 + i);
			map.put("vo", vo);
		}
        
		return map;
	}
	
	@ResponseBody // RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test6.do", method = RequestMethod.GET)
	public Map<String, List<TestVO>> json_test6() {
		log.info("/json_test6.do");
		
		Map<String, List<TestVO>> map = new HashMap<String, List<TestVO>>();
		
		for (int i = 0; i < 3; i++) {
			List<TestVO> list = new ArrayList<TestVO>();
			
			for (int j = 0; j < 3; j++) {
				TestVO vo = new TestVO();
				vo.setName("kim" + i);
				vo.setAge(33 + i);
				list.add(vo);
			}
			map.put("list", list);
		}
        
		return map;
	}
	
	// http://localhost:8088/restapi/api/json_idCheck.do?id=damin
	@ResponseBody // RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_idCheck.do", method = RequestMethod.GET)
	public Map<String, String> json_idCheck(@RequestParam(defaultValue = "admin") String id) {
		log.info("/json_idCheck.do");

		Map<String, String> map = new HashMap<String, String>();
		if(id.equals("admin"))
			map.put("result", "OK");
		else
			map.put("result", "Not OK");
        
		return map;
	}
	
}
