package BE.licenta.Mapper;

import BE.licenta.Dto.Tabela_favorite_dto;
import BE.licenta.Entity.Tabela_favorite_entity;
import BE.licenta.Entity.Tabela_produs_entity;
import BE.licenta.Service.Tabela_produs_service;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)

public abstract class Tabela_favorite_mapper {

    @Autowired
    private Tabela_produs_service tabela_produs_service;
    public abstract Tabela_favorite_dto dto_entity(Tabela_favorite_entity tabela_favorite_entity);

    public abstract Tabela_favorite_entity entity_dto(Tabela_favorite_dto tabela_favorite_dto);

    protected Integer int_produs(Tabela_produs_entity tabela_produs_entity){

        return tabela_produs_service.returneaza_id_produs(tabela_produs_entity);
    }

    protected Tabela_produs_entity produs_int(Integer value){

        return tabela_produs_service.returneaza_produs_dupa_id(value);
    }

}

