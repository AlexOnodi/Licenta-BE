package BE.licenta.Mapper;

import BE.licenta.Dto.Tabela_adresa_dto;
import BE.licenta.Entity.Tabela_adresa_entity;
import BE.licenta.Entity.Tabela_utilizator_entity;
import BE.licenta.Service.Tabela_utilizator_service;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")

public abstract class Tabela_adresa_mapper {

    @Autowired
    private Tabela_utilizator_service tabela_utilizator_service;

    public abstract Tabela_adresa_dto dto_entity(Tabela_adresa_entity tabela_adresa_entity);

    public abstract Tabela_adresa_entity entity_dto(Tabela_adresa_dto tabela_adresa_dto);

    protected Integer int_utilizator(Tabela_utilizator_entity tabela_utilizator_entity){

        return tabela_utilizator_service.returneaza_id_utilizator(tabela_utilizator_entity);
    }

    protected Tabela_utilizator_entity utilizator_int(Integer value){

        return tabela_utilizator_service.returneaza_utilizator_dupa_id(value);
    }

}

