package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class MedicoDAO extends UsuarioDAO < MedicoVO > 
/* declaração de classe para a criação de Médicos DAO implementados a MariaDB */
{
    /* método de inserção de Médicos ao MariaDB */
    @Override
    public void Inserir(MedicoVO vo) throws SQLException {
            super.Inserir(vo);
            String sql = "insert into Medico (crm, valorconsulta, endereco, id_medico_pessoa, id_medico_user) values (?,?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setString(1, vo.getCrm());
            psts.setDouble(2, vo.getValorConsulta());
            psts.setString(3, vo.getEndereco());
            psts.setLong(4, vo.getIdPessoa());
            psts.setLong(5, vo.getIdUser());
        
            int affectedRows = psts.executeUpdate(); //variável para verificação de alterações na tabela
        
            if (affectedRows == 0){ // verificação de alteração
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
        
            ResultSet generatedKeys = psts.getGeneratedKeys(); //Id retornado da tabela
        
            if(generatedKeys.next()){ //caso nenhum seja id retornado, será inserido ao médico, caso não, a falha é exibida
                vo.setIdMedico(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 
    }

    /* método de remoção de médicos */
    @Override
    public void Deletar(MedicoVO vo) throws SQLException {
        String sql = "delete from Medico where id_medico = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setLong(1, vo.getIdMedico());
        ptst.executeUpdate();
        super.Deletar(vo);
    }

    /* método de listagem de médicos */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from User"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
            st = getConnection().prepareStatement(sql);
            rs = st.executeQuery(sql);
        return rs;
    }
    
    /* método de listagem de médicos por nome */
    @Override
    public ResultSet ListarPorNome(MedicoVO vo) throws SQLException {
        String sql = "SELECT * FROM pessoa LEFT JOIN medico ON medico.id_medico_pessoa = pessoa.id WHERE nome = ? "; /* comando SQL para listagem por nome. */
        PreparedStatement psts;
        ResultSet rs = null;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            rs = psts.executeQuery();
        return rs;
    }

    /* método de listagem de médicos por Id */
    @Override
    public ResultSet ListarPorId(MedicoVO vo) throws SQLException {
        String sql = "select * from Medico where id_medico = ?"; /* comando SQL para listagem por Id. */
        PreparedStatement psts;
        ResultSet rs = null;
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdMedico());
            rs = psts.executeQuery();
        return rs;
    }

    /* método de listagem de médicos por CRM */
    public ResultSet ListarPorCrm(MedicoVO vo) throws SQLException {
        String sql = "select * from Pessoa Left Join medico ON medico.id_medico_pessoa = pessoa.id where crm = ?"; /* comando SQL para listagem por CRM. */
        PreparedStatement psts;
        ResultSet rs = null;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getCrm());
            rs = psts.executeQuery();
        return rs;
    }

    /* método para atualização dos dados de médicos */
    @Override
    public void Atualizar(MedicoVO vo) throws SQLException {
        String sql = "update Pessoa set nome = ? where id = ?"; /* comando SQL para atualização (update). */
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            psts.setLong(2, vo.getIdPessoa());
            psts.executeUpdate();
    }
}
