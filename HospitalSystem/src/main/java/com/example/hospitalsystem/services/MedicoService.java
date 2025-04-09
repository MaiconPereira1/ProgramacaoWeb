package com.example.hospitalsystem.services;

import com.example.hospitalsystem.domain.Medico;
import com.example.hospitalsystem.dto.MedicoInsertRequestDTO;
import com.example.hospitalsystem.repositories.MedicoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MedicoService {
    private MedicoRepository medicoRepository = new MedicoRepository();

    public void cadastraMedico(MedicoInsertRequestDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setNome(medicoDTO.getNome());
        medico.setEmail(medicoDTO.getEmail());
        medico.setTelefone(medicoDTO.getTelefone());
        medico.setCrm(medicoDTO.getCrm());
        medico.setEspecialidade(medicoDTO.getEspecialidade());
        medico.setEndereco(medicoDTO.getEndereco());
        medico.setAtivo(true);
        medicoRepository.save(medico);
    }

    public List<MedicoInsertRequestDTO> listaMedicos() {
        return medicoRepository.findAll().stream()
                .filter(Medico::isAtivo)
                .map(m -> {
                    MedicoInsertRequestDTO dto = new MedicoInsertRequestDTO();
                    dto.setNome(m.getNome());
                    dto.setEmail(m.getEmail());
                    dto.setTelefone(m.getTelefone());
                    dto.setCrm(m.getCrm());
                    dto.setEspecialidade(m.getEspecialidade());
                    dto.setEndereco(m.getEndereco());
                    return dto;
                })
                .sorted((m1, m2) -> m1.getNome().compareTo(m2.getNome()))
                .collect(Collectors.toList());
    }

    public void atualizaMedico(MedicoInsertRequestDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setId(medicoDTO.getId());
        medico.setNome(medicoDTO.getNome());
        medico.setTelefone(medicoDTO.getTelefone());
        medico.setEndereco(medicoDTO.getEndereco());
        medicoRepository.update(medico);
    }

    public void excluiMedico(int id) {
        medicoRepository.delete(id);
    }
}
