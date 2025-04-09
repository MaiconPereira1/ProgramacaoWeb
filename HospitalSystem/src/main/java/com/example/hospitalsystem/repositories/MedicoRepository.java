package com.example.hospitalsystem.repositories;

import com.example.hospitalsystem.domain.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {
    private List<Medico> medicos = new ArrayList<>();

    public void save(Medico medico) {
        medicos.add(medico);
    }

    public List<Medico> findAll() {
        return medicos;
    }

    public Medico findById(int id) {
        return medicos.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    public void update(Medico medico) {
        Medico existingMedico = findById(medico.getId());
        if (existingMedico != null) {
            existingMedico.setNome(medico.getNome());
            existingMedico.setTelefone(medico.getTelefone());
            existingMedico.setEndereco(medico.getEndereco());

        }
    }

    public void delete(int id) {
        Medico medico = findById(id);
        if (medico != null) {
            medico.setAtivo(false);
        }
    }
}
