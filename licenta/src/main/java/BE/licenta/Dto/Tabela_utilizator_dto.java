package BE.licenta.Dto;

import BE.licenta.Entity.Tabela_adresa_entity;
import BE.licenta.Entity.Tabela_rol_utilizator_entity;
import lombok.Data;

import java.util.List;

@Data
public class Tabela_utilizator_dto {

    private int id;

    private String nume;

    private String prenume;

    private String email;

    private String telefon;

    private String parola;



    private List<Tabela_adresa_entity> tabela_adresa_entity_list;

    private Tabela_rol_utilizator_entity tabela_rol_utilizator_entity;

}
