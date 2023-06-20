package BE.licenta.Service;

import BE.licenta.Dto.Tabela_subcategorie_dto;
import BE.licenta.Entity.Tabela_subcategorie_entity;
import BE.licenta.Mapper.Tabela_subcategorie_mapper;
import BE.licenta.Repository.Tabela_subcategorie_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Tabela_subcategorie_service {

    private final Tabela_subcategorie_repo tabela_subcategorie_repo;

    private final Tabela_subcategorie_mapper tabela_subcategorie_mapper;

    @Autowired
    public Tabela_subcategorie_service(Tabela_subcategorie_repo tabela_subcategorie_repo, Tabela_subcategorie_mapper tabela_subcategorie_mapper) {
        this.tabela_subcategorie_repo = tabela_subcategorie_repo;
        this.tabela_subcategorie_mapper = tabela_subcategorie_mapper;
    }

    public Tabela_subcategorie_entity creare_subcategorie(Tabela_subcategorie_dto tabela_subcategorie_dto){

        return tabela_subcategorie_repo.save(tabela_subcategorie_mapper.entity_dto(tabela_subcategorie_dto));
    }

    public List<Tabela_subcategorie_dto> afisare_subcategorie(){

        return tabela_subcategorie_repo
                .findAll()
                .stream()
                .map(tabela_subcategorie_mapper::dto_entity)
                .toList();
    }

    public void stergere_subcategorie(int id){

        tabela_subcategorie_repo.deleteById(id);
    }

    public int returneaza_id_subcategorie(Tabela_subcategorie_entity tabela_subcategorie_entity){

        return tabela_subcategorie_entity.getId();
    }

    public Tabela_subcategorie_entity returneaza_subcategorie_dupa_id(int id){

        return tabela_subcategorie_repo
                .findById(id)
                .orElse(null);
    }

    public Tabela_subcategorie_entity actualizare(int id , Tabela_subcategorie_dto tabela_subcategorie_dto){

        tabela_subcategorie_dto.setId(id);

        return tabela_subcategorie_repo.save(tabela_subcategorie_mapper.entity_dto(tabela_subcategorie_dto));

    }
}

