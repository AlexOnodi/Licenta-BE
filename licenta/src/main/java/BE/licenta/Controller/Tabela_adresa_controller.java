package BE.licenta.Controller;

import BE.licenta.Dto.Tabela_adresa_dto;
import BE.licenta.Service.Tabela_adresa_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresa")
@CrossOrigin

public class Tabela_adresa_controller {

    private final Tabela_adresa_service tabela_adresa_service;

    @Autowired
    public Tabela_adresa_controller(Tabela_adresa_service tabela_adresa_service) {
        this.tabela_adresa_service = tabela_adresa_service;
    }

    @PostMapping("/adaugare")
    public ResponseEntity<Object> adaugare_adresa(@RequestBody Tabela_adresa_dto tabela_adresa_dto){

        return new ResponseEntity<>(tabela_adresa_service.creare_adresa(tabela_adresa_dto), HttpStatus.OK);
    }

    @GetMapping("/afisare")
    public ResponseEntity<List<Tabela_adresa_dto>>afisare_adresa(){

        return new ResponseEntity<>(tabela_adresa_service.afisare_adresa(),HttpStatus.OK);
    }

    @DeleteMapping("/stergere/{id}")
    public ResponseEntity<Integer>stergere_adresa(@PathVariable Integer id){

        tabela_adresa_service.stergere_adresa(id);

        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @PutMapping("/actualizare/{id}")
    public ResponseEntity<Object>actualizare_adresa(@PathVariable Integer id, @RequestBody Tabela_adresa_dto tabela_adresa_dto){

        return new ResponseEntity<>(tabela_adresa_service.actualizare(id,tabela_adresa_dto),HttpStatus.OK);
    }
}

