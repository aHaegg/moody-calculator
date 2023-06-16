package se.andreas.calc.model;

import java.util.ArrayList;
import java.util.List;

public class CalcRes {

    private final String query;

    private Integer result;
    private List<Message> messages;
    private Boolean prime;
    private Boolean fibonacci;

    public CalcRes(String query, Message message) {
        this.query = query;
        getMessages().add(message);
    }

    public CalcRes(String query, int result) {
        this.query = query;
        this.result = result;
    }

    public String getQuery() {
        return query;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public List<Message> getMessages() {
        if(messages == null) {
            messages = new ArrayList<>();
        }
        return messages;
    }

    public void setPrime(Boolean prime) {
        this.prime = prime;
    }

    public Boolean isPrime() {
        return prime;
    }

    public void setFibonacci(Boolean fibonacci) {
        this.fibonacci = fibonacci;
    }

    public Boolean isFibonacci() {
        return fibonacci;
    }

    public boolean hasMessage() {
        return !getMessages().isEmpty();
    }
}
