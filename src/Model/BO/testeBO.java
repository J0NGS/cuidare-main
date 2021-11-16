package Model.BO;

import Model.Exception.InsertException;
import Model.VO.PacienteVO;

public class testeBO {
    public static void main(String[] args) {
        PacienteVO vo  = new PacienteVO("", "34592308476", "Argentina");
        AtendenteBO bo = new AtendenteBO();
        PacienteVO vo2 = new PacienteVO();
        try {
            bo.CadastrarPaciente(vo);
        } catch (InsertException e) {
            System.out.println(e.getMessage());
        }
    }
}
