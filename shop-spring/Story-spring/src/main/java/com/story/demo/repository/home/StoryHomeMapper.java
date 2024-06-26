package com.story.demo.repository.home;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.story.demo.vo.home.StoryHomeVo;

@Mapper
public interface StoryHomeMapper {

	public List<StoryHomeVo> homeList();

	public boolean deleteItem(Map<String, Object> paramMap);

	public boolean createItem(Map<String, Object> paramMap);

	public StoryHomeVo getItem(Map<String, Object> paramMap);

	public boolean updateItem(Map<String, Object> paramMap);
	
}
