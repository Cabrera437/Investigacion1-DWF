package tareas.lista.ejemplo.application;

import tareas.lista.ejemplo.domain.model.Tarea;
import tareas.lista.ejemplo.domain.port.TareaRepository;
import java.util.List;

public class TareaService {
    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> listarTareas() {
        return tareaRepository.listar();
    }

    public Tarea buscarTarea(String id) {
        return tareaRepository.buscarPorId(id);
    }

    public void crearTarea(Tarea tarea) {
        tareaRepository.guardar(tarea);
    }

    public void eliminarTarea(String id) {
        tareaRepository.eliminar(id);
    }
}
