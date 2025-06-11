package com.dio.master.integrations.validators.omdb;

public interface ValidatorOmdb<T> {
    void validate(T object, String imdbID);
}