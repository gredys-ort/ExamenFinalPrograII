package com.Final.demo.modelos.e;

/**
 *
 * @author Gredys Morales
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "tb_usuarios")
public class Usuarios implements Serializable {
    @Id //Clave principal
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrementable
    @Column(name = "Id_usuario")
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Correo_electronico")
    private String correo;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Fecha_Nacimiento")
    private String nacimiento;
    @Column(name = "Latitud")
    private double latitud;
    @Column(name = "Longitud")
    private double longitud;
    @Column(name = "Fecha_registro")
    private Date registro;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_profesion")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @NonNull
    private Profesiones profesion;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_depto")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @NonNull
    private Departamentos departamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombe) {
        this.nombre = nombe;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    @NonNull
    public Profesiones getProfesion() {
        return profesion;
    }

    public void setProfesion(@NonNull Profesiones profesion) {
        this.profesion = profesion;
    }

    @NonNull
    public Departamentos getDepartamento() {
        return departamento;
    }

    public void setDepartamento(@NonNull Departamentos departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombe='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nacimiento=" + nacimiento +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", registro=" + registro +
                ", profesion=" + profesion +
                ", departamento=" + departamento +
                '}';
    }

    private static final long serialVersionUID = 1L;
}
