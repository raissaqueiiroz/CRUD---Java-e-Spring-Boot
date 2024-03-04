package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DataMedico;
import med.voll.api.medico.DataPutMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos") //Rota
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping //Tipo Método
    @Transactional // Transação ativa - para métodos de escrita
    public void Cadastrar(@RequestBody @Valid DataMedico data) {

        repository.save(new Medico(data));
    }

    @GetMapping
    public List<Medico> GetAll() {

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Medico> GetById(@PathVariable Long id) {

        return repository.findById(id);
    }

    @PutMapping
    @Transactional
    public void PutById(@RequestBody @Valid DataPutMedico dataPutMedico) {

        var medico =  repository.getReferenceById(dataPutMedico.id());
        medico.updateMedico(dataPutMedico);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Long id) {

        repository.deleteById(id);
    }
}
