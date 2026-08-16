package com.mycompany.cruisebook_project.chain;

public class Incidente {
    private final String id;
    private final String descripcion;
    private final TipoIncidente tipo;
    private EstadoIncidente estado; // Primitive Obsession curado

    public Incidente(String id, String descripcion, TipoIncidente tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = EstadoIncidente.ABIERTO;
    }

    public void marcarResuelto() {
        this.estado = EstadoIncidente.RESUELTO;
    }

    public String getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public TipoIncidente getTipo() { return tipo; }
    
    public boolean isResuelto() { 
        return this.estado == EstadoIncidente.RESUELTO; 
    }
}
