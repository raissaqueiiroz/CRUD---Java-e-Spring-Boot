package med.voll.api.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DataEndereco;


public record DataPutMedico (
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        Especialidade especialidade,
        DataEndereco endereco
){}