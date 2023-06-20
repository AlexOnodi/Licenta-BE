package BE.licenta.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "tabela_utilizator")
@NoArgsConstructor

public class Tabela_utilizator_entity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String nume;

    private String prenume;

    private String email;

    private String telefon;

    private String parola;

    public Tabela_utilizator_entity(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.email = username;
        this.parola = password;
    }


    @OneToMany(mappedBy = "tabela_utilizator_entity_id")
    @JsonManagedReference
    private List<Tabela_adresa_entity> tabela_adresa_entity_list;

    @OneToOne(mappedBy = "tabela_utilizator_entity_id2")
    @JsonManagedReference
    private Tabela_rol_utilizator_entity tabela_rol_utilizator_entity;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return parola;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
