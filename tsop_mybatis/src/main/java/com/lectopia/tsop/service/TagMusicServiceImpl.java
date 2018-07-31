package com.lectopia.tsop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lectopia.tsop.dto.TagMusicDTO;
import com.lectopia.tsop.mapper.TagMusicMapper;

@Service
public class TagMusicServiceImpl implements TagMusicService{

	@Autowired
	private TagMusicMapper tagMusicMapper;
	
	
	public void addTagMusic(TagMusicDTO tagMusicDTO) throws Exception{
		tagMusicMapper.addTagMusic(tagMusicDTO);
	}
	public void updateTagMusic(TagMusicDTO tagMusicDTO) throws Exception{
		tagMusicMapper.updateTagMusic(tagMusicDTO);
	}
	public void deleteTagMusic(int fileId)throws Exception{
		tagMusicMapper.deleteTagMusic(fileId);
	}
	public List<TagMusicDTO> getTagMusicByKey(String key) throws Exception{
		return tagMusicMapper.getTagMusicByKey(key);
	}
	public List<TagMusicDTO> getTagMusicByFile(int fileId) throws Exception{
		return tagMusicMapper.getTagMusicByFile(fileId);
	}
}
