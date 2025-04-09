package com.example.hospitalsystem.services;

import com.example.hospitalsystem.domain.Consulta;
import com.example.hospitalsystem.domain.Medico;
import com.example.hospitalsystem.domain.Paciente;
import com.example.hospitalsystem.dto.ConsultaInsertRequestDTO;
import com.example.hospitalsystem.repositories.ConsultaRepository;
import com.example.hospitalsystem.repositories.MedicoRepository;
import com.example.hospitalsystem.repositories.PacienteRepository;

import java.util.List;

public class ConsultaService {
    private ConsultaRepository consultaRepository = new ConsultaRepository();
    private MedicoRepository medicoRepository = new MedicoRepository();
    private PacienteRepository pacienteRepository = new PacienteRepository();

    public void agendarConsulta(ConsultaInsertRequestDTO consultaDTO) {

        Paciente paciente = pacienteRepository.findById(consultaDTO.getPacienteId());
        Medico medico = medicoRepository.findById(consultaDTO.getMedicoId());

        if (paciente == null || !paciente.isAtivo()) {
            throw new RuntimeException("Paciente inativo ou não encontrado.");
        }
        if (medico == null || !medico.isAtivo()) {
            throw new RuntimeException("Médico inativo ou não encontrado.");
        }
        List<Consulta> consultas = consultaRepository.findAll();
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getId() == paciente.getId() && consulta.getDataHora().toLocalDate().equals(consultaDTO.getDataHora().toLocalDate())) {
                throw new RuntimeException("Paciente já possui consulta agendada para este dia.");
            }
            if (consulta.getMedico().getId() == medico.getId() && consulta.getDataHora().equals(consultaDTO.getDataHora())) {
                throw new RuntimeException("Médico já possui consulta agendada para este horário.");
            }
        }

        Consulta consulta = new Consulta();
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataHora(consultaDTO.getDataHora());
        consulta.setAtivo(true);
        consultaRepository.save(consulta);
    }

    public void cancelarConsulta(int consultaId, String motivoCancelamento) {
        Consulta consulta = consultaRepository.findById(consultaId);
        if (consulta == null || !consulta.isAtivo()) {
            throw new RuntimeException("Consulta não encontrada ou já cancelada.");
        }
        consulta.setAtivo(false);
        consultaRepository.update(consulta);
    }

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }
}
