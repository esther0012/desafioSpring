package com.esther.DesafioSpring.domain.conversor;

import com.esther.DesafioSpring.domain.dtos.InicialDTO;
import com.esther.DesafioSpring.model.Inicial;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

@RequiredArgsConstructor
public class ConverterEntidade {

    private final ModelMapper mapper = new ModelMapper();


    public InicialDTO toDto(Inicial entidade){
        return mapper.map(entidade, InicialDTO.class);
    }
}
