package com.vacantesupb.empresa.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tbl_vacantes")
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "detalle", columnDefinition = "TEXT", nullable = false)
    private String detalle;

    @Column(name = "salario", nullable = false)
    private Float salario;

    @Column(name = "remoto")
    private boolean remoto;

    @Column(name = "fecha_publicacion", nullable = false)
    private Timestamp fecha_publicacion;

    @Column(name = "fecha_cierre", nullable = true)
    private Timestamp fecha_cierre;

    @ManyToOne
    private Empresa empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public boolean isRemoto() {
        return remoto;
    }

    public void setRemoto(boolean remoto) {
        this.remoto = remoto;
    }

    public Timestamp getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Timestamp fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public Timestamp getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(Timestamp fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Vacante() {
    }

    public Vacante(long id, String titulo, String detalle, Float salario, boolean remoto, Timestamp fecha_publicacion, Timestamp fecha_cierre, Empresa empresa) {
        this.id = id;
        this.titulo = titulo;
        this.detalle = detalle;
        this.salario = salario;
        this.remoto = remoto;
        this.fecha_publicacion = fecha_publicacion;
        this.fecha_cierre = fecha_cierre;
        this.empresa = empresa;
    }
}
