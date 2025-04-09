package com.example.hospitalsystem.interfaces;

import com.example.hospitalsystem.dto.MedicoInsertRequestDTO;
import jakarta.jws.WebService;

import java.util.List;
@WebService
public interface MedicoWS {
    void addMedico(MedicoInsertRequestDTO medicoDTO);
    List<MedicoInsertRequestDTO> listMedicos();
    void updateMedico(MedicoInsertRequestDTO medicoDTO);
    void deleteMedico(int id);
}
