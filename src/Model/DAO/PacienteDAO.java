package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class PacienteDAO extends PessoaDAO<PacienteVO> {
    /*
     * declaração de classe para a criação de Pacientes DAO implementados a MariaDB
     */

    /* método de inserção de pacientes */
    @Override
    public void Inserir(PacienteVO vo) throws SQLException {
        super.Inserir(vo);

        System.out.println("id paciente pessoa : " + vo.getIdPessoa());

        String sql = "insert into Paciente (endereco, id_paciente_pessoa) values (?,?)"; //comando de inserção em SQL para o DB.
        PreparedStatement ptst;

        ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        ptst.setNString(1, vo.getEndereco());
        ptst.setLong(2, vo.getIdPessoa());
        
        int effectedrows = ptst.executeUpdate(); //variável para verificação de alterações na tabela
        
        if (effectedrows == 0) { // verificação de alteração
            throw new SQLException("A inserção falhou. Nenhuma linha foi alterada");
        }
        ResultSet generatedKeys = ptst.getGeneratedKeys(); //Id retornado da tabela
        if (generatedKeys.next()) { //caso nenhum seja id retornado, será inserido ao paciente, caso não, a falha é exibida
            vo.setIdPaciente(generatedKeys.getLong(1));
        } else {
            throw new SQLException("A inserção falhou. Nenhum id foi retornado");
        }
    }

    /* método de remoção de dados de pacientes */
    @Override
    public void Deletar(PacienteVO vo) throws SQLException {
        String sql = "delete from Paciente where id_paciente = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setLong(1, 2L);
        ptst.executeUpdate();
        super.Deletar(vo);
    }

    /* método de listagem de pacientes */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from Paciente"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
    }

    /* método de listagem de pacientes por nome */
    public ResultSet ListarPorNome(PacienteVO vo) throws SQLException {
        String sql = "SELECT * FROM Pessoa LEFT JOIN Paciente ON pessoa.id = Paciente.id_paciente_pessoa WHERE Pessoa.nome = ? "; //comando SQL para listagem por nome.
        PreparedStatement psts;
        ResultSet rs = null;
        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        rs = psts.executeQuery();
        return rs;
    }

    /* método de listagem de pacientes por Id. */
    @Override
    public ResultSet ListarPorId(PacienteVO vo) throws SQLException {
        String sql = "select * from Paciente where id_paciente = ?"; //comando SQL para listagem por Id.
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setLong(1, vo.getIdPaciente());
        rs = psts.executeQuery();
        return rs;
    }

    /* método de listagem de pacientes por CPF. */
    public ResultSet ListarPorCpf(PacienteVO vo) throws SQLException {
        String sql = "SELECT * FROM Pessoa LEFT JOIN Paciente ON Pessoa.id = Paciente.id_paciente_pessoa WHERE cpf = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getCpf());
        rs = psts.executeQuery();
        return rs;
    }

    /* método de atualização dos dados de pacientes */
    @Override
    public void Atualizar(PacienteVO vo) throws SQLException {
        String sql = "update Pessoa set nome = ? where id = ?"; //comando SQL para a atualização (update) de dados dos pacientes
        PreparedStatement psts;

        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        psts.setLong(2, vo.getIdPessoa());
        psts.executeUpdate();
    }
}
