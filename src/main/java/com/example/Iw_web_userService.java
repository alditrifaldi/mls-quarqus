package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class Iw_web_userService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Iw_web_user> listAllIw_web_user() {
        return entityManager.createQuery("SELECT u FROM Iw_web_user u", Iw_web_user.class).getResultList();
    }
}
