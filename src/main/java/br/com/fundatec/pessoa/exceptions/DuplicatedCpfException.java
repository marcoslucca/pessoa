package br.com.fundatec.pessoa.exceptions;

public class DuplicatedCpfException extends RuntimeException {

    public DuplicatedCpfException(String message) {
        super(message);
    }

}
