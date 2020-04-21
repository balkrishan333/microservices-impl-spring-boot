package com.nagpal.webservices.rest.helloworld;

public class HelloWorldBean {

    private String _message;

    public HelloWorldBean(String message) {
        _message = message;
    }

    public void setMessage(String message) {
        _message = message;
    }

    public String getMessage() {
        return _message;
    }
}
