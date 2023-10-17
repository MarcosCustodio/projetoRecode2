package com.spacetur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.spacetur.factory.ConnectionFactory;
import com.spacetur.model.Destino;

public class DestinoDAO {

    public void save(Destino destino) {
        String sql = "INSERT INTO destino (valor, data_ida, data_volta) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setDouble(1, destino.getValor());
            pstm.setDate(2, java.sql.Date.valueOf(destino.getData_ida()));
            pstm.setDate(3, java.sql.Date.valueOf(destino.getData_volta()));

            pstm.execute();

            System.out.println("Destino salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    public void update(Destino destino) {
        String sql = "UPDATE destino SET valor = ? WHERE id_destino = ?";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setDouble(1, destino.getValor());
            pstm.setInt(2, destino.getId());

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    public void deletebyID(int id) {
        String sql = "DELETE FROM destino WHERE id_destino = ?";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    public List<Destino> getDestinos() {
        String sql = "SELECT * FROM destino";
        List<Destino> destinos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rset = pstm.executeQuery()) {

            while (rset.next()) {
                Destino destino = new Destino();
                destino.setId(rset.getInt("id_destino"));
                destino.setValor(rset.getInt("valor"));
                destino.setData_ida(rset.getDate("data_ida").toLocalDate());
                destino.setData_volta(rset.getDate("data_volta").toLocalDate());
                destinos.add(destino);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return destinos;
    }
}
