package com.dev.edgard.usersManagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.edgard.usersManagment.dao.UserDao;
import com.dev.edgard.usersManagment.models.User;

@Service
public class UserService {
    
    @Autowired
    UserDao userDao;


    public List<User> findAllUsers(){
        List<User> users = userDao.findAll();
        return users;
    }

    public User findUser(Long id){
        User user = userDao.findById(id).orElse(null);
        return user;
    }

    public ResponseEntity<String> createUser(User user){
        User newUser = new User(
            user.getId(),
            user.getNombre(),
            user.getApellido(),
            user.getEmail(),
            user.getTelefono(),
            user.getPassword()
        ); 

        try {
            userDao.save(newUser);        
        } catch (Exception e) {
            return ResponseEntity.ok().body("Ocurrio un problema al intentar crear el usuario");
        }

        return ResponseEntity.ok().body("Usuario creado exitosamente");

    }

    public ResponseEntity<String> updateUser(Long id, User user){
        User userToUpdate = userDao.findById(id).orElse(null);

        userToUpdate.setNombre(user.getNombre());
        userToUpdate.setApellido(user.getApellido());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setTelefono(user.getTelefono());
        userToUpdate.setPassword(user.getPassword());
        
        try {
            
            userDao.save(userToUpdate);
        } catch (Exception e) {
            return ResponseEntity.ok().body("Ocurrio un error al tratar de actualizar el usuario");

        }

        return ResponseEntity.ok().body("Usuario actualizado con exito");

    }

    public ResponseEntity<String> deleteUser(Long id){
        User userToDelete = userDao.findById(id).orElse(null);
        try {
            userDao.delete(userToDelete);
        } catch (Exception e) {
            return ResponseEntity.ok().body("Ocurrio un problema al intentar eliminar el usuario");
        }        

        return ResponseEntity.ok().body("Usuario eliminado exitosamente");
    }
}
