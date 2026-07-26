package com.mycompany.cruisebook_project.chain;

public class Incidente {
    private String id;
    private String descripcion;
    private TipoIncidente tipo;
    private boolean resuelto;

    public Incidente(String id, String descripcion, TipoIncidente tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.resuelto = false; // Por defecto inicia sin resolver
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public TipoIncidente getTipo() { return tipo; }
    public void setTipo(TipoIncidente tipo) { this.tipo = tipo; }

    public boolean isResuelto() { return resuelto; }
    public void setResuelto(boolean resuelto) { this.resuelto = resuelto; }
}