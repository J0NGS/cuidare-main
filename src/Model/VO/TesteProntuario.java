/*package Model.VO;
import java.text.DateFormat;
import java.util.*;
class TesteProntuario {
	public static void main(String[] args){
        Scanner leitura = new Scanner(System.in);
        String dataNascimento, antenPatologico, historicoDoenca, mediAtuais, mediAlergia, cpfPaciente = "00345693499";
		Float peso, altura;
		Date data;
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

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
            Float imc = (prontuario.getPeso() / (prontuario.getAltura() * prontuario.getAltura()));
        
            
			//calculando a idade
			Calendar dn = Calendar.getInstance();
			dn = prontuario.getDataNascimento();
			data = dn.getTime();
			int idade;
			Calendar hoje = Calendar.getInstance();
            dn.set(Calendar.YEAR, hoje.get(Calendar.YEAR));
            idade = dn.after(hoje) ? -1 : 0;
            dn.setTime(data);
            idade += hoje.get(Calendar.YEAR) - dn.get(Calendar.YEAR);

			System.out.println("Paciente: Perisvaldo Tucano");
			System.out.println("Data de nascimento: " + df.format(data) + "(" + idade + " anos )");
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
    }
}*/
