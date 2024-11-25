package com.redesocial.exception;

    public class PostException extends Exception {
        public PostException(String message) {
            super(message);
        }
        public PostException(String message, Throwable causa) {
            super(message, causa);
        }
    }


