package db;

import java.security.PublicKey;
import java.util.ArrayList;

public class InMemoryDB {
    private static ArrayList<User> userDataBase = new ArrayList<>();

    public static void registerUser(User user){
        userDataBase.add(user);
    }

    public static User findUser(String nic){
        for (User user : userDataBase) {
            if(user.getNic().equalsIgnoreCase(nic)){
                return user;
            }
        }
        return null;
    }

    public static void removeUser(String nic){
        for (User user : userDataBase) {
            if (user.getNic().equals(nic)) {
                userDataBase.remove(user);
                return;
            }
        }
    }
    public static ArrayList<User> getUserDataBase(){
        return userDataBase;
    }
}
