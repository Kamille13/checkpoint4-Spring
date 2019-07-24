package com.checkpoint4.checkpoint4.Controller;

import com.checkpoint4.checkpoint4.model.FreakShow;
import com.checkpoint4.checkpoint4.repository.FreakShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FreakShowController {

    @Autowired
    FreakShowRepository freakShowRepository;

    @PostMapping("/freakshows")
    public FreakShow postFreakShow(@RequestBody FreakShow freakShow){
        return freakShowRepository.save(freakShow);
    }

    @GetMapping("/freakshows")
    public List<FreakShow> findAll() {
        return freakShowRepository.findAll();
    }
    @DeleteMapping("/freakshows/{freakshowId}")
    public void deleteFreakShow(@PathVariable Long freakshowId){
        freakShowRepository.deleteById(freakshowId);
    }
}
