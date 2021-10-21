package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/music")
@PropertySource("classpath:upload_file.properties")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @Value("${file}")
    private String fileUpload;

    @Value("${tomcat_folder}")
    private String tomcatUpload;
    @GetMapping("")
    public ModelAndView list(){
        List <Music> musicList = musicService.findAll();
        ModelAndView modelAndView = new ModelAndView("/information");
        modelAndView.addObject("musicForm",new MusicForm());
        modelAndView.addObject("musicList", musicList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm",new MusicForm());
        return modelAndView;
    }

    @PostMapping ("/save")
    public ModelAndView save( MusicForm musicForm,Model model) {
    MultipartFile multipartFile = musicForm.getMusicfile();
    String filename = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getMusicfile().getBytes(), new File(fileUpload + filename));
            FileCopyUtils.copy(musicForm.getMusicfile().getBytes(), new File(tomcatUpload + filename));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    Music music = new Music(musicForm.getName(),musicForm.getDescription(),filename);
        System.out.println(music);

            musicService.save(music);
            return list();
    }

    @GetMapping ("/edit/{id}")
    public String edit (@PathVariable ("id") int id, Model model) {
        Optional<Music> music = musicService.findById(id);
        System.out.println(music);
        model.addAttribute("music",music);
        return "/edit";
    }

    @PostMapping("/edit")
    public ModelAndView edit (Music music) {
        musicService.save(music);
        return list();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteItem (@PathVariable ("id")int id){
        musicService.remove(id);
        return list();
    }
}
