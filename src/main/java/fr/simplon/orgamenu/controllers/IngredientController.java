package fr.simplon.orgamenu.controllers;

import fr.simplon.orgamenu.models.Ingredient;
import fr.simplon.orgamenu.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    /**
     * Get a List of Ingredient
     * @return List of Ingredient
     */
    @GetMapping("/")
    public ResponseEntity<List<Ingredient>> findAll() {
        try {
            return ResponseEntity.ok(ingredientService.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all Ingredient by usercontext
     * @return list Ingredient
     */
    @GetMapping("/user")
    public ResponseEntity<List<Ingredient>> findAllByUser(){
        try{
            return ResponseEntity.ok(ingredientService.findAllByUser());
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
