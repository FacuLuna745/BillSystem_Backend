package com.um.disenio.billsystem.common;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceApi <T, ID extends Serializable> {
    T save (T entity);
    void delete (ID id);
    T get(ID id);
    List<T> getAll();
}
