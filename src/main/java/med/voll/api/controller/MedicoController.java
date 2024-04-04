package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import med.voll.api.repository.MedicoRepository;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoRepository repository;

    public MedicoController(MedicoRepository repository, GenericConverter converter){
        this.repository = repository;
    }
    // retorno 201 pro cadastro
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico medico, UriComponentsBuilder uriBuilder){
        Medico saved = repository.save(new Medico(medico));
        URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(saved));
    }
    // 200 pra listagem
    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        Pageable sortedById = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id"));
        Page<DadosListagemMedico> page = repository.findByAtivoTrueOrderById(sortedById).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }
    // 200 pra atualizacao
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(id);
        medico.atualizaInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
    // 204 pra exclusao
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }
    // 200 pra detalhamento
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoMedico> detalhar(@PathVariable Long id){
        var medico = repository.findById(id).orElseThrow();
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}
