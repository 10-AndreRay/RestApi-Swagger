package com.dev.restapi.repositories;

import com.dev.restapi.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public User save(User user) {
        if(user.getId() == null)
            System.out.println("Salvando novo usuário!");
        else
            System.out.println("Atualizando dados do usuário com id: " + user.getId());

        return user;
    }

    public String deleteById(Integer id) {
        return "Deletando usuário com id: " + id;
    }

    public List<User> findAll() {
        System.out.println("-==Listando todos os usuários==-");

        List<User> users = new ArrayList<>();
        users.add(new User("Andre", "senhadoandre"));
        users.add(new User("Fernanda", "senhadafernanda"));

        return users;
    }

    public User findById(Integer id) {
        System.out.println("Buscando usuário com id: " + id);
        return new User("User" + id, "senhauser" + id);
    }

    public User findByUsername(String username) {
        System.out.println("Buscando usuário com username: " + username);
        return new User(username, "senha" + username);
    }
}
