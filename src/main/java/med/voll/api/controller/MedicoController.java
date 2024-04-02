package med.voll.api.controller;

import med.voll.api.medico.DadosMedico;
import med.voll.api.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoRepository repository;

    public MedicoController(MedicoRepository repository){
        this.repository = repository;
    }
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosMedico medico){
        repository.save(new Medico(medico));
    }
}
