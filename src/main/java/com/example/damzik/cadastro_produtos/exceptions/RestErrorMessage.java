package com.example.damzik.cadastro_produtos.exceptions;

import java.time.LocalDateTime;

public class RestErrorMessage {

    private String message;
    private int status;

    //@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd/MM/yyy HH:mm:ss")
    private LocalDateTime timestamp;

    public RestErrorMessage(String message, int status, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
