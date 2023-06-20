package BE.licenta.Service;

import BE.licenta.Dto.Tabela_adresa_dto;
import BE.licenta.Entity.Tabela_adresa_entity;
import BE.licenta.Mapper.Tabela_adresa_mapper;
import BE.licenta.Repository.Tabela_adresa_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Tabela_adresa_service {

    private final Tabela_adresa_repo tabela_adresa_repo;

    private final Tabela_adresa_mapper tabela_adresa_mapper;

    @Autowired
    public Tabela_adresa_service(Tabela_adresa_repo tabela_adresa_repo, Tabela_adresa_mapper tabela_adresa_mapper) {
        this.tabela_adresa_repo = tabela_adresa_repo;
        this.tabela_adresa_mapper = tabela_adresa_mapper;
    }

    public Tabela_adresa_entity creare_adresa(Tabela_adresa_dto tabela_adresa_dto){

        return tabela_adresa_repo.save(tabela_adresa_mapper.entity_dto(tabela_adresa_dto));
    }

    public List<Tabela_adresa_dto> afisare_adresa(){

        return tabela_adresa_repo
                .findAll()
                .stream()
                .map(tabela_adresa_mapper::dto_entity)
                .toList();
    }

    public void stergere_adresa(int id){

        tabela_adresa_repo.deleteById(id);
    }

    public int returneaza_id_adresa(Tabela_adresa_entity tabela_adresa_entity){

        return tabela_adresa_entity.getId();
    }

    public Tabela_adresa_entity returneaza_adresa_dupa_id(int id){

        return tabela_adresa_repo
                .findById(id)
                .orElse(null);
    }

    public Tabela_adresa_entity actualizare(int id , Tabela_adresa_dto tabela_adresa_dto){

        tabela_adresa_dto.setId(id);

        return tabela_adresa_repo.save(tabela_adresa_mapper.entity_dto(tabela_adresa_dto));

    }
}