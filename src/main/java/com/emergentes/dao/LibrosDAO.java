package com.emergentes.dao;

import com.emergentes.modelo.Libros;
import java.util.List;

public interface LibrosDAO {

    public void insert(Libros libro) throws Exception;

    public void update(Libros libro) throws Exception;

    public void delete(int id) throws Exception;

    public List<Libros> getAll() throws Exception;

    public Libros getById(int id) throws Exception;
}
