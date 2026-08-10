package com.mycompany.cruisebook_project.chain;

public class Incidente {
    private final String id;
    private final String descripcion;
    private final TipoIncidente tipo;
    private boolean resuelto;

    public Incidente(String id, String descripcion, TipoIncidente tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.resuelto = false;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoIncidente getTipo() {
        return tipo;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    public void marcarResuelto() {
        this.resuelto = true;
    }
}
