package Model.VO;
/*
import java.util.*;

class principal {
	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);

		// criar um novo atendente
		String nomeAtendente, cpf;

		System.out.println("Digite o nome do atendente");
		nomeAtendente = leitura.nextLine();

		System.out.println("Digite o CPF do atendente(não inserir . e -)");
		cpf = leitura.nextLine();

		AtendenteVO atendente = new AtendenteVO(nomeAtendente, cpf);

		System.out.println("**********************************");

		System.out.println(
				"O nome do atendente é: " + atendente.getNome() + " e o CPF do mesmo é :" + atendente.getCpf());

		System.out.println("**********************************");
		// criar um gerente
		String nome = "Pedro Luís";
		Integer id = 0;

		GerenteVO gerente = new GerenteVO(nome, id++);

		System.out.println("**********************************");

		System.out.println("O gerente do sistema é " + gerente.getNome() + " e o seu ID é: " + gerente.getId());

		System.out.println("**********************************");

		// criar um novo médico ("00034595698", "9898241234", "Rua dos milagres, 234,
		// bairro palmeiras", "Laercio Calvacante Gomes", "400")
		String cpfMedico, crmMedico, enderecoMedico, nomeMedico, txtValorConsulta;
		System.out.println("Digite o nome do médico");
		nomeMedico = leitura.nextLine();
		System.out.println("Digite o endereço do médico");
		enderecoMedico = leitura.nextLine();
		System.out.println("Digite o CPF do médico");
		cpfMedico = leitura.nextLine();
		System.out.println("Digite o CRM do médico");
		crmMedico = leitura.nextLine();
		System.out.println("Digite o valor da consulta cobrado pelo médico");
		txtValorConsulta = leitura.nextLine();

		Double valorConsulta = Double.valueOf(txtValorConsulta).doubleValue();

		MedicoVO medico = new MedicoVO(nomeMedico, cpfMedico, enderecoMedico, valorConsulta, crmMedico);
		System.out.println("**********************************");

		System.out.println("O DR." + medico.getNome() + "  Mora no endereço " + medico.getEndereco()
				+ " tem o CPF de número " + medico.getCpf() + " o seu crm é " + medico.getCrm() + " e ele cobra"
				+ medico.getValorconsulta() + "R$");

		System.out.println("----------------------------------");

		// criar um novo paciente("67341034522","Rua do pão, 987, Bairro Padaria"
		// ,"Perisvaldo Souza Silva")
		String nomePaciente, cpfPaciente, enderecoPaciente;

		System.out.println("Digite o nome do paciente");
		nomePaciente = leitura.nextLine();
		System.out.println("Digite o endereço do paciente");
		enderecoPaciente = leitura.nextLine();
		System.out.println("Digite o CPF do paciente");
		cpfPaciente = leitura.nextLine();
		leitura.nextLine();
		System.out.println("**********************************");

		PacienteVO paciente = new PacienteVO(nomePaciente, cpfPaciente, enderecoPaciente);

		System.out.println("O paciente" + paciente.getNome() + "  Mora no endereço " + paciente.getEndereco()
				+ " tem o CPF de número " + paciente.getCpf());

		System.out.println("----------------------------------");

		// Criar um novo prontuario
		String dataNascimento, antenPatologico, historicoDoenca, idPaciente, mediAtuais, mediAlergia;
		Float peso, altura;
		Date data;

		System.out.println("Digite a data de nascimetno do paciente (dd/mm/aaaa)");
		dataNascimento = leitura.nextLine();
		System.out.println("o paciente tem algum historico de doença?");
		historicoDoenca = leitura.nextLine();
		System.out.println("A familia do paciente possui algum caso de doença Hereditaria");
		antenPatologico = leitura.nextLine();
		System.out.println("O paciente está tomando algum medicamente atualmente?");
		mediAtuais = leitura.nextLine();
		System.out.println("O paciente possui alergia a algum medicamento?");
		mediAlergia = leitura.nextLine();
		System.out.println("Qual o peso do paciente?");
		peso = leitura.nextFloat();
		System.out.println("Qual a altura do paciente?");
		altura = leitura.nextFloat();
		leitura.close();

		ProntuarioVO prontuario = new ProntuarioVO(dataNascimento, antenPatologico, mediAtuais, mediAlergia, peso,
				altura, historicoDoenca, cpfPaciente);

		System.out.println("**********************************");
		if (prontuario.getIdPaciente() == cpfPaciente) {
			Calendar dn = Calendar.getInstance();
			dn = prontuario.getDataNascimento();
			data = dn.getTime();
			Float imc = (prontuario.getPeso() / (prontuario.getAltura() * prontuario.getAltura())), idade;
			System.out.println("Paciente: " + paciente.getNome());
			System.out.println("Data de nascimento: " + data);
			System.out.println("Peso: " + prontuario.getPeso());
			System.out.println("Altura: " + prontuario.getAltura());
			System.out.println("IMC: " + imc);
			if (imc <= 18.5) {
				System.out.println("Grau do IMC : Magreza");
			} else if (imc > 18.5 && imc <= 24.9) {
				System.out.println("Grau do IMC : Normal");
			} else if (imc > 24.9 && imc <= 29.9) {
				System.out.println("Grau do IMC : Sobrepeso");
			} else if (imc > 29.9 && imc <= 39.9) {
				System.out.println("Grau do IMC : Obesidade");
			} else if (imc > 39.9) {
				System.out.println("Grau do IMC : Obesidade Grave");
			}
			System.out.println("Medicamentos atuais: " + prontuario.getMediAtuais());
			System.out.println("Medicamentos Alergicos: " + prontuario.getMediAlergia());
			System.out.println("Historico de doenças na familia: " + prontuario.getAntenPatologico());
			System.out.println("Historico de doenças: " + prontuario.getHistoricoDoenca());
		}

		System.out.println("----------------------------------");

		/*
		 * //criar um novo prontuario prontuario = new Prontuario("Rivotril",
		 * "Paciente sofreu um acidente de moto e quebrou o nariz"); //criar um novo
		 * usuário user = new UsuarioVO("PedrinhoGerente", "senhadopedrinho");
		 */

	