package com.emergentes.dao;

import com.emergentes.modelo.Categorias;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDAOimpl extends ConexionBD implements CategoriasDAO {

    @Override
    public void insert(Categorias cat) throws Exception {
        String sql = "insert into categorias(categoria) values(?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cat.getCategoria());
        ps.executeUpdate();
        this.desconetar();
    }

    @Override
    public void update(Categorias cat) throws Exception {
        String sql = "update categorias set categoria =? where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cat.getCategoria());
        ps.setInt(2, cat.getId());
        ps.executeUpdate();
        this.desconetar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from categorias where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconetar();
    }

    @Override
    public List<Categorias> getAll() throws Exception {
        List<Categorias> lista = null;
        String sql = "select * from categorias";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Categorias>();

        while (rs.next()) {
            Categorias cat = new Categorias();
            cat.setId(rs.getInt("id"));
            cat.setCategoria(rs.getString("categoria"));
            lista.add(cat);
        }
        this.desconetar();
        return lista;
    }

    @Override
    public Categorias getById(int id) throws Exception {
        Categorias cat = new Categorias();
        String sql = "select * from categorias where id = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            cat.setId(rs.getInt("id"));
            cat.setCategoria(rs.getString("categoria"));
        }
        this.desconetar();
        return cat;
    }
}
