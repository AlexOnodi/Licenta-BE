package BE.licenta.Dto;

import lombok.Data;

@Data
public class Tabela_adresa_dto {

    private int id;

    private int tabela_utilizator_entity_id;

    private String tara;

    private String judet;

    private String domiciliu;

    private String string_adresa;
}
