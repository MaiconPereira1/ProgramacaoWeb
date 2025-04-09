package com.example.hospitalsystem;

import com.example.hospitalsystem.dto.PacienteInsertRequestDTO;
import com.example.hospitalsystem.interfaces.PacienteWS;
import com.example.hospitalsystem.services.PacienteService;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class PacienteWSimp implements PacienteWS {
    private PacienteService pacienteService = new PacienteService();

    @Override
    public void addPaciente(PacienteInsertRequestDTO pacienteDTO) {
        pacienteService.cadastraPaciente(pacienteDTO);
    }

    @Override
    public List<PacienteInsertRequestDTO> listPacientes() {
        return pacienteService.listaPacientes();
    }

    @Override
    public void updatePaciente(PacienteInsertRequestDTO pacienteDTO) {
        pacienteService.atualizaPaciente(pacienteDTO);
    }

    @Override
    public void deletePaciente(int id) {
        pacienteService.excluiPaciente(id);
    }
}
