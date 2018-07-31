package com.lectopia.tsop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lectopia.tsop.dto.MusicDTO;
import com.lectopia.tsop.dto.TagMusicDTO;
import com.lectopia.tsop.mapper.MusicMapper;

@Service
public class MusicServiceImpl implements MusicService{

	@Autowired
	private MusicMapper mapper;
	
	public void addMusic(MusicDTO music)throws Exception{
		mapper.addMusic(music);
	}
	public void updateMusic(MusicDTO music)throws Exception{
		mapper.updateMusic(music);
	}
	public void deleteMusic(int fileId)throws Exception{
		mapper.deleteMusic(fileId);
	}
	public MusicDTO getMusic(int fileId)throws Exception{
		return mapper.getMusic(fileId);	
	}
	public TagMusicDTO getMusicTag(int fileId)throws Exception{
		return mapper.getMusicTag(fileId);
	}
	public List<MusicDTO> getAllMusic()throws Exception{
		return mapper.getAllMusic();		
	}
}
