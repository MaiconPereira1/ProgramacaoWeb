package com.example.hospitalsystem.repositories;

import com.example.hospitalsystem.domain.Consulta;
import java.util.ArrayList;
import java.util.List;

public class ConsultaRepository {
    private List<Consulta> consultas = new ArrayList<>();

    public void save(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> findAll() {
        return consultas;
    }

    public Consulta findById(int id) {
        return consultas.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void update(Consulta consulta) {
        Consulta existingConsulta = findById(consulta.getId());
        if (existingConsulta != null) {
            existingConsulta.setMedico(consulta.getMedico());
            existingConsulta.setPaciente(consulta.getPaciente());
            existingConsulta.setDataHora(consulta.getDataHora());
        }
    }

    public void delete(int id) {
        Consulta consulta = findById(id);
        if (consulta != null) {
            consulta.setAtivo(false);
        }
    }
}
