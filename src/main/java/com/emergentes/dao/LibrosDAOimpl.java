package com.emergentes.dao;

import com.emergentes.modelo.Libros;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibrosDAOimpl extends ConexionBD implements LibrosDAO {

    @Override
    public void insert(Libros libro) throws Exception {
        String sql = "insert into libros(titulo,autor,disponible,categoria) values(?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, libro.getTitulo());
        ps.setString(2, libro.getAutor());
        ps.setString(3, libro.getDisponible());
        ps.setString(4, libro.getCategoria());
        ps.executeUpdate();
        this.desconetar();
    }

    @Override
    public void update(Libros libro) throws Exception {
        String sql = "update libros set titulo =?,autor=?,disponible=?,categoria=? where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, libro.getTitulo());
        ps.setString(2, libro.getAutor());
        ps.setString(3, libro.getDisponible());
        ps.setString(4, libro.getCategoria());
        ps.setInt(5, libro.getId());
        ps.executeUpdate();
        this.desconetar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from libros where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconetar();
    }

    @Override
    public List<Libros> getAll() throws Exception {
        List<Libros> lista = null;
        String sql = "select * from libros";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Libros>();

        while (rs.next()) {
            Libros lib = new Libros();
            lib.setId(rs.getInt("id"));
            lib.setTitulo(rs.getString("titulo"));
            lib.setAutor(rs.getString("autor"));
            lib.setDisponible(rs.getString("disponible"));
            lib.setCategoria(rs.getString("categoria"));

            lista.add(lib);
        }
        this.desconetar();
        return lista;
    }

    @Override
    public Libros getById(int id) throws Exception {
        Libros lib = new Libros();
        String sql = "select * from libros where id = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lib.setId(rs.getInt("id"));
            lib.setTitulo(rs.getString("titulo"));
            lib.setAutor(rs.getString("autor"));
            lib.setDisponible(rs.getString("disponible"));
            lib.setCategoria(rs.getString("categoria"));
        }
        this.desconetar();
        return lib;
    
    }

}
