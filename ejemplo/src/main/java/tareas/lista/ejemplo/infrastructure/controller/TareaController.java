package tareas.lista.ejemplo.infrastructure.controller;

import org.springframework.web.bind.annotation.*;
import tareas.lista.ejemplo.application.TareaService;
import tareas.lista.ejemplo.domain.model.Tarea;
import tareas.lista.ejemplo.infrastructure.persistence.JsonTareaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController() {
        this.tareaService = new TareaService(new JsonTareaRepository());
    }

    @GetMapping
    public List<Tarea> listar() {
        return tareaService.listarTareas();
    }

    @GetMapping("/{id}")
    public Tarea buscar(@PathVariable String id) {
        return tareaService.buscarTarea(id);
    }

    @PostMapping
    public void crear(@RequestBody Tarea tarea) {
        tareaService.crearTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        tareaService.eliminarTarea(id);
    }
}
