package BE.licenta.Controller;

import BE.licenta.Dto.Tabela_categorie_dto;
import BE.licenta.Service.Tabela_categorie_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins = "http://localhost:4200/")

public class Tabela_categorie_controller {

    private final Tabela_categorie_service tabela_categorie_service;

    @Autowired
    public Tabela_categorie_controller(Tabela_categorie_service tabela_categorie_service) {
        this.tabela_categorie_service = tabela_categorie_service;
    }

    @PostMapping("/adaugare")
    public ResponseEntity<Object> adaugare_categorie(@RequestBody Tabela_categorie_dto tabela_categorie_dto){

        return new ResponseEntity<>(tabela_categorie_service.creare_categorie(tabela_categorie_dto), HttpStatus.OK);
    }

    @GetMapping("/afisare")
    public ResponseEntity<List<Tabela_categorie_dto>>afisare_categorie(){

        return new ResponseEntity<>(tabela_categorie_service.afisare_categorie(),HttpStatus.OK);
    }

    @GetMapping("/afisare/{id}")
    public ResponseEntity<Object>afisare_categorie_id(@PathVariable Integer id){

        return new ResponseEntity<>(tabela_categorie_service.returneaza_categorie_dupa_id(id),HttpStatus.OK);
    }

    @DeleteMapping("/stergere/{id}")
    public ResponseEntity<Integer>stergere_categorie(@PathVariable Integer id){

        tabela_categorie_service.stergere_categorie(id);

        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @PutMapping("/actualizare/{id}")
    public ResponseEntity<Object>actualizare_categorie(@PathVariable Integer id, @RequestBody Tabela_categorie_dto tabela_categorie_dto){

        return new ResponseEntity<>(tabela_categorie_service.actualizare(id,tabela_categorie_dto),HttpStatus.OK);
    }

    @GetMapping("/cautare/{value}")
    public ResponseEntity<?>cautare(@PathVariable String value){

        return new ResponseEntity<>(tabela_categorie_service.cautare(value),HttpStatus.OK);

    }

}

