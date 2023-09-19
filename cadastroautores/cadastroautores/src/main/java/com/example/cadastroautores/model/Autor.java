package com.example.cadastroautores.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@Entity
@Getter
@Setter
public class Autor {
    @Id
    private String edicao;
    private String editora;
    private int colecao;
    private String ano;


    @ManyToOne
    private Livro livro;


    @ManyToOne
    private Genero genero;
}

