package BE.licenta.Mapper;

import BE.licenta.Dto.Tabela_utilizator_dto;
import BE.licenta.Entity.Tabela_utilizator_entity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public abstract class Tabela_utilizator_mapper {

    public abstract Tabela_utilizator_dto dto_entity(Tabela_utilizator_entity tabela_utilizator_entity);

    public abstract Tabela_utilizator_entity entity_dto(Tabela_utilizator_dto tabela_utilizator_dto);

}
