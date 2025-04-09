package com.example.hospitalsystem.interfaces;

import com.example.hospitalsystem.dto.PacienteInsertRequestDTO;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface PacienteWS {
    void addPaciente(PacienteInsertRequestDTO pacienteDTO);
    List<PacienteInsertRequestDTO>listPacientes();
    void updatePaciente(PacienteInsertRequestDTO pacienteDTO);
    void deletePaciente(int id);

}
