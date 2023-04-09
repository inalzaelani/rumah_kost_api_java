package com.inaal.rumahkost_api.services;

import com.inaal.rumahkost_api.exception.NotFoundException;
import com.inaal.rumahkost_api.models.entity.User;
import com.inaal.rumahkost_api.repositories.IRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService implements IServices<User> {
    private IRepositories<User> userRepository;


    @Autowired
    public UserService(IRepositories<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllService() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .findFirst()
                .map(u -> users)
                .orElseThrow(() -> new NotFoundException("USER NOT FOUND"));
    }

    @Override
    public User getByIdService(Long id) throws Exception {
        try{
            User user = userRepository.findById(id);
            if (user == null){
                throw new NotFoundException("USER NOT FOUND");
            }
            return user;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveService(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteService(User user) throws Exception {
        try {
            User find = userRepository.findById(user.getId());
            if(find==null){
                throw new NotFoundException("USER NOT FOUND");
            }
            userRepository.delete(user);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateService(User user) throws Exception {
       try {
              User find = userRepository.findById(user.getId());
              if(find==null){
                throw new NotFoundException("USER NOT FOUND");
              }
              userRepository.update(user);
         } catch (Exception e){
              throw new RuntimeException(e);
       }
    }
}
