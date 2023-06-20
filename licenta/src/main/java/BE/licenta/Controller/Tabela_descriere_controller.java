package BE.licenta.Controller;

import BE.licenta.Dto.Tabela_descriere_dto;
import BE.licenta.Service.Tabela_descriere_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/descriere")
@CrossOrigin

public class Tabela_descriere_controller {

    private final Tabela_descriere_service tabela_descriere_service;

    @Autowired
    public Tabela_descriere_controller(Tabela_descriere_service tabela_descriere_service) {
        this.tabela_descriere_service = tabela_descriere_service;
    }

    @PostMapping("/adaugare")
    public ResponseEntity<Object> adaugare_descriere(@RequestBody Tabela_descriere_dto tabela_descriere_dto){

        return new ResponseEntity<>(tabela_descriere_service.creare_descriere(tabela_descriere_dto), HttpStatus.OK);
    }

    @GetMapping("/afisare")
    public ResponseEntity<List<Tabela_descriere_dto>>afisare_descriere(){

        return new ResponseEntity<>(tabela_descriere_service.afisare_descriere(),HttpStatus.OK);
    }


    @GetMapping("/afisare/{id}")
    public ResponseEntity<Object>afisare_descriere(@PathVariable Integer id){

        return new ResponseEntity<>(tabela_descriere_service.returneaza_descriere_dupa_id(id),HttpStatus.OK);
    }

    @DeleteMapping("/stergere/{id}")
    public ResponseEntity<Integer>stergere_descriere(@PathVariable Integer id){

        tabela_descriere_service.stergere_descriere(id);

        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @PutMapping("/actualizare/{id}")
    public ResponseEntity<Object>actualizare_descriere(@PathVariable Integer id, @RequestBody Tabela_descriere_dto tabela_descriere_dto){

        return new ResponseEntity<>(tabela_descriere_service.actualizare(id,tabela_descriere_dto),HttpStatus.OK);
    }

}
