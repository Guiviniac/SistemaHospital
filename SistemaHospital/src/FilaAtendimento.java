import java.util.LinkedList;
import java.util.Queue;

public class FilaAtendimento {
    private Queue<Paciente> pacientes;

    public FilaAtendimento() {
        pacientes = new LinkedList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente atenderProximoPaciente() {
        return pacientes.poll();
    }

    public boolean isEmpty() {
        return pacientes.isEmpty();
    }

    public int getSize() {
        return pacientes.size();
    }
}
