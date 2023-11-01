package com.emergentes.dao;

import com.emergentes.modelo.Categorias;
import java.util.List;

public interface CategoriasDAO {

    public void insert(Categorias cat) throws Exception;

    public void update(Categorias cat) throws Exception;

    public void delete(int id) throws Exception;

    public List<Categorias> getAll() throws Exception;

    public Categorias getById(int id) throws Exception;
}
