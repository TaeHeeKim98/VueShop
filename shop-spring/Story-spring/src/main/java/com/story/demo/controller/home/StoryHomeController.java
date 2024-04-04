package com.story.demo.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.story.demo.service.home.StoryHomeService;
import com.story.demo.vo.home.StoryHomeVo;

@Controller
public class StoryHomeController {
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	private StoryHomeService homeservice;
	
	@GetMapping("/")
	@ResponseBody
	public Map<String, Object> home() throws Exception {
		logger.info("home start");
		Map<String, Object> resultMap = new HashMap<>();
		
		List<StoryHomeVo> homeList = homeservice.homeList();
		
		logger.info("   - homelist : " + homeList);
		
		resultMap.put("homelist", homeList);
		
		return resultMap;
	}
}
