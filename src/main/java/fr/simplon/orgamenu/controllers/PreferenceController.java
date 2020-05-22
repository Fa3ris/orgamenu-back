package fr.simplon.orgamenu.controllers;

import fr.simplon.orgamenu.exceptions.EtapeNotFoundExceptions;
import fr.simplon.orgamenu.models.Etapes;
import fr.simplon.orgamenu.models.PreferenceAliment;
import fr.simplon.orgamenu.repository.EtapesRepository;
import fr.simplon.orgamenu.services.PreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/preferences")
@RequiredArgsConstructor
public class PreferenceController {

    @Autowired
    PreferenceService preferenceService;


    @GetMapping("/user")
    public List<PreferenceAliment> findallUser() throws Exception {
        return preferenceService.findAllUser();
    }

    @PutMapping("/")
    public List<PreferenceAliment> create(@RequestBody List<PreferenceAliment> preference) throws Exception {
        return preferenceService.updateByUser(preference);
    }

    @GetMapping("/")
    public List<PreferenceAliment> findall() throws Exception {
        return preferenceService.findAllUser();
    }

}