package com.capgemini.market.web.controller;

import com.capgemini.market.domain.Client;
import com.capgemini.market.domain.Product;
import com.capgemini.market.domain.service.ClientService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //controlador de API REST
@RequestMapping("/api/clients") //Path donde aceptara peticiones
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/client/{id}")
    public Optional<Client> getClientbyId(@PathVariable("id") String clientId){
        return clientService.getClientById(clientId);
    }

    @PostMapping("/save")
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String clientId){
        return clientService.delete(clientId);
    }

   /* @PutMapping("/update/{id}/{name}")
    public ResponseEntity<Client> updateClient(@PathVariable("name") String name, @PathVariable("id") String Client){
        return new ResponseEntity<>(clientService)
    }
    */

}
