package com.lectopia.tsop.mapper;

import java.util.List;

import com.lectopia.tsop.dto.LikeMusicDTO;

public interface LikeMusicMapper {
	
	public void addLikeMusic(LikeMusicDTO likeMusicDTO)throws Exception;
	public void delLikeMusicByMem(String memberId)throws Exception;
	public void delLikeMusicByFile(int fileId)throws Exception;
	public LikeMusicDTO getLikeMusicByMem(String memberId)throws Exception;
	public LikeMusicDTO getLikeMusicByFile(int fileId)throws Exception;
	public List<LikeMusicDTO> getAllLikeMusic()throws Exception;
}
