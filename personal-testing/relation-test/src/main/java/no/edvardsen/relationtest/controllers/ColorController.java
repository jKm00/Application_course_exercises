package no.edvardsen.relationtest.controllers;

import no.edvardsen.relationtest.entities.Color;
import no.edvardsen.relationtest.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/colors")
public class ColorController {
    @Autowired
    private ColorRepository colorRepository;

    @GetMapping
    public List<Color> getColors() {
        return StreamSupport.stream(this.colorRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
