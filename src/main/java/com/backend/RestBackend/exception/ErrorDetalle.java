package com.backend.RestBackend.exception;

import java.util.Date;

public class ErrorDetalle {

    private Date timestamp;
    private String mensaje;
    private String detalle;

    public ErrorDetalle(Date timestamp, String mensaje, String detalle){
        super();
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.detalle = detalle;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
