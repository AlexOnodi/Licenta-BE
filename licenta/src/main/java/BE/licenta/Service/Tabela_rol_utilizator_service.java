package BE.licenta.Service;

import BE.licenta.Dto.Tabela_rol_utilizator_dto;
import BE.licenta.Entity.Tabela_rol_utilizator_entity;
import BE.licenta.Mapper.Tabela_rol_utilizator_mapper;
import BE.licenta.Repository.Tabela_rol_utilizator_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Tabela_rol_utilizator_service {

    private final Tabela_rol_utilizator_mapper tabela_rol_mapper;

    private final Tabela_rol_utilizator_repo tabela_rol_repo;

    @Autowired
    public Tabela_rol_utilizator_service(Tabela_rol_utilizator_mapper tabela_rol_mapper, Tabela_rol_utilizator_repo tabela_rol_repo) {
        this.tabela_rol_mapper = tabela_rol_mapper;
        this.tabela_rol_repo = tabela_rol_repo;
    }

    public Tabela_rol_utilizator_entity creare_rol(Tabela_rol_utilizator_dto tabela_rol_dto){

        return tabela_rol_repo.save(tabela_rol_mapper.entity_dto(tabela_rol_dto));
    }

    public List<Tabela_rol_utilizator_dto> afisare_rol(){

        return tabela_rol_repo
                .findAll()
                .stream()
                .map(tabela_rol_mapper::dto_entity)
                .toList();
    }

    public void stergere_rol(int id){

        tabela_rol_repo.deleteById(id);
    }

    public int returneaza_id_rol(Tabela_rol_utilizator_entity tabela_rol_entity){

        return tabela_rol_entity.getId();
    }

    public Tabela_rol_utilizator_entity returneaza_rol_dupa_id(int id){

        return tabela_rol_repo
                .findById(id)
                .orElse(null);
    }

    public Tabela_rol_utilizator_entity actualizare(int id , Tabela_rol_utilizator_dto tabela_rol_utilizator_dto){

        tabela_rol_utilizator_dto.setId(id);

        return tabela_rol_repo.save(tabela_rol_mapper.entity_dto(tabela_rol_utilizator_dto));

    }
}

