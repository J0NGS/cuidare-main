package Model.DAO;

import Model.VO.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class GerenteDAO extends UsuarioDAO <GerenteVO>
/*
 * declaração de classe para a criação de Gerentes DAO implementados a MariaDB
 */
{

    /* método de inserção de gerentes */
    @Override
    public void Inserir(GerenteVO vo) throws SQLException {
        super.Inserir(vo);
        String sql = "insert into Gerente (id_gerente_user, id_gerente_pessoa) values (?,?)";
        PreparedStatement psts;
        psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        psts.setLong(1,vo.getIdUser());
        psts.setLong(2,vo.getIdPessoa());
        
        int affectedRows = psts.executeUpdate(); //variável para verificação de alterações na tabela
        
        if (affectedRows == 0) { // verificação de alteração
            throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
        }
        
        ResultSet generatedKeys = psts.getGeneratedKeys(); //Id retornado da tabela
        
        if (generatedKeys.next()) { //caso nenhum seja id retornado, será inserido ao gerente, caso não, a falha é exibida
            vo.setIdGerente(generatedKeys.getLong(1));
        } else {
            throw new SQLException("A inserção falhou. nenhum id foi retornado.");
        }
    }

    /* método de remoção de gerentes */
    @Override
    public void Deletar(GerenteVO vo) throws SQLException {
        String sql = "delete from Gerente where id_gerente = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setLong(1, vo.getIdGerente());
        ptst.executeUpdate();
        super.Deletar(vo);
    }

    /* método de listagem de gerentes */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from Gerente"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
    }

    /* método de listagem por nome de gerentes */
    @Override
    public ResultSet ListarPorNome(GerenteVO vo) throws SQLException {
        String sql = "SELECT * FROM pessoa LEFT JOIN gerente ON pessoa.id = gerente.id_gerente_pessoa WHERE nome = ? ";
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        rs = psts.executeQuery();
        return rs;
    }

    /* método de listagem por Id de gerentes */
    @Override
    public ResultSet ListarPorId(GerenteVO vo) throws SQLException {
        String sql = "select * from Gerente where id_gerente = ?"; /* comando SQL para listagem por Id. */
        PreparedStatement psts;
        ResultSet rs = null;
        psts = getConnection().prepareStatement(sql);
        psts.setLong(1, vo.getIdGerente());
        rs = psts.executeQuery();
        return rs;
    }
    
    /* método para a atualização de dados de gerentes */
    @Override
    public void Atualizar(GerenteVO vo) throws SQLException { 
        String sql = "update gerente set (nome, cpf, login, senha) values (?,?,?,?) where id_gerente = ?"; /* comando SQL para atualização (update). */
        PreparedStatement psts;
        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        psts.setString(2, vo.getCpf());
        psts.setString(3, vo.getLogin());
        psts.setString(4, vo.getSenha());
        psts.setLong(5, vo.getIdGerente());
        psts.executeUpdate();
    }
    /* metodo para listar pelo id pessoa*/    
    public ResultSet ListarPorIdPessoa(GerenteVO vo) throws SQLException {
        String sql = "select * from Gerente where id_pessoa = ?"; /* comando SQL para listagem por Id. */
        PreparedStatement psts;
        ResultSet rs = null;
        psts = getConnection().prepareStatement(sql);
        psts.setLong(1, vo.getIdPessoa());
        rs = psts.executeQuery();
        return rs;
    }

}
