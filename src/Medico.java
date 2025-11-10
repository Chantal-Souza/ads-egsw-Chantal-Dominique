public class Medico extends Funcionario {
    private String especialidade;
    private String crm;

    public Medico(String nome, String cpf, String matricula, String especialidade, String crm) {
        super(nome, cpf, matricula);
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    @Override
    public String toString() {
        return "Médico - " + super.toString() +
               " | Especialidade: " + especialidade +
               " | CRM: " + crm;
    }
}