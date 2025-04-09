package com.example.hospitalsystem.interfaces;

import com.example.hospitalsystem.domain.Consulta;
import com.example.hospitalsystem.dto.ConsultaInsertRequestDTO;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface ConsultaWS {
    void addConsulta(ConsultaInsertRequestDTO consultaDTO);
    List<Consulta> listConsultas();
    void cancelConsulta(int consultaId, String motivoCancelamento);
}
