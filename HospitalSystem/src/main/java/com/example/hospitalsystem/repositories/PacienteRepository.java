package com.example.hospitalsystem.repositories;

import com.example.hospitalsystem.domain.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {
    private List<Paciente> pacientes = new ArrayList<>();

    public void save(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Paciente> findAll() {
        return pacientes;
    }

    public Paciente findById(int id) {
        return pacientes.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void update(Paciente paciente) {
        Paciente existingPaciente = findById(paciente.getId());
        if (existingPaciente != null) {
            existingPaciente.setNome(paciente.getNome());
            existingPaciente.setTelefone(paciente.getTelefone());
            existingPaciente.setEndereco(paciente.getEndereco());

        }
    }

    public void delete(int id) {
        Paciente paciente = findById(id);
        if (paciente != null) {
            paciente.setAtivo(false);
        }
    }
}
