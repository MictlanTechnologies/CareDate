package org.caredatedoc.caredate.jmjmdoc.model;

/**
 * Modelo de datos para representar un paciente del sistema.
 * Incluye validaciones básicas para cada campo requerido.
 */
public class Paciente {

    private Integer id;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String curp;
    private String fechaNac;
    private String email;
    private char sexo;

    /** Constructor vacío requerido por JDBC */
    public Paciente() {
    }

    /** Constructor completo con validaciones */
    public Paciente(String nombre, String aPaterno, String aMaterno, String curp,
                    String fechaNac, String email, char sexo) {
        this.setNombre(nombre);
        this.setaPaterno(aPaterno);
        this.setaMaterno(aMaterno);
        this.setCurp(curp);
        this.setFechaNac(fechaNac);
        this.setEmail(email);
        this.setSexo(sexo);
    }

    // ============ Getters ============

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public String getCurp() {
        return curp;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public char getSexo() {
        return sexo;
    }

    // ============ Setters ============

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public void setaPaterno(String aPaterno) {
        if (aPaterno == null || aPaterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido paterno no puede estar vacío.");
        }
        this.aPaterno = aPaterno.trim();
    }

    public void setaMaterno(String aMaterno) {
        if (aMaterno == null || aMaterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido materno no puede estar vacío.");
        }
        this.aMaterno = aMaterno.trim();
    }

    public void setCurp(String curp) {
        if (curp == null || !curp.matches("^[A-Z0-9]{18}$")) {
            throw new IllegalArgumentException("CURP inválida. Debe tener 18 caracteres alfanuméricos.");
        }
        this.curp = curp.trim().toUpperCase();
    }

    public void setFechaNac(String fechaNac) {
        if (fechaNac == null || fechaNac.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede estar vacía.");
        }
        this.fechaNac = fechaNac.trim();
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede estar vacío.");
        }
        this.email = email.trim().toLowerCase();
    }

    public void setSexo(char sexo) {
        if (sexo != 'M' && sexo != 'F') {
            throw new IllegalArgumentException("Sexo inválido. Debe ser 'M' o 'F'.");
        }
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", aPaterno='" + aPaterno + '\'' +
                ", aMaterno='" + aMaterno + '\'' +
                ", curp='" + curp + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", email='" + email + '\'' +
                ", sexo=" + sexo +
                '}';
    }
}