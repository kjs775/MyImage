package com.lectopia.tsop.mapper;

import java.util.List;

import com.lectopia.tsop.dto.TagMusicDTO;

public interface TagMusicMapper {

	public void addTagMusic(TagMusicDTO tagMusicDTO) throws Exception;
	public void updateTagMusic(TagMusicDTO tagMusicDTO) throws Exception;
	public void deleteTagMusic(int fileId)throws Exception;
	public List<TagMusicDTO> getTagMusicByKey(String key) throws Exception;
	public List<TagMusicDTO> getTagMusicByFile(int fileId) throws Exception;
}
