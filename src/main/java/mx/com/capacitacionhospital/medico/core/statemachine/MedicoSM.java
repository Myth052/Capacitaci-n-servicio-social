package mx.com.capacitacionhospital.medico.core.statemachine;

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
public class MedicoSM extends CustomStateMachine {
    private final State registrado;
    private final State activo;
    private final State inactivo;
    private final Action editar;
    private final Action eliminar;
    private final Action consultarHospitales;
    private final Action inactivar;
    private final Action activar;

    public MedicoSM() {
        stateMachine = StateMachineLoader.load("medico-sm.json").orElseThrow();
        registrado = stateMachine.getStates().get(0);
        activo = stateMachine.getStates().get(1);
        inactivo = stateMachine.getStates().get(2);

        editar = stateMachine.getActions().get(0);
        eliminar = stateMachine.getActions().get(1);
        consultarHospitales = stateMachine.getActions().get(2);
        inactivar = stateMachine.getActions().get(3);
        activar = stateMachine.getActions().get(4);
    }
}
