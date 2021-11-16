package Model.VO;

public class LaudoVO {
    private Long idMedico;
    private Long idPaciente;
    private Long idConsulta;
    private Long idLaudo;    
    private String Observacoes;


    public LaudoVO(String Observacoes) {
        this.Observacoes = Observacoes;
    }

    public LaudoVO() {
    }


    public String getObservacoes() {
        return this.Observacoes;
    }

    public void setObservacoes(String Observacoes) {

        if (Observacoes == null) {
            System.out.println("Erro. Campo de Observações não preenchido");
        } else if (Observacoes.equals("")) {
            System.out.println("Erro. Campo de Observações vazio");
        } else
            this.Observacoes = Observacoes;
    }


    public Long getIdMedico() {
        return this.idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdPaciente() {
        return this.idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdConsulta() {
        return this.idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Long getIdLaudo() {
        return this.idLaudo;
    }

    public void setIdLaudo(Long idLaudo) {
        this.idLaudo = idLaudo;
    }



}
