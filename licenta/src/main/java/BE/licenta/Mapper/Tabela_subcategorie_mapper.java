package BE.licenta.Mapper;

import BE.licenta.Dto.Tabela_subcategorie_dto;
import BE.licenta.Entity.Tabela_categorie_entity;
import BE.licenta.Entity.Tabela_subcategorie_entity;
import BE.licenta.Service.Tabela_categorie_service;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")

public abstract class Tabela_subcategorie_mapper {

    @Autowired
    private Tabela_categorie_service tabela_categorie_service;

    public abstract Tabela_subcategorie_dto dto_entity(Tabela_subcategorie_entity tabela_subcategorie_entity);

    public abstract Tabela_subcategorie_entity entity_dto(Tabela_subcategorie_dto tabela_subcategorie_dto);

    protected Integer int_category(Tabela_categorie_entity tabela_categorie_entity){

        return tabela_categorie_service.returneaza_id_categorie(tabela_categorie_entity);
    }

    protected Tabela_categorie_entity category_int(Integer value){

        return tabela_categorie_service.returneaza_categorie_dupa_id(value);
    }

}
