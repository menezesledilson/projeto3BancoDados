/**
 * 
 */
package br.com.rpires.dao.generic.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rpires.dao.generic.jdbc.ConnectionFactory;
import br.com.rpires.domin.Cliente;

/**
 * @author rodrigo.pires
 * 
 */
public class ClienteDAO implements IClienteDAO {

	private PreparedStatement stm;

	@Override
	public Integer cadastrar(Cliente cliente) throws Exception {

		Connection connection = null; // conexao com banco
		PreparedStatement stm = null;// comando a ser excutado no banco

		try {
			connection = ConnectionFactory.getConnection();
			String sql = (" Insert Into TB_CLIENTE_2 (ID, CODIGO, NOME) VALUES (nextval('SQ_CLIENTE_2'), ?, ?)");
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			stm.setString(2, cliente.getNome());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (stm != null && !connection.isClosed()) {
				stm.close();
			}
		}
	}

	@Override
	public Integer excluir(Cliente cliente) throws Exception {
		Connection connection = null; // conexao com banco
		PreparedStatement stm = null;// comando a ser excutado no banco

		try {
			connection = ConnectionFactory.getConnection();
			String sql = ("DELETE FROM TB_CLIENTE_2 WHERE CODIGO = ? ");
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (stm != null && !connection.isClosed()) {
				stm.close();
			}
		}
	}

	@Override
	public Cliente buscar(String codigo) throws Exception {
		Connection connection = null; // conexao com banco
		PreparedStatement stm = null;// comando a ser excutado no banco
		ResultSet rs = null;

		try {
			connection = ConnectionFactory.getConnection();

			String sql = ("SELECT* FROM TB_CLIENTE_2 WHERE CODIGO = ? ");
			stm = connection.prepareStatement(sql);

			stm.setString(1, codigo);
			rs = stm.executeQuery();

			if (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getString("CODIGO"));
				cliente.setNome(rs.getString("NOME"));

				return cliente;
			} else {
				return null;
			}
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (stm != null && !connection.isClosed()) {
				stm.close();
			}
		}
	}

	@Override
	public Integer atualizar(Cliente cliente) throws Exception {

		Connection connection = null; // conexao com banco
		PreparedStatement stm = null;// comando a ser excutado no banco

		try {
			connection = ConnectionFactory.getConnection();
			String sql = (" UPDATE TB_CLIENTE_2 SET NOME = ? WHERE CODIGO = ?");

			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCodigo());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (stm != null && !connection.isClosed()) {
				stm.close();
			}
		}
	}

	@Override
	public List<Cliente> buscarTodos() throws Exception {

		Connection connection = null; // conexao com banco
		PreparedStatement stm = null;// comando a ser excutado no banco
		ResultSet rs = null;
		List<Cliente> list = new ArrayList<>();

		try {
			connection = ConnectionFactory.getConnection();

			String sql = (" SELECT * FROM TB_CLIENTE_2");
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getString("CODIGO"));
				cliente.setNome(rs.getString("NOME"));

				list.add(cliente);
			}
			return list;
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (stm != null && !connection.isClosed()) {
				stm.close();
			}
		}
	}

}
