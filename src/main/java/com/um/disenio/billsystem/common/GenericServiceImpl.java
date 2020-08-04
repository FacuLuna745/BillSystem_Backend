package com.um.disenio.billsystem.common;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl <T, ID extends Serializable> implements GenericServiceApi<T,ID> {
    @Override
    public ResponseEntity<T> save(T entity) {
        getRepository().save(entity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
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
        List<T> returnList = new ArrayList<>();
        getRepository().findAll().forEach(returnList::add);
        return returnList;
    }

    public  abstract CrudRepository<T,ID> getRepository();
}
