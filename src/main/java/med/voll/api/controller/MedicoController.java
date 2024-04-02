package med.voll.api.controller;

import med.voll.api.medico.DadosMedico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @PostMapping
    public void cadastrar(@RequestBody DadosMedico medico){
        System.out.println(medico);
    }
}
