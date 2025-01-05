package com.leandroalbanez.cursomc.services;

import com.leandroalbanez.cursomc.domain.Cliente;
import com.leandroalbanez.cursomc.dto.ClienteDTO;
import com.leandroalbanez.cursomc.repositories.ClienteRepository;
import com.leandroalbanez.cursomc.services.exception.DataIntegrityException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Cliente find(Integer id){
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + " Tipo: " + Cliente.class.getName(),Cliente.class));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }
    public Cliente insert(Cliente obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir pois há entidades relacionadas");
        }
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO dto) {
        return new Cliente(dto.getId(), dto.getNome(), dto.getEmail(), null, null);
    }

    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

}
