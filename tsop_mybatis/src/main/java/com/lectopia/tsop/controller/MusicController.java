package com.lectopia.tsop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lectopia.tsop.dto.MusicDTO;
import com.lectopia.tsop.service.MusicService;

@Controller
@RequestMapping("music")
public class MusicController {

	@Autowired
	private MusicService musicService;
	
	@RequestMapping(value="addMusic", method=RequestMethod.GET)
	public String addMusic() throws Exception{
		return "addMusic";
	}
	
	@RequestMapping(value="addMusic", method=RequestMethod.POST)
	public String addMusic(MusicDTO musicDTO, Model model) throws Exception{
		System.out.println(musicDTO);
		musicDTO.setFileId(4);
		musicService.addMusic(musicDTO);
		model.addAttribute("music", musicDTO);
		return "addMusicRes";
	}
}
