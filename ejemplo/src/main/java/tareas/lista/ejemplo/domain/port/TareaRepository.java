package tareas.lista.ejemplo.domain.port;

import tareas.lista.ejemplo.domain.model.Tarea;
import java.util.List;

public interface TareaRepository {
    List<Tarea> listar();
    Tarea buscarPorId(String id);
    void guardar(Tarea tarea);
    void eliminar(String id);
}
