class Consulta {
    private Paciente paciente;
    private Atendente atendente;
    private Medico medico;
    private String data;
    private String horario;
    
    public Consulta(Paciente paciente, Atendente atendente, Medico medico, String data, String horario) {
        this.paciente = paciente;
        this.atendente = atendente;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
    }
    
    public Paciente getPaciente() { return paciente; }
    public Atendente getAtendente() { return atendente; }
    public Medico getMedico() { return medico; }
    public String getData() { return data; }
    public String getHorario() { return horario; }
}