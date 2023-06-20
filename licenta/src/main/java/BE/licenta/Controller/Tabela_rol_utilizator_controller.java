package BE.licenta.Controller;

import BE.licenta.Dto.Tabela_rol_utilizator_dto;
import BE.licenta.Service.Tabela_rol_utilizator_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin

public class Tabela_rol_utilizator_controller {

    Tabela_rol_utilizator_service tabela_rol_service;

    @Autowired
    public Tabela_rol_utilizator_controller(Tabela_rol_utilizator_service tabela_rol_service) {
        this.tabela_rol_service = tabela_rol_service;
    }

    @PostMapping("/adaugare")
    public ResponseEntity<Object> adaugare_rol(@RequestBody Tabela_rol_utilizator_dto tabela_rol_dto){

        return new ResponseEntity<>(tabela_rol_service.creare_rol(tabela_rol_dto), HttpStatus.OK);
    }

    @GetMapping("/afisare")
    public ResponseEntity<List<Tabela_rol_utilizator_dto>>afisare_rol(){

        return new ResponseEntity<>(tabela_rol_service.afisare_rol(),HttpStatus.OK);
    }

    @DeleteMapping("/stergere/{id}")
    public ResponseEntity<Integer>stergere_rol(@PathVariable Integer id){

        tabela_rol_service.stergere_rol(id);

        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @PutMapping("/actualizare/{id}")
    public ResponseEntity<Object>actualizare_rol(@PathVariable Integer id, @RequestBody Tabela_rol_utilizator_dto tabela_rol_utilizator_dto){

        return new ResponseEntity<>(tabela_rol_service.actualizare(id,tabela_rol_utilizator_dto),HttpStatus.OK);
    }
}

