package com.example.hospitalsystem;

import com.example.hospitalsystem.dto.MedicoInsertRequestDTO;
import com.example.hospitalsystem.interfaces.MedicoWS;
import com.example.hospitalsystem.services.MedicoService;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class MedicoWSimp implements MedicoWS {
    private MedicoService medicoService = new MedicoService();

    @Override
    public void addMedico(MedicoInsertRequestDTO medicoDTO) {
        if (medicoDTO == null) {
            throw new IllegalArgumentException("Dados do médico não podem ser nulos.");
        }
        medicoService.cadastraMedico(medicoDTO);
    }
    @Override
    public List<MedicoInsertRequestDTO> listMedicos() {
        return medicoService.listaMedicos();
    }

    @Override
    public void updateMedico(MedicoInsertRequestDTO medicoDTO) {
        if (medicoDTO == null || medicoDTO.getId() <= 0) {
            throw new IllegalArgumentException("Dados do médico não podem ser nulos e o ID deve ser válido.");
        }
        medicoService.atualizaMedico(medicoDTO);
    }

    @Override
    public void deleteMedico(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID do médico deve ser válido.");
        }
        medicoService.excluiMedico(id);
    }

}