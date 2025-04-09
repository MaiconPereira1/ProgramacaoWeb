package com.example.hospitalsystem;

import com.example.hospitalsystem.domain.Consulta;
import com.example.hospitalsystem.dto.ConsultaInsertRequestDTO;
import com.example.hospitalsystem.interfaces.ConsultaWS;
import com.example.hospitalsystem.services.ConsultaService;
import jakarta.jws.WebService;
import java.util.List;



@WebService
public class ConsultaWSimp implements ConsultaWS {
    private ConsultaService consultaService = new ConsultaService();

    @Override
    public void addConsulta(ConsultaInsertRequestDTO consultaDTO) {
        consultaService.agendarConsulta(consultaDTO);
    }

    @Override
    public List<Consulta> listConsultas() {
        return consultaService.listarConsultas();
    }

    @Override
    public void cancelConsulta(int consultaId, String motivoCancelamento) {
        consultaService.cancelarConsulta(consultaId, motivoCancelamento);
    }
}