package com.esther.DesafioSpring.controller;

import com.esther.DesafioSpring.domain.dtos.InicialDTO;
import com.esther.DesafioSpring.model.Inicial;
import com.esther.DesafioSpring.services.EmailSenderService;
import com.esther.DesafioSpring.services.InicialService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inicial")
@Slf4j
@AllArgsConstructor
public class InicialController {


    public InicialService service;

    public InicialService getService() {
        return service;
    }

    @Autowired
    private EmailSenderService senderService;

    @GetMapping("/findAll")
    public ResponseEntity<List<InicialDTO>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    @GetMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestParam Long id) {
        return ResponseEntity.ok(getService().delete(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<InicialDTO> salvar(@RequestBody Inicial inicial) {
        return ResponseEntity.ok(getService().salvar(inicial));
    }

    @RequestMapping("/resetar")
    public ResponseEntity<InicialDTO> resetar(@RequestParam Long id) {
        return ResponseEntity.ok(getService().resetar(id));
    }

    @RequestMapping("/entrar")
    public ResponseEntity<InicialDTO> entrar(@RequestParam String email,
                                             @RequestParam String password) {
        return ResponseEntity.ok(getService().entrar(email, password));
    }


}