package com.lectopia.tsop.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lectopia.tsop.dto.LikeMusicDTO;
import com.lectopia.tsop.dto.MusicDTO;
import com.lectopia.tsop.dto.TagMusicDTO;
import com.lectopia.tsop.service.LikeMusicService;
import com.lectopia.tsop.service.MusicService;
import com.lectopia.tsop.service.TagMusicService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MusicTest {

	@Autowired
	private MusicService musicService;
	
	@Autowired
	private LikeMusicService likeMusicService;
	
	@Autowired
	private TagMusicService tagMusicService;
	
	@Test
	public void addMusic() throws Exception {
		MusicDTO music = new MusicDTO(1, "1번 노래 제목", "1번 노래 소개글", 1, true, true);
		musicService.addMusic(music);
		assertTrue(true);
	}
	
	@Test
	public void getMusic() throws Exception {
		MusicDTO music = musicService.getMusic(1);
		System.out.println(music);
	}
	
	@Test
	public void updateMusic() throws Exception {
		MusicDTO music = musicService.getMusic(1);
		music.setTitle("1번 노래 제목(수정)");
		musicService.updateMusic(music);
		System.out.println(music);
	}
	
	@Test
	public void deleteMusic() throws Exception{
		musicService.deleteMusic(1);
	}
	
	@Test
	public void addLikeMusic()throws Exception {
		LikeMusicDTO likeMusicDTO = new LikeMusicDTO("kjs775", 1);
		likeMusicService.addLikeMusic(likeMusicDTO);
	}
	
	@Test
	public void deleteLikeMusic() throws Exception{
		likeMusicService.delLikeMusicByFile(1);
	}
	
	@Test
	public void addTagMusic() throws Exception{
		TagMusicDTO tagMusicDTO = new TagMusicDTO("1번 태그", 1);
		tagMusicService.addTagMusic(tagMusicDTO);
	}
	
	@Test
	public void deleteTagMusic() throws Exception{
		tagMusicService.deleteTagMusic(1);
	}
}
