package Model.BO;

import java.sql.*;
import java.util.*;
import Model.DAO.PacienteDAO;
import Model.Exception.ListException;
import Model.VO.PacienteVO;

public class PacienteBO{

    @Override
    public List<PacienteVO> Buscar(PacienteVO vo) throws SQLException {
        try {
            if(vo.getCpf() == null && vo.getNome() == null){
                throw new ListException("Insira pelo menos um filtro de busca");
            }
        } catch (ListException e) {
            e.getMessage();
        }
        
        List<PacienteVO> listapacientes = new ArrayList<PacienteVO>();
        PacienteDAO dao = new PacienteDAO(); 
        ResultSet rs = dao.ListarPorCpf(vo);
        try {
            if(rs.next()){
                while(rs.next()){
                    PacienteVO pacienteLista = new PacienteVO();
                    pacienteLista.setCpf(rs.getString("cpf"));
                    pacienteLista.setNome(rs.getString("nome"));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listapacientes;
    }

    @Override
    public void Cadastrar(PacienteVO vo) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Editar(PacienteVO vo) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Excluir(PacienteVO vo) throws SQLException {
        // TODO Auto-generated method stub
        
    } 
}