package Model.BO;

import Model.DAO.PacienteDAO;
import Model.Exception.InsertException;
import Model.VO.AtendenteVO;
import Model.VO.PacienteVO;

public class AtendenteBO{

    public void CadastrarPaciente(PacienteVO vo) throws InsertException {
            if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
                throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
            }
            if(vo.getCpf() == null){ // verificando se existe dados dentro do cpf
                throw new InsertException("CPF está vazio");
            }
            if(vo.getCpf().matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
                throw new InsertException("CPF só pode conter números");
            }
            if(vo.getNome() == null || vo.getNome() == ""){ // verirficando se existe dados no nome
                throw new InsertException("Paciente com nome vazio");
            }
            if(vo.getEndereco() == null || vo.getEndereco() == ""){ // verirficando se existe dados no nome
                throw new InsertException("Paciente com endereço vazio");
            } 
            else {
                try {
                    PacienteDAO dao = new PacienteDAO();
                    dao.Inserir(vo);
                } catch (Exception e) {
                    e.getMessage();
                }
            } 
    
    }

    public void Editar(AtendenteVO vo) {
        // TODO Auto-generated method stub
        
    }

    public void Excluir(AtendenteVO vo) {
        // TODO Auto-generated method stub
        
    }
}
