package com.lectopia.tsop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lectopia.tsop.dto.LikeMusicDTO;

@Service
public interface LikeMusicService {
	public void addLikeMusic(LikeMusicDTO likeMusicDTO) throws Exception;
	public void delLikeMusicByMem(String memberId)throws Exception;
	public void delLikeMusicByFile(int fileId)throws Exception;
	public LikeMusicDTO getLikeMusicByMem(String memberId)throws Exception;
	public LikeMusicDTO getLikeMusicByFile(int fileId)throws Exception;
	public List<LikeMusicDTO> getAllLikeMusic()throws Exception;
}
