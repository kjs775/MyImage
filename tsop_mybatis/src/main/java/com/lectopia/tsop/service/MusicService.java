package com.lectopia.tsop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lectopia.tsop.dto.MusicDTO;
import com.lectopia.tsop.dto.TagMusicDTO;

@Service
public interface MusicService {

	public void addMusic(MusicDTO music)throws Exception;
	public void updateMusic(MusicDTO music)throws Exception;
	public void deleteMusic(int fileId)throws Exception;
	public MusicDTO getMusic(int fileId)throws Exception;
	public TagMusicDTO getMusicTag(int fileId)throws Exception;
	public List<MusicDTO> getAllMusic()throws Exception;
}
