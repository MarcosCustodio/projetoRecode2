package com.spacetur.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.spacetur.factory.ConnectionFactory;
import com.spacetur.model.Usuario;

public class UsuarioDAO {

	public void save (Usuario usuario) {
		
		String sql = "INSERT INTO usuario(nome_usuario, cpf_usuario, telefone_usuario, senha_usuario, email_usuario)VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome_usuario());
			pstm.setInt(2, usuario.getCpf_usuario());
			pstm.setInt(3, usuario.getTelefone_usuario());
			pstm.setInt(4, usuario.getSenha_usuario());
			pstm.setString(5, usuario.getEmail_usuario());
			
			
			pstm.execute();
			
			System.out.println("Usuário salvo com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if (conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	public void  update(Usuario usuario) {
		
		String sql = "UPDATE usuario SET nome_usuario = ?, cpf_usuario = ?, telefone_usuario = ?, email_usuario = ?, senha_usuario = ? " +
		"WHERE id_usuario = ?";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome_usuario());
			pstm.setInt(2, usuario.getCpf_usuario());
			pstm.setInt(3, usuario.getTelefone_usuario());
			pstm.setString(4, usuario.getEmail_usuario());
			pstm.setInt(5, usuario.getSenha_usuario());
			
			pstm.setInt(6, usuario.getId());
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void deletebyID(int id) {
		
		String sql = "DELETE FROM usuario WHERE id_usuario = ?";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public List<Usuario> getUsuarios() {
		
		String sql = "SELECT * FROM usuario";
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setId(rset.getInt("id_usuario"));
				
				usuario.setNome_usuario(rset.getString("nome_usuario"));
				
				usuario.setCpf_usuario(rset.getInt("cpf_usuario"));
				
				usuario.setTelefone_usuario(rset.getInt("telefone_usuario"));
				
				usuario.setEmail_usuario(rset.getString("email_usuario"));
				
				usuario.setSenha_usuario(rset.getInt("senha_usuario"));
				
				usuarios.add(usuario);
				
				
			}
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}
					
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return usuarios;

}


	public static Usuario[] get() {
		// TODO Auto-generated method stub
		return null;
	  }
	}