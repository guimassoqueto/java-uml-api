package com.guimassoqueto.storeapi.storeapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guimassoqueto.storeapi.storeapi.domain.Cliente;
import com.guimassoqueto.storeapi.storeapi.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
  
  @Autowired
  private ClienteService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> find(@PathVariable Integer id) {
    Cliente cli = service.buscar(id);
    return ResponseEntity.ok().body(cli);
  }
}