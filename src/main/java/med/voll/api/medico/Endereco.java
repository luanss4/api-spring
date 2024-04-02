package med.voll.api.medico;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.DadosEndereco;

import java.util.Optional;

@Embeddable
@Data
@NoArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizaInformacoes(DadosEndereco dadosEndereco) {
        Optional.ofNullable(dadosEndereco.logradouro()).ifPresent(this::setLogradouro);
        Optional.ofNullable(dadosEndereco.bairro()).ifPresent(this::setBairro);
        Optional.ofNullable(dadosEndereco.cep()).ifPresent(this::setCep);
        Optional.ofNullable(dadosEndereco.numero()).ifPresent(this::setNumero);
        Optional.ofNullable(dadosEndereco.complemento()).ifPresent(this::setComplemento);
        Optional.ofNullable(dadosEndereco.cidade()).ifPresent(this::setCidade);
        Optional.ofNullable(dadosEndereco.uf()).ifPresent(this::setUf);
    }
}
