package org.example.library.dao;

import org.example.library.model.Rental;

import java.util.List;

public interface RentalProvider {
    List<Rental> findRentalByLogin(String login);
}
