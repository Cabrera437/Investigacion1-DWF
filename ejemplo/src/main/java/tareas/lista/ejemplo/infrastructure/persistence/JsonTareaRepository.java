package tareas.lista.ejemplo.infrastructure.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import tareas.lista.ejemplo.domain.model.Tarea;
import tareas.lista.ejemplo.domain.port.TareaRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonTareaRepository implements TareaRepository {
    private final File archivo = new File("src/main/java/tareas/lista/ejemplo/infrastructure/persistence/tareas.json");
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Tarea> listar() {
        try {
            if (!archivo.exists()) return new ArrayList<>();
            return mapper.readValue(archivo, new TypeReference<List<Tarea>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Tarea buscarPorId(String id) {
        return listar().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void guardar(Tarea tarea) {
        List<Tarea> tareas = listar();
        tareas.add(tarea);
        try {
            mapper.writeValue(archivo, tareas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        List<Tarea> tareas = listar();
        tareas.removeIf(t -> t.getId().equals(id));
        try {
            mapper.writeValue(archivo, tareas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
