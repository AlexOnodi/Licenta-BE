package BE.licenta.Mapper;

import BE.licenta.Dto.Tabela_rol_utilizator_dto;
import BE.licenta.Entity.Tabela_rol_utilizator_entity;
import BE.licenta.Entity.Tabela_utilizator_entity;
import BE.licenta.Service.Tabela_utilizator_service;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")

public abstract class Tabela_rol_utilizator_mapper {

    @Autowired
    private Tabela_utilizator_service tabela_utilizator_service;

    public abstract Tabela_rol_utilizator_dto dto_entity(Tabela_rol_utilizator_entity tabela_rol_entity);

    public abstract Tabela_rol_utilizator_entity entity_dto(Tabela_rol_utilizator_dto tabela_rol_dto);


    protected Integer int_utilizator(Tabela_utilizator_entity tabela_utilizator_entity){

        return tabela_utilizator_service.returneaza_id_utilizator(tabela_utilizator_entity);
    }

    protected Tabela_utilizator_entity utilizator_int(Integer value){

        return tabela_utilizator_service.returneaza_utilizator_dupa_id(value);
    }
}
