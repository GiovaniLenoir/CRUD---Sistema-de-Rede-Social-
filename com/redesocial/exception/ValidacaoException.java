package com.redesocial.exception;

    public class ValidacaoException extends Exception {
        public ValidacaoException(String message) {
            super(message);
        }
        public ValidacaoException(String message, Throwable causa) {
            super(message, causa);
        }
    }

