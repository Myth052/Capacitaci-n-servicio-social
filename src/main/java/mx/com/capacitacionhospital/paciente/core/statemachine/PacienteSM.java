package mx.com.capacitacionhospital.paciente.core.statemachine;


import io.quarkus.runtime.Startup;
import lombok.Getter;
import mx.com.capacitacionhospital.util.statemachine.Action;
import mx.com.capacitacionhospital.util.statemachine.CustomStateMachine;
import mx.com.capacitacionhospital.util.statemachine.State;
import mx.com.capacitacionhospital.util.statemachine.StateMachineLoader;

import javax.inject.Singleton;

@Startup
@Singleton
@Getter
public class PacienteSM extends CustomStateMachine {
    private final State registrado;
    private final State activo;
    private final State inactivo;
    private final Action activar;
    private final Action eliminar;
    private final Action agendarCita;
    private final Action cancelarCita;

    public PacienteSM() {
        stateMachine = StateMachineLoader.load("paciente-sm.json").orElseThrow();

        registrado = stateMachine.getStates().get(0);
        activo = stateMachine.getStates().get(1);
        inactivo = stateMachine.getStates().get(2);
        activar = stateMachine.getActions().get(0);
        eliminar = stateMachine.getActions().get(1);
        agendarCita = stateMachine.getActions().get(2);
        cancelarCita = stateMachine.getActions().get(3);
    }
}
