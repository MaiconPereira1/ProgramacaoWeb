package com.example.hospitalsystem.services;

import com.example.hospitalsystem.domain.Paciente;
import com.example.hospitalsystem.dto.PacienteInsertRequestDTO;
import com.example.hospitalsystem.repositories.PacienteRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PacienteService {
    private PacienteRepository pacienteRepository = new PacienteRepository();

    public void cadastraPaciente(PacienteInsertRequestDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.getNome());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setEndereco(pacienteDTO.getEndereco());
        paciente.setAtivo(true);
        pacienteRepository.save(paciente);
    }

    public List<PacienteInsertRequestDTO> listaPacientes() {
        return pacienteRepository.findAll().stream()
                .filter(Paciente::isAtivo)
                .map(p -> {
                    PacienteInsertRequestDTO dto = new PacienteInsertRequestDTO();
                    dto.setNome(p.getNome());
                    dto.setEmail(p.getEmail());
                    dto.setTelefone(p.getTelefone());
                    dto.setCpf(p.getCpf());
                    dto.setEndereco(p.getEndereco());
                    return dto;
                })
                .sorted((p1, p2) -> p1.getNome().compareTo(p2.getNome()))
                .collect(Collectors.toList());
    }

    public void atualizaPaciente(PacienteInsertRequestDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteDTO.getId());
        paciente.setNome(pacienteDTO.getNome());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setEndereco(pacienteDTO.getEndereco());
        pacienteRepository.update(paciente);
    }

    public void excluiPaciente(int id) {
        pacienteRepository.delete(id);
    }
}
