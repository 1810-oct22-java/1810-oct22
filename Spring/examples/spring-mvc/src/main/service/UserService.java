package com.ex.service;

import com.ex.beans.User;

@Service("userService")
public class UserService{

    static ArrayList<User> users = new ArrayList<User>();
    static int seq = 3;
    static {
        users.add(new User(1,"gab12","123","genesis"));
        users.add(new User(2,"test","user","testing"));
    }

    public List<User>getAll(){
        return users;
    }
    public User getById(int id){
        return (User) users.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        
    }
    public User getByUsernaem(String username){
        return (User) users.stream().filter(t -> t.getUsername().equalsIngonreCase(username).findFirst().orElse(null));
    }
    public User addUser(User u){
        u.setId(seq++);
        users.add(u);
        return u;
    }
}