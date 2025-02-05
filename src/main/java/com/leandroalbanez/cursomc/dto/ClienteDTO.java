package com.leandroalbanez.cursomc.dto;

import com.leandroalbanez.cursomc.domain.Cliente;
import com.leandroalbanez.cursomc.services.validation.ClienteUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@ClienteUpdate
public class ClienteDTO {
    private Integer id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min=5, max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
