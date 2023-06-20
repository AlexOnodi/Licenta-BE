package BE.licenta.Dto;

import lombok.Data;

@Data
public class Tabela_autor_dto {

    private int id;

    private int tabela_produs_entity_id;

    private String nume;

    private String prenume;

}
