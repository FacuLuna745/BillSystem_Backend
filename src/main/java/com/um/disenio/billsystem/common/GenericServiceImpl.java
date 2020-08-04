package com.um.disenio.billsystem.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public abstract class GenericServiceImpl <T extends Active<ID>, ID extends Serializable> implements GenericServiceApi<T,ID> {
    @Override
    public ResponseEntity<T> save(T entity) {
        getRepository().save(entity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HttpStatus> delete(ID id) {
        if(!getRepository().findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        T entity = getRepository().findById(id).get();
        entity.setActive(false);
        getRepository().save(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public T get(ID id) {
        Optional <T> obj = getRepository().findById(id);
        if(obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return getRepository().findAll()
                .stream()
                .filter(Active::getActive)
                .collect(Collectors.toList());
    }

    public  abstract JpaRepository<T,ID> getRepository();
}
