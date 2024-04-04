package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Table(name = "medicos")
@Entity(name = "Medico")
@Data
@NoArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Medico(DadosCadastroMedico medico) {
        this.nome = medico.nome();
        this.email = medico.email();
        this.telefone = medico.telefone();
        this.crm = medico.crm();
        this.especialidade = medico.especialidade();
        this.endereco = new Endereco(medico.endereco());
        this.ativo = true;
    }
   public void atualizaInformacoes(DadosAtualizacaoMedico medico) {
       Optional.ofNullable(medico.nome()).ifPresent(this::setNome);
         Optional.ofNullable(medico.telefone()).ifPresent(this::setTelefone);
            Optional.ofNullable(medico.endereco()).ifPresent(this.endereco::atualizaInformacoes);
    }

    public void excluir() {
        this.ativo = false;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
