package Model.VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsultaVO {
    private Long idConsulta, idMedico, idPaciente;
    private Boolean status;
    private Calendar dataConsulta = Calendar.getInstance();




    public ConsultaVO(Long idMedico, Long idPaciente, Boolean status, String dataConsulta) {
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.status = status;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            this.dataConsulta.setTime(formato.parse(dataConsulta));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public ConsultaVO() {
    }



    public void setDataConsulta( String dConsulta) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.dataConsulta.setTime(formato.parse(dConsulta));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Calendar getDataConsulta(){
        return this.dataConsulta;
    }



    public Long getIdConsulta() {
        return this.idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }


    public Boolean isStatus() {
        return this.status;
    }

    public void setStatus(Boolean Status) {
        this.status = Status;
    }

    public Long getIdMedico() {
        return this.idMedico;
    }

    public void setIdMedico(Long IdMedico) {

        if (IdMedico == null) {
            System.out.println("Erro. Campo de medico não preenchido");
        } else if (IdMedico.equals("")) {
            System.out.println("Erro. Campo de Medico vazio");
        } else
            this.idMedico = IdMedico;
    }

    public Long getIdPaciente() {
        return this.idPaciente;
    }

    public void setIdPaciente(Long IdPaciente) {

        if (IdPaciente == null) {
            System.out.println("Erro. Campo de Paciente não preenchido");
        } else if (IdPaciente.equals("")) {
            System.out.println("Erro. Campo de Paciente vazio");
        } else
            this.idPaciente = IdPaciente;
    }

    public Boolean getStatus() {
        return this.status;
    }


}
