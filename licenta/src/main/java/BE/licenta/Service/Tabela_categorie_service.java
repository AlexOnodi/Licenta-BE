package BE.licenta.Service;

import BE.licenta.Dto.Tabela_categorie_dto;
import BE.licenta.Entity.Tabela_categorie_entity;
import BE.licenta.Entity.Tabela_produs_entity;
import BE.licenta.Mapper.Tabela_categorie_mapper;
import BE.licenta.Repository.Tabela_categorie_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Tabela_categorie_service {

    private final Tabela_categorie_repo tabela_categorie_repo;

    private final Tabela_categorie_mapper tabela_categorie_mapper;

    @Autowired
    public Tabela_categorie_service(Tabela_categorie_repo tabela_categorie_repo, Tabela_categorie_mapper tabela_categorie_mapper) {
        this.tabela_categorie_repo = tabela_categorie_repo;
        this.tabela_categorie_mapper = tabela_categorie_mapper;
    }

    public Tabela_categorie_entity creare_categorie(Tabela_categorie_dto tabela_categorie_dto){

        return tabela_categorie_repo.save(tabela_categorie_mapper.entity_dto(tabela_categorie_dto));
    }

    public List<Tabela_categorie_dto> afisare_categorie(){

        return tabela_categorie_repo
                .findAll()
                .stream()
                .map(tabela_categorie_mapper::dto_entity)
                .toList();
    }

    public void stergere_categorie(int id){

        tabela_categorie_repo.deleteById(id);
    }

    public int returneaza_id_categorie(Tabela_categorie_entity tabela_categorie_entity){

        return tabela_categorie_entity.getId();
    }

    public Tabela_categorie_entity returneaza_categorie_dupa_id(int id){

        return tabela_categorie_repo
                .findById(id)
                .orElse(null);
    }

    public Tabela_categorie_entity actualizare(int id , Tabela_categorie_dto tabela_categorie_dto){

        tabela_categorie_dto.setId(id);

        return tabela_categorie_repo.save(tabela_categorie_mapper.entity_dto(tabela_categorie_dto));

    }

    public List<Tabela_categorie_entity>cautare(String value){

        return tabela_categorie_repo.findByDenumireContainingIgnoreCase(value);

    }



}
