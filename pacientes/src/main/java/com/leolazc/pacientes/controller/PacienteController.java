
package com.leolazc.pacientes.controller;

import com.leolazc.pacientes.model.Paciente;
import com.leolazc.pacientes.service.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private IPacienteService pacienteServ;
    
    @PostMapping ("/crear")
    
    public String crearCurso(@RequestBody Paciente pac){
    pacienteServ.savePaciente(pac);
    return "Paciente creado correctamente.";
    }
    
    
    @GetMapping("/traer")
    public List<Paciente> traerPacientes(){
     return pacienteServ.getPacientes();
    }
    
    
    @DeleteMapping("/borrar/{id}")
    public String deletePaciente(@PathVariable Long id){
        pacienteServ.deletePaciente(id);
        return "El paciente fue eliminado.";
    }
    
    @PutMapping("/editar/{id_original}")
    public Paciente editPaciente(@PathVariable Long id_original,
                                 @RequestBody Paciente pacienteEditar) {
        pacienteServ.editPaciente(id_original , pacienteEditar);
        Paciente pacienteEditado = pacienteServ.findPaciente(id_original);
        return pacienteEditado;
    }
    
    @GetMapping("/traer/{id}")
    public Paciente traerPaciente(@PathVariable Long id){
        return pacienteServ.findPaciente(id);
    }
    
    
    @GetMapping("/traerdni/{dni}")
    public Paciente traerPacienteDni(@PathVariable String dni){
        return pacienteServ.findPacienteDni(dni);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
