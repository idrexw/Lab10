package edu.secourse.salonapp.services;

import edu.secourse.salonapp.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public void createUser(User user){
        users.add(user);
    }

    public boolean updateUser(int accountId, String newName, String newEmail){
        for(User u : users){
            if(u.getAccountId() == accountId){
                u.setName(newName);
                u.setEmailAddress(newEmail);
                return true;
            }
        }
        return false;
    }

    public boolean removeUser(int accountId){
        return users.removeIf(u -> u.getAccountId() == accountId);
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(users);
    }

}
