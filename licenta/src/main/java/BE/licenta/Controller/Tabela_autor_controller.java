package BE.licenta.Controller;

import BE.licenta.Dto.Tabela_autor_dto;
import BE.licenta.Service.Tabela_autor_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
@CrossOrigin(origins = "*")

public class Tabela_autor_controller {

    private final Tabela_autor_service tabela_autor_service;

    @Autowired
    public Tabela_autor_controller(Tabela_autor_service tabela_autor_service) {
        this.tabela_autor_service = tabela_autor_service;
    }

    @PostMapping("/adaugare")
    public ResponseEntity<Object> adaugare_autor(@RequestBody Tabela_autor_dto tabela_autor_dto){

        return new ResponseEntity<>(tabela_autor_service.creare_autor(tabela_autor_dto), HttpStatus.OK);
    }

    @GetMapping("/afisare/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(tabela_autor_service.returneaza_autor_dupa_id(id), HttpStatus.OK);
    }

    @GetMapping("/afisare")
    public ResponseEntity<List<Tabela_autor_dto>>afisare_autor(){

        return new ResponseEntity<>(tabela_autor_service.afisare_autor(),HttpStatus.OK);
    }

    @DeleteMapping("/stergere/{id}")
    public ResponseEntity<Integer>stergere_autor(@PathVariable Integer id){

        tabela_autor_service.stergere_autor(id);

        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @PutMapping("/actualizare/{id}")
    public ResponseEntity<Object>actualizare_autor(@PathVariable Integer id, @RequestBody Tabela_autor_dto tabela_autor_dto){

        return new ResponseEntity<>(tabela_autor_service.actualizare(id,tabela_autor_dto),HttpStatus.OK);
    }
}

