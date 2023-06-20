package BE.licenta.Mapper;

import BE.licenta.Dto.Tabela_descriere_dto;
import BE.licenta.Entity.Tabela_descriere_entity;
import BE.licenta.Entity.Tabela_produs_entity;
import BE.licenta.Service.Tabela_produs_service;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")

public abstract class Tabela_descriere_mapper{

    @Autowired
    private Tabela_produs_service tabela_produs_service;

    public abstract Tabela_descriere_dto dto_entity(Tabela_descriere_entity tabela_descriere_entity);

    public abstract Tabela_descriere_entity entity_dto(Tabela_descriere_dto tabela_descriere_dto);

    protected Integer int_produs(Tabela_produs_entity tabela_produs_entity){

        return tabela_produs_service.returneaza_id_produs(tabela_produs_entity);
    }

    protected Tabela_produs_entity produs_int(Integer value){

        return tabela_produs_service.returneaza_produs_dupa_id(value);
    }
}
