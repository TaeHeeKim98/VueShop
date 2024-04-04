package com.story.demo.repository.home;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.story.demo.vo.home.StoryHomeVo;

@Mapper
public interface StoryHomeMapper {

	public List<StoryHomeVo> homeList();
	
}
