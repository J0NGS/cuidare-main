package Model.VO;

public class AtendenteVO extends UsuarioVO {
    private Long idAtendente;

    public AtendenteVO(String nome, String cpf, String login, String senha) {
        super(nome, cpf, login, senha, 1);
    }


    public AtendenteVO() {
    }


    public Long getIdAtendente() {
        return this.idAtendente;
    }

    public void setIdAtendente(Long idAtendente) {
        this.idAtendente = idAtendente;
    }

}
