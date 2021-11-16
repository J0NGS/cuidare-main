package Model.VO;

public abstract class PessoaVO {
    private String nome;
    private String cpf;
    private Long id;

    public PessoaVO() {
    }

    public PessoaVO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() != 11) {
            System.out.println("Cpf inválido (não digite pontos e nem linhas)");
        }
        if (cpf.matches("[0-9]*") == false) {
            System.out.println("Cpf inválido (existe letras no cpf)");
        } else {
            this.cpf = cpf;
        }
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        if(nome == null){
            System.out.println("Preencha o campo de nome");
        } else if (nome.equals("")){
            System.out.println("Nome em branco");
        } else 
            this.nome = nome;
    }

    public Long getIdPessoa(){
        return this.id;
    }

    public void setIdPessoa(Long idPessoa){
        this.id = idPessoa;
        System.out.println("id pessoa : " + this.id);
    }
}
