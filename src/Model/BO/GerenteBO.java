package Model.BO;

import java.sql.*;
import java.util.*;
import Model.DAO.*;
import Model.Exception.*;
import Model.VO.*;

public class GerenteBO {

    BaseInterDAO<MedicoVO> dao_medico = new MedicoDAO();
    BaseInterDAO<PacienteVO> dao_paciente = new PacienteDAO();
    BaseInterDAO<AtendenteVO> dao_atendente = new AtendenteDAO();
    BaseInterDAO<GerenteVO> dao_gerente = new GerenteDAO();

    public void CadastrarMedico(MedicoVO vo) throws  SQLException{
        try {
            ResultSet rs = dao_medico.ListarPorId(vo);
            if (rs.next()) {
                throw new InsertException("Impossível cadastrar, já existe um médico com este ID.");
            } else {
               dao_medico.Inserir(vo); 
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void CadastrarPaciente(PacienteVO vo) throws  SQLException{
        try {
            ResultSet rs = dao_paciente.ListarPorId(vo);
            if (rs.next()) {
                throw new InsertException("Impossível cadastrar, já existe um paciente com este ID.");
            } else {
               dao_paciente.Inserir(vo); 
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void CadastrarAtendente(AtendenteVO vo) throws  SQLException{
        try {
            ResultSet rs = dao_atendente.ListarPorId(vo);
            if (rs.next()) {
                throw new InsertException("Impossível cadastrar, já existe um atendente com este ID.");
            } else {
               dao_atendente.Inserir(vo); 
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void CadastrarGerente(GerenteVO vo) throws  SQLException{
        try {
            ResultSet rs = dao_gerente.ListarPorId(vo);
            if (rs.next()) {
                throw new InsertException("Impossível cadastrar, já existe um gerente com este ID.");
            } else {
               dao_gerente.Inserir(vo); 
        }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    
   
}
