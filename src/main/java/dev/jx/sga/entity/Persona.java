package dev.jx.sga.entity;

import java.util.List;
import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @Column(name = "per_dni")
    private String dni;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.PERSIST)
    private Usuario usuario;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.PERSIST)
    private List<Telefono> telefonos;

    @Column(name = "per_nombres", nullable = false)
    private String nombres;

    @Column(name = "per_apellido_pat", nullable = false)
    private String apellidoPaterno;

    @Column(name = "per_apellido_mat", nullable = false)
    private String apellidoMaterno;

    @Column(name = "per_genero", nullable = false)
    private String genero;

    @Column(name = "per_direccion", nullable = false)
    private String direccion;

    @Column(name = "per_correo")
    private String correo;

    @Column(name = "per_fec_reg", nullable = false)
    private LocalDate fechaRegistro;

    public Persona() {
    }

    public String getNombreCompleto() {
        return String.format("%s %s %s", nombres, apellidoPaterno, apellidoMaterno).trim();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
