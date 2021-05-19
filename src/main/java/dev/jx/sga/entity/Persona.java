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
    public String dni;

    @OneToMany(mappedBy = "persona")
    private List<Telefono> telefonos;

    @Column(name = "per_nombres", nullable = false)
    public String nombres;

    @Column(name = "per_apellido_pat", nullable = false)
    public String apellidoPaterno;

    @Column(name = "per_apellido_mat", nullable = false)
    public String apellidoMaterno;

    @Column(name = "per_genero", nullable = false)
    public String genero;

    @Column(name = "per_direccion", nullable = false)
    public String direccion;

    @Column(name = "per_correo")
    public String correo;

    @Column(name = "per_fec_reg", nullable = false)
    public LocalDate fechaRegistro;
}
