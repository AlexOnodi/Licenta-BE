package BE.licenta.Controller;

import BE.licenta.Dto.Tabela_produs_dto;
import BE.licenta.Service.Tabela_produs_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produs")
@CrossOrigin
public class Tabela_produs_controller {

    private final Tabela_produs_service tabela_produs_service;

    @Autowired
    public Tabela_produs_controller(Tabela_produs_service tabela_produs_service) {
        this.tabela_produs_service = tabela_produs_service;
    }

    @PostMapping("/adaugare")
    public ResponseEntity<Object> adaugare_produs(@RequestBody Tabela_produs_dto tabela_produs_dto) {

        return new ResponseEntity<>(tabela_produs_service.creare_produs(tabela_produs_dto), HttpStatus.OK);
    }

    @GetMapping("/afisare")
    public ResponseEntity<List<Tabela_produs_dto>> afisare_produs() {

        return new ResponseEntity<>(tabela_produs_service.afisare_produs(), HttpStatus.OK);
    }

    @GetMapping("/afisare/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(tabela_produs_service.returneaza_produs_dupa_id(id), HttpStatus.OK);
    }

    @DeleteMapping("/stergere/{id}")
    public ResponseEntity<Integer> stergere_produs(@PathVariable Integer id) {

        tabela_produs_service.stergere_produs(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/actualizare/{id}")
    public ResponseEntity<Object> actualizare_produs(@PathVariable Integer id, @RequestBody Tabela_produs_dto tabela_produs_dto) {

        return new ResponseEntity<>(tabela_produs_service.actualizare(id, tabela_produs_dto), HttpStatus.OK);
    }

    @GetMapping("/cautare/{value}")
    public ResponseEntity<?>cautare(@PathVariable String value){

        return new ResponseEntity<>(tabela_produs_service.cautare(value),HttpStatus.OK);

    }

}
