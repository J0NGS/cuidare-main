package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class AtendenteDAO extends UsuarioDAO <AtendenteVO> 
/* declaração de classe para a criação de Atendentes DAO implementados a MariaDB */
{
    /* criação do método de inserção de atendentes */
    @Override
    public void Inserir (AtendenteVO vo) throws SQLException {
            super.Inserir(vo);
            String sql = "insert into Atendente (id_atendente_user, id_atendente_pessoa) values (?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setLong(1, vo.getIdUser());
            psts.setLong(2, vo.getIdPessoa());
            int affectedRows = psts.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
            ResultSet generatedKeys = psts.getGeneratedKeys();
            if(generatedKeys.next()){
                vo.setIdAtendente(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 
    }

    /* método de remoção de atendentes */
    @Override
    public void Deletar(AtendenteVO vo) throws SQLException {
        String sql = "delete from Atendente where id_atendente = ?"; /* comando SQL para remoção de atendentes. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdAtendente());
        ptst.executeUpdate();
        super.Deletar(vo);
    }

    /* método de listagem de atendentes */
    @Override
    public ResultSet Listar() {
        String sql = "select * from Atendente"; /* comando SQL para listagem de atendentes. */
        Statement st;
        ResultSet rs = null;
        try {
            st = getConnection().prepareStatement(sql);
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /* método de listagem de atendentes por nome */
    @Override
    public ResultSet ListarPorNome (AtendenteVO vo) {
        String sql = "SELECT * FROM pessoa LEFT JOIN atendente ON atendente.id_atendente_pessoa = pessoa.id WHERE nome = ? "; /* comando SQL para listagem por nome de atendentes. */
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /* método de listagem de atendentes por Id */
    @Override
    public ResultSet ListarPorId (AtendenteVO vo) {
        String sql = "select * from Gerente where id_atendente = ?"; /* comando SQL para listagem de atendentes por Id. */
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdAtendente());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    /* método de atualização dos dados de atendentes */
    @Override
    public void Atualizar (AtendenteVO vo){
        String sql = "update Pessoa set nome = ? where id = ?"; /* comando SQL para atualização (update) de dados de atendentes. */
        PreparedStatement psts;
        try{
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            psts.setLong(2, vo.getIdPessoa());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
