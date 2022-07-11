package com.example.ThinCrustPizza.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    

}
