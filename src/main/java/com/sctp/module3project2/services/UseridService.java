package com.sctp.module3project2.services;

import java.util.ArrayList;

import com.sctp.module3project2.entity.Userid;

public interface UseridService {
    Userid saveUserid(Userid userid);

    ArrayList<Userid> getAllUserid();

    Userid findUserIdById(int id);

    Userid updateUserid(int id, Userid userid);

    void deleteUserid(int id);

    Userid findUserByUserID(String userid);

    String findPassWordByUserID(String userid);
    
    void verifyPassword(String userid, String password);

}

