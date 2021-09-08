package com.capgemini.market.persistence.mapper;

import com.capgemini.market.domain.Client;
import com.capgemini.market.domain.Product;
import com.capgemini.market.persistence.entity.Cliente;
import com.capgemini.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseMapper.class})
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "id", target = "clientId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "celular", target = "cellPhone"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "correoElectronico", target = "email"),
            @Mapping(source = "compras",target = "purchases")
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente(Client client);

}