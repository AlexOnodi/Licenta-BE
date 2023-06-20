package BE.licenta.Service;

import BE.licenta.Dto.Tabela_favorite_dto;
import BE.licenta.Entity.Tabela_favorite_entity;
import BE.licenta.Mapper.Tabela_favorite_mapper;
import BE.licenta.Repository.Tabela_favorite_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Tabela_favorite_service {

    private final Tabela_favorite_repo tabela_favorite_repo;

    private final Tabela_favorite_mapper tabela_favorite_mapper;

    @Autowired

    public Tabela_favorite_service(Tabela_favorite_repo tabela_favorite_repo, Tabela_favorite_mapper tabela_favorite_mapper) {
        this.tabela_favorite_repo = tabela_favorite_repo;
        this.tabela_favorite_mapper = tabela_favorite_mapper;
    }

    public Tabela_favorite_entity creare_favorite(Tabela_favorite_dto tabela_favorite_dto){

        return tabela_favorite_repo.save(tabela_favorite_mapper.entity_dto(tabela_favorite_dto));
    }

    public List<Tabela_favorite_dto> afisare_favorite(){

        return tabela_favorite_repo
                .findAll()
                .stream()
                .map(tabela_favorite_mapper::dto_entity)
                .toList();
    }



    public void stergere_favorite(int id){

        tabela_favorite_repo.deleteById(id);
    }

    public int returneaza_id_favorite(Tabela_favorite_entity tabela_favorite_entity){

        return tabela_favorite_entity.getId();
    }

    public Tabela_favorite_entity returneaza_favorite_dupa_id(int id){

        return tabela_favorite_repo
                .findById(id)
                .orElse(null);
    }

    public Tabela_favorite_entity actualizare(int id , Tabela_favorite_dto tabela_favorite_dto){

        tabela_favorite_dto.setId(id);

        return tabela_favorite_repo.save(tabela_favorite_mapper.entity_dto(tabela_favorite_dto));

    }
}

