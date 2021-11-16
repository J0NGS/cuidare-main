package Model.BO;

import java.sql.*;
import java.util.*;
import Model.DAO.*;
import Model.Exception.*;
import Model.VO.*;

public class MedicoBO {

    BaseInterDAO<LaudoVO> dao = new LaudoDAO();

    public void CadastrarLaudo(LaudoVO vo) throws  SQLException{
        ResultSet rs = dao.ListarPorId(vo);
        try {
            if (rs.next()) {
                throw new InsertException("Impossível cadastrar, já existe um laudo com este ID.");
            } else {
               dao.Inserir(vo); 
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void EditarLaudo(LaudoVO vo) {

    }

    public List<ProntuarioVO> BuscarPronturarioPaciente (ProntuarioVO vo) {
       
    }

    public List<ConsultaVO> BuscarConsultasMarcadas (ConsultaVO vo) {
      
    }
}