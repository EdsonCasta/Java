package com.edsoncasta.screenmatch.excepcion;

public class ErrorEnDuracionEnMinutosException extends RuntimeException {

    private String mensaje;

    public ErrorEnDuracionEnMinutosException(String mesaje  ) {
        this.mensaje = mesaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
