public class Main {
    public static void main(String[] args) {
        GestaoHospital gestaoHospital = new GestaoHospital();

        gestaoHospital.adicionarPaciente();
        gestaoHospital.adicionarPaciente();
        gestaoHospital.adicionarPaciente();

        System.out.println("Número de pacientes na fila: " + gestaoHospital.getNumeroPacientesNaFila());

        gestaoHospital.atenderProximoPaciente();
        gestaoHospital.atenderProximoPaciente();
        gestaoHospital.atenderProximoPaciente();
        gestaoHospital.atenderProximoPaciente();
        gestaoHospital.atenderProximoPaciente();
        gestaoHospital.atenderProximoPaciente();
        gestaoHospital.atenderProximoPaciente();

        System.out.println("Número de pacientes na fila: " + gestaoHospital.getNumeroPacientesNaFila());
    }
}
