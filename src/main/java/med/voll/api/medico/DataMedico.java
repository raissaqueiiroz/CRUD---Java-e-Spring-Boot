package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.endereco.DataEndereco;

public record DataMedico(
        @NotBlank //String não pode ser vazia ou nula.
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull //Campo diferente de string
        Especialidade especialidade,
        @NotNull @Valid
        DataEndereco endereco) {
}
