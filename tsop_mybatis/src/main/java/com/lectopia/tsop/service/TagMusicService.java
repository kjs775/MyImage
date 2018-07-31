package com.lectopia.tsop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lectopia.tsop.dto.TagMusicDTO;

@Service
public interface TagMusicService {
	
	public void addTagMusic(TagMusicDTO tagMusicDTO) throws Exception;
	public void updateTagMusic(TagMusicDTO tagMusicDTO) throws Exception;
	public void deleteTagMusic(int fileId)throws Exception;
	public List<TagMusicDTO> getTagMusicByKey(String key) throws Exception;
	public List<TagMusicDTO> getTagMusicByFile(int fileId) throws Exception;
}
