package BE.licenta.Mapper;

import BE.licenta.Dto.Tabela_categorie_dto;
import BE.licenta.Entity.Tabela_categorie_entity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface Tabela_categorie_mapper {

    Tabela_categorie_dto dto_entity(Tabela_categorie_entity tabela_categorie_entity);

    Tabela_categorie_entity entity_dto(Tabela_categorie_dto tabela_categorie_dto);

}
