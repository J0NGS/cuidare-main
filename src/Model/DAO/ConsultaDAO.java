package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConsultaDAO extends BaseDAO<ConsultaVO>
/*
 * declaração de classe para a criação de Consultas DAO implementadas a MariaDB
 */
{
    @Override
    public void Inserir(ConsultaVO vo) throws SQLException {
        try {

            Date data = new Date(vo.getDataConsulta().getTimeInMillis());
            final java.sql.Timestamp dataSql = new java.sql.Timestamp(data.getTime());// tratamento da classe calendar
                                                                                      // para timestamp

            String sql = "insert into Consulta (id_medico, id_paciente, data, status) values (?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setLong(1, vo.getIdMedico());
            psts.setLong(2, vo.getIdPaciente());
            psts.setTimestamp(3, dataSql, vo.getDataConsulta());
            psts.setBoolean(4, vo.isStatus());

            int affectedRows = psts.executeUpdate(); // variável para verificação de alterações na tabela

            if (affectedRows == 0) { // verificação de alteração
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }

            ResultSet generatedKeys = psts.getGeneratedKeys(); // Id retornado da tabela

            if (generatedKeys.next()) { // caso nenhum seja id retornado, será inserido na consulta, caso não exibe
                                        // falha
                vo.setIdConsulta(generatedKeys.getLong(1));
            } else {
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de remoção de consultas */
    @Override
    public void Deletar(ConsultaVO vo) throws SQLException {
        String sql = "delete from Consulta where id_consulta = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdConsulta());
        ptst.executeUpdate();
    }

    /* método de listagem de consultas */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from Consulta"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
    }

    /* método de listagem de consultas por nome do médico */
    public ResultSet ListarPorNomeMedico(MedicoVO vo) {
        String sql = "SELECT * FROM Pessoa INNER JOIN Medico ON Medico.id_medico_pessoa = Pessoa.id INNER JOIN Consulta ON Medico.id_medico = Consulta.id_medico WHERE nome = ? "; /*
                                                                                                                                                                                    * comando
                                                                                                                                                                                    * SQL
                                                                                                                                                                                    * para
                                                                                                                                                                                    * listagem
                                                                                                                                                                                    * por
                                                                                                                                                                                    * nome
                                                                                                                                                                                    * de
                                                                                                                                                                                    * médico.
                                                                                                                                                                                    */
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

    /* método de listagem de consultas por nome do paciente */
    public ResultSet ListarPorNomePaciente(PacienteVO vo) {
        String sql = "SELECT * FROM Pessoa INNER JOIN Paciente ON Paciente.id_paciente_pessoa = Pessoa.id INNER JOIN Consulta on Paciente.id_paciente = Consulta.id_paciente WHERE nome = ?"; /*comando sql */
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
  

    /* método de listagem de consultas por Id */
    @Override
    public ResultSet ListarPorId(ConsultaVO vo) {
        String sql = "select * from Consulta where id_consulta = ?"; /* comando SQL para listagem por Id. */
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdConsulta());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet ListarPorData(ConsultaVO vo) throws SQLException {
        String sql = "select * from Consulta where data = ?";
        PreparedStatement psts = null;
        ResultSet rs = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data = new Date(vo.getDataConsulta().getTimeInMillis());
        final java.sql.Timestamp dataSql = new java.sql.Timestamp(data.getTime()); // tratamento da classe calendar para
                                                                                   // timestamp

        psts.getConnection().prepareStatement(sql);
        psts.setTimestamp(1, dataSql, vo.getDataConsulta());
        rs = psts.executeQuery();

        return rs;
    }

    /* método de atualização de dados de consultas */
    @Override
    public void Atualizar(ConsultaVO vo) {
        String sql = "update Consulta set (data, status) values (?,?) where id_consulta = ?"; /*
                                                                            * comando SQL para atualizar data da
                                                                            * consulta.
                                                                            */
        PreparedStatement psts;
        Date data = new Date(vo.getDataConsulta().getTimeInMillis());
        final java.sql.Timestamp dataSql = new java.sql.Timestamp(data.getTime()); // tratamento da classe calendar para
                                                                                   // timestamp
        try {
            psts = getConnection().prepareStatement(sql);
            psts.setTimestamp(1, dataSql, vo.getDataConsulta());
            psts.setBoolean(2, vo.getStatus());
            psts.setLong(3, vo.getIdConsulta());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
