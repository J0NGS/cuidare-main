package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.Date;

public class ProntuarioDAO extends BaseDAO <ProntuarioVO>
/* declaração de classe para a criação de Prontuarios DAO implementados a MariaDB */
{
    /* método de inserção de prontuários */
    @Override
    public void Inserir (ProntuarioVO vo) throws SQLException{
            Date data = new Date();
            data = vo.getDataNascimento().getTime();
            java.sql.Date dataSQL = new java.sql.Date(data.getTime());
            String sql = "insert into Prontuario ( data_nascimento, ante_patologico, medi_atuais, medi_alergicos, historico_doenças, peso, altura, id_prontuario_paciente) values (?,?,?,?,?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setDate(1, dataSQL ,vo.getDataNascimento());
            psts.setString(2, vo.getAntenPatologico());
            psts.setString(3, vo.getMediAtuais());
            psts.setString(4, vo.getMediAlergia());
            psts.setString(5, vo.getHistoricoDoenca());
            psts.setFloat(6, vo.getPeso());
            psts.setFloat(7, vo.getAltura());
            psts.setLong(8, vo.getIdPaciente());
            
            int affectedRows = psts.executeUpdate(); //variável para verificação de alterações na tabela
            
            if (affectedRows == 0){ // verificação de alteração
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
            
            ResultSet generatedKeys = psts.getGeneratedKeys(); //Id retornado da tabela
            
            if(generatedKeys.next()){ //caso nenhum seja id retornado, será inserido ao prontuário, caso não, a falha é exibida
                vo.setIdProntuario(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 
        }

    /* método de remoção de Usuarios */
    @Override
    public void Deletar (ProntuarioVO vo) throws SQLException{
        String sql = "delete from Prontuario where id_prontuario = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setLong(1, vo.getIdProntuario());
        ptst.executeUpdate();
    }

    /* método de listagem de Usuarios */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from Prontuario"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
    }

     /* método de listagem de prontuário por Id */
    @Override
    public ResultSet ListarPorId (ProntuarioVO vo) throws SQLException {
        String sql = "select * from Prontuario where id_prontuario = ?"; /* comando de listagem por Id. */
        PreparedStatement psts;
        ResultSet rs = null;
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdProntuario());
            rs = psts.executeQuery();
        return rs;
    }
    
    /* método de atualização de dados de prontuários */
    @Override
    public void Atualizar (ProntuarioVO vo) throws SQLException {
        String sql = "update Prontuario set peso = ? where id_prontuario = ?"; /* comando de atualização (update) em SQL. */
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setFloat(1,vo.getPeso());
            psts.setLong(2, vo.getIdProntuario());
            psts.executeUpdate();
    }
}
