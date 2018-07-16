package com.fbfagostousa.domain.users;
import javax.persistence.*;

@Entity
public class Autorizacion {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Autorizacion() {
    }

    public Autorizacion(Usuario usuario, Role role) {
        assert usuario != null && role != null;
        this.usuario = usuario;
        this.role = role;
    }

    public int getId() {
        return id;
    }



    public Role getRole() {
        return role;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return id == ((Autorizacion) obj).id;
    }

    @Override
    public String toString() {
        return "Authorization [id=" + id + ", userId=" + usuario.getId() + ", role=" + role + "]";
    }

}
