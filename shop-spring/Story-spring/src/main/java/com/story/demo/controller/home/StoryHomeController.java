package com.story.demo.controller.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.story.demo.service.home.StoryHomeService;
import com.story.demo.vo.home.StoryHomeVo;

@RestController
@CrossOrigin
public class StoryHomeController {
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	private StoryHomeService homeservice;
	
	@GetMapping("/home")
	@ResponseBody
	public Map<String, Object> home() throws Exception {
		
		logger.info("home start");
		className.getClass();
		Map<String, Object> resultMap = new HashMap<>();
		
		List<StoryHomeVo> homeList = homeservice.homeList();
		
		logger.info("   - homelist : " + homeList);
		
		resultMap.put("homelist", homeList);
		
		return resultMap;
	}
	@PostMapping("/createItem")
	public boolean createItem(@RequestParam Map<String, Object> paramMap)throws Exception {
		
		boolean state = false;
		logger.info("createItem start");
		logger.info("   - param :" + paramMap);
		
		System.out.println("   - param :" + paramMap);
		
		if((paramMap.get("title")!= "") || (paramMap.get("contents") != "")) {
			state = homeservice.createItem(paramMap);
		}
		
		System.out.println("   - state :" + state);
		logger.info("   - state :" + state);
		
		return state;
	}
	
	@GetMapping("/getItem")
	public Map<String, Object> getItem(@RequestParam Map<String, Object> paramMap) throws Exception {
		logger.info("getItem start");
		Map<String, Object> resultMap = new HashMap<>();
		
		System.out.println("   - param :" + paramMap);
		
		StoryHomeVo rewritingItem = homeservice.getItem(paramMap);
		
		System.out.println("   - rewritingItem :" + rewritingItem);
		
		resultMap.put("getItem", rewritingItem);
		
		return resultMap;
	}
	
	@PutMapping("/updateItem")
	public boolean updateItem(@RequestParam Map<String, Object> paramMap) throws Exception {
		logger.info("updateItem start");
		boolean state = false;
		
		System.out.println("   - param :" + paramMap);
		
		state = homeservice.updateItem(paramMap);
		
		System.out.println("   - state :" + state);
		
		return state;
	}
	
	@DeleteMapping("/deletItem")
	public boolean deletItem(@RequestParam Map<String, Object> paramMap) throws Exception {
		boolean state = false;
		
		logger.info("delete start");
		logger.info("   - param :" + paramMap);
		System.out.println("   - param :" + paramMap);
		state = (homeservice.deleteItem(paramMap));
		
		logger.info("   - state :" + state);
		
		return state;
	}
	
	
}
