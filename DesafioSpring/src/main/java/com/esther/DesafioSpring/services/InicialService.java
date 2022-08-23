package com.esther.DesafioSpring.services;

import com.esther.DesafioSpring.domain.conversor.ConverterEntidade;
import com.esther.DesafioSpring.domain.dtos.InicialDTO;
import com.esther.DesafioSpring.model.Inicial;
import com.esther.DesafioSpring.repository.InicialRepository;
import com.esther.DesafioSpring.util.Criptografia;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InicialService {

    private final InicialRepository inicialRepository;

    private final ConverterEntidade converterEntidade = new ConverterEntidade();

    @Autowired
    private final EmailSenderService emailSenderService;

    public InicialRepository getInicialRepository() {
        return inicialRepository;
    }

    public Inicial findById(Long Id) {
        Optional<Inicial> inicial = inicialRepository.findById(Id);
        return inicial.orElse(null);
    }


    public List<InicialDTO> findAll() {
        List<InicialDTO> retorno = new ArrayList<>();
        List<Inicial> lista = getInicialRepository().findAll();

        lista.forEach(t -> {
            InicialDTO dto = converterEntidade.toDto(t);
            dto.setDescPermissao();
            retorno.add(dto);
        });
        return retorno;
    }

    public Boolean delete(Long id) {
        try {
            getInicialRepository().deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public InicialDTO salvar(Inicial inicial) {
        Criptografia criptografia = new Criptografia();
        inicial.setPassword(criptografia.encriptar(inicial.getPassword()));
        InicialDTO email = converterEntidade.toDto(getInicialRepository().save(inicial));
        String url = "http://localhost:4200/login?DjncdNSnfdsA=" + criptografia.encriptar(email.getEmail());
        emailSenderService.sendSimpleEmail(email.getEmail(), "Registro efetuado com sucesso!", url);
        return email;

    }

    public InicialDTO resetar(Long Id) {

        Criptografia criptografia = new Criptografia();

        Inicial inicial = findById(Id);
        inicial.setPassword(criptografia.encriptar("12345678"));
        return converterEntidade.toDto(inicialRepository.save(inicial));

    }


    public InicialDTO entrar(String email, String password) {
        Criptografia criptografia = new Criptografia();
        InicialDTO retorno;

        try {
            password = criptografia.encriptar(password);
            retorno = converterEntidade.toDto(inicialRepository.findByEmailAndPassword(email, password));
            return retorno;
        } catch (Exception e) {
            return new InicialDTO();
        }
    }
}
