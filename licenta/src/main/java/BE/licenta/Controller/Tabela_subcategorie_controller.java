package BE.licenta.Controller;

import BE.licenta.Dto.Tabela_subcategorie_dto;
import BE.licenta.Service.Tabela_subcategorie_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategorie")
@CrossOrigin

public class Tabela_subcategorie_controller {

    private final Tabela_subcategorie_service tabela_subcategorie_service;

    @Autowired
    public Tabela_subcategorie_controller(Tabela_subcategorie_service tabela_subcategorie_service) {
        this.tabela_subcategorie_service = tabela_subcategorie_service;
    }

    @PostMapping("/adaugare")
    public ResponseEntity<Object> adaugare_subcategorie(@RequestBody Tabela_subcategorie_dto tabela_subcategorie_dto){

        return new ResponseEntity<>(tabela_subcategorie_service.creare_subcategorie(tabela_subcategorie_dto), HttpStatus.OK);
    }

    @GetMapping("/afisare")
    public ResponseEntity<List<Tabela_subcategorie_dto>>afisare_subcategorie(){

        return new ResponseEntity<>(tabela_subcategorie_service.afisare_subcategorie(),HttpStatus.OK);
    }

    @DeleteMapping("/stergere/{id}")
    public ResponseEntity<Integer>stergere_subcategorie(@PathVariable Integer id){

        tabela_subcategorie_service.stergere_subcategorie(id);

        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @PutMapping("/actualizare/{id}")
    public ResponseEntity<Object>actualizare_subcategorie(@PathVariable Integer id, @RequestBody Tabela_subcategorie_dto tabela_subcategorie_dto){

        return new ResponseEntity<>(tabela_subcategorie_service.actualizare(id,tabela_subcategorie_dto),HttpStatus.OK);
    }
}
