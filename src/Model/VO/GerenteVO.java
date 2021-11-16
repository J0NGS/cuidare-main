package Model.VO;

public class GerenteVO extends UsuarioVO {
    Long idGerente;
    public GerenteVO(String nome, String cpf, String login, String senha) {
        super(nome, cpf, login, senha, 3);
    }

    public GerenteVO() {
    }

    public Long getIdGerente() {
        return this.idGerente;
    }

    public void setIdGerente(Long idgerente){
        this.idGerente = idgerente;
    }
}
