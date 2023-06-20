package BE.licenta.Controller;

import BE.licenta.Dto.Tabela_favorite_dto;
import BE.licenta.Service.Tabela_favorite_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
@CrossOrigin

public class Tabela_favorite_controller {

    private final Tabela_favorite_service tabela_favorite_service;

    @Autowired
    public Tabela_favorite_controller(Tabela_favorite_service tabela_favorite_service) {
        this.tabela_favorite_service = tabela_favorite_service;
    }

    @PostMapping("/adaugare")
    public ResponseEntity<Object> adaugare_favorite(@RequestBody Tabela_favorite_dto tabela_favorite_dto) {

        return new ResponseEntity<>(tabela_favorite_service.creare_favorite(tabela_favorite_dto), HttpStatus.OK);
    }

    @GetMapping("/afisare")
    public ResponseEntity<List<Tabela_favorite_dto>> afisare_favorite() {

        return new ResponseEntity<>(tabela_favorite_service.afisare_favorite(), HttpStatus.OK);
    }

    @GetMapping("/afisare/{id}")
    public ResponseEntity<Object> getFavoriteById(@PathVariable Integer id) {
        return new ResponseEntity<>(tabela_favorite_service.returneaza_favorite_dupa_id(id), HttpStatus.OK);
    }

    @DeleteMapping("/stergere/{id}")
    public ResponseEntity<Integer> stergere_favorite(@PathVariable Integer id) {

        tabela_favorite_service.stergere_favorite(id);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}

