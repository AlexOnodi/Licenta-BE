package BE.licenta.Service;

import BE.licenta.Dto.Tabela_produs_dto;
import BE.licenta.Entity.Tabela_produs_entity;
import BE.licenta.Mapper.Tabela_produs_mapper;
import BE.licenta.Repository.Tabela_produs_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tabela_produs_service {

    private final Tabela_produs_repo tabela_produs_repo;

    private final Tabela_produs_mapper tabela_produs_mapper;

    @Autowired
    public Tabela_produs_service(Tabela_produs_repo tabela_produs_repo, Tabela_produs_mapper tabela_produs_mapper) {
        this.tabela_produs_repo = tabela_produs_repo;
        this.tabela_produs_mapper = tabela_produs_mapper;
    }

    public Tabela_produs_entity creare_produs(Tabela_produs_dto tabela_produs_dto){

        return tabela_produs_repo.save(tabela_produs_mapper.entity_dto(tabela_produs_dto));
    }

    public List<Tabela_produs_dto> afisare_produs(){

        return tabela_produs_repo
                .findAll()
                .stream()
                .map(tabela_produs_mapper::dto_entity)
                .toList();
    }



    public void stergere_produs(int id){

        tabela_produs_repo.deleteById(id);
    }

    public int returneaza_id_produs(Tabela_produs_entity tabela_produs_entity){

        return tabela_produs_entity.getId();
    }

    public Tabela_produs_entity returneaza_produs_dupa_id(int id){

        return tabela_produs_repo
                .findById(id)
                .orElse(null);
    }

    public Tabela_produs_entity actualizare(int id , Tabela_produs_dto tabela_produs_dto){

        tabela_produs_dto.setId(id);

        return tabela_produs_repo.save(tabela_produs_mapper.entity_dto(tabela_produs_dto));

    }

    public List<Tabela_produs_entity>cautare(String value){

        return tabela_produs_repo.findByDenumireContainingIgnoreCase(value);

    }
}
