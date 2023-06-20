package BE.licenta.Mapper;

import BE.licenta.Dto.Tabela_produs_dto;
import BE.licenta.Entity.Tabela_produs_entity;
import BE.licenta.Entity.Tabela_subcategorie_entity;
import BE.licenta.Service.Tabela_subcategorie_service;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class Tabela_produs_mapper {

    @Autowired
    private Tabela_subcategorie_service tabela_subcategorie_service;


    public abstract Tabela_produs_dto dto_entity(Tabela_produs_entity tabela_produs_entity);

    public abstract Tabela_produs_entity entity_dto(Tabela_produs_dto tabela_produs_dto);

    protected Integer int_subcategorie(Tabela_subcategorie_entity tabela_subcategorie_entity){

        return tabela_subcategorie_service.returneaza_id_subcategorie(tabela_subcategorie_entity);
    }

    protected Tabela_subcategorie_entity subcategory_int(Integer value){

        return tabela_subcategorie_service.returneaza_subcategorie_dupa_id(value);
    }
}
