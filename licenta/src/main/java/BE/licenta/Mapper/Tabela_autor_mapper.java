package BE.licenta.Mapper;

import BE.licenta.Dto.Tabela_autor_dto;
import BE.licenta.Entity.Tabela_autor_entity;
import BE.licenta.Entity.Tabela_produs_entity;
import BE.licenta.Service.Tabela_produs_service;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")

public abstract class Tabela_autor_mapper {

    @Autowired
    private Tabela_produs_service tabela_produs_service;

    public abstract Tabela_autor_dto dto_entity(Tabela_autor_entity tabela_autor_entity);

    public abstract Tabela_autor_entity entity_dto(Tabela_autor_dto tabela_autor_dto);

    protected Integer int_produs(Tabela_produs_entity tabela_produs_entity){

        return tabela_produs_service.returneaza_id_produs(tabela_produs_entity);
    }

    protected Tabela_produs_entity produs_int(Integer value){

        return tabela_produs_service.returneaza_produs_dupa_id(value);
    }
}
