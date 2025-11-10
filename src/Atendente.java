public class Atendente extends Funcionario {
    public Atendente(String nome, String cpf, String matricula) {
        super(nome, cpf, matricula);
    }

    @Override
    public String toString() {
        return "Atendente - " + super.toString();
    }
}