package BE.licenta.Controller;

import BE.licenta.Dto.Tabela_utilizator_dto;
import BE.licenta.Entity.LogareRas;
import BE.licenta.Entity.LogareReq;
import BE.licenta.Entity.RaspunsLogare;
import BE.licenta.Entity.RequestLogare;
import BE.licenta.Service.Tabela_utilizator_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilizator")
@CrossOrigin

public class Tabela_utilizator_controller {

    private final Tabela_utilizator_service tabela_utilizator_service;

    private final AuthenticationManager authenticationManager;


    @Autowired
    public Tabela_utilizator_controller(Tabela_utilizator_service tabela_utilizator_service,AuthenticationManager authenticationManager) {
        this.tabela_utilizator_service = tabela_utilizator_service;
        this.authenticationManager=authenticationManager;
    }

    @PostMapping("/adaugare")
    public ResponseEntity<Object> adaugare_utilizator(@RequestBody Tabela_utilizator_dto tabela_utilizator_dto){

        return new ResponseEntity<>(tabela_utilizator_service.creare_utilizator(tabela_utilizator_dto), HttpStatus.OK);
    }

    @GetMapping("/afisare")
    public ResponseEntity<List<Tabela_utilizator_dto>>afisare_utilizator(){

        return new ResponseEntity<>(tabela_utilizator_service.afisare_utilizator(),HttpStatus.OK);
    }

    @DeleteMapping("/stergere/{id}")
    public ResponseEntity<Integer>stergere_utilizator(@PathVariable Integer id){

        tabela_utilizator_service.stergere_utilizator(id);

        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @PutMapping("/actualizare/{id}")
    public ResponseEntity<Object>actualizare_utilizator(@PathVariable Integer id, @RequestBody Tabela_utilizator_dto tabela_utilizator_dto){

        return new ResponseEntity<>(tabela_utilizator_service.actualizare(id,tabela_utilizator_dto),HttpStatus.OK);
    }

    @PostMapping("/autentificare")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LogareReq authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        return ResponseEntity.ok(new LogareRas(tabela_utilizator_service.authenticate(authenticationRequest)));
    }

}

