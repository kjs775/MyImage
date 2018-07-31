package com.lectopia.tsop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lectopia.tsop.dto.LikeMusicDTO;
import com.lectopia.tsop.mapper.LikeMusicMapper;

@Service
public class LikeMusicServiceImpl implements LikeMusicService{
	
	@Autowired
	private LikeMusicMapper likeMusicMapper;
	
	public void addLikeMusic(LikeMusicDTO likeMusicDTO) throws Exception{
		likeMusicMapper.addLikeMusic(likeMusicDTO);
	}
	
	public void delLikeMusicByMem(String memberId) throws Exception{
		likeMusicMapper.delLikeMusicByMem(memberId);
	}
	public void delLikeMusicByFile(int fileId) throws Exception{
		likeMusicMapper.delLikeMusicByFile(fileId);
	}
	public LikeMusicDTO getLikeMusicByMem(String memberId) throws Exception{
		return likeMusicMapper.getLikeMusicByMem(memberId);
	}
	public LikeMusicDTO getLikeMusicByFile(int fileId) throws Exception{
		return likeMusicMapper.getLikeMusicByFile(fileId);
	}
	public List<LikeMusicDTO> getAllLikeMusic()throws Exception{
		return likeMusicMapper.getAllLikeMusic();
	}

}
