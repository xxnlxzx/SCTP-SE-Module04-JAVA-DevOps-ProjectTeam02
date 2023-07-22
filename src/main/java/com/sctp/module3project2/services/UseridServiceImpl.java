package com.sctp.module3project2.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sctp.module3project2.entity.Userid;
import com.sctp.module3project2.exception.ShippingRouteNotFoundException;
import com.sctp.module3project2.repository.UseridRepository;


@Service
public class UseridServiceImpl implements UseridService {
    private UseridRepository useridRepository;

    public UseridServiceImpl(UseridRepository useridRepository){
        this.useridRepository = useridRepository;
    }

    private static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder(2 * hash.length);
    for (int i = 0; i < hash.length; i++) {
        String hex = Integer.toHexString(0xff & hash[i]);
        if(hex.length() == 1) {
            hexString.append('0');
        }
        hexString.append(hex);
    }
    return hexString.toString();}

    
    private static String encryptString(String password) {
        
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hashbytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            String encryptedPassword = bytesToHex(hashbytes);
            return encryptedPassword;

        } catch (NoSuchAlgorithmException e) {
            throw new ShippingRouteNotFoundException("No such algorithm");
        }
    }

    @Override
    public Userid saveUserid(Userid userid){
        Optional<Userid> wrappedUserid = ((UseridRepository) useridRepository).findByUserid(userid.getUserid());
        if (wrappedUserid.isPresent()){
            throw new ShippingRouteNotFoundException("User ID already in system");
        }

        userid.setPassword(encryptString(userid.getPassword()));
        
        Userid newUserid = useridRepository.save(userid);
        return newUserid;
    }

    @Override
    public ArrayList<Userid> getAllUserid() {
        ArrayList<Userid> allUserid = (ArrayList<Userid>) useridRepository.findAll();
        return allUserid; 
    }
    @Override
    public Userid findUserByUserID(String userid) {
        Optional<Userid> wrappedUserid = ((UseridRepository) useridRepository).findByUserid(userid);
        
        return wrappedUserid.get();
    }

    @Override
    public String findPassWordByUserID(String userid) {
        Optional<Userid> wrappedUserid = ((UseridRepository) useridRepository).findByUserid(userid);
        if (!wrappedUserid.isPresent()){
            throw new ShippingRouteNotFoundException("User ID not found");
        }

        Userid useridFound = wrappedUserid.get();
        return useridFound.getPassword();
    }
    @Override
    public Userid findUserIdById(int id) {
        Optional<Userid> wrappedUserid = useridRepository.findById(id);
        if (!wrappedUserid.isPresent()){
            throw new ShippingRouteNotFoundException("No User of this ID found");
        }

        Userid foundUserid = wrappedUserid.get();
        return foundUserid;
    }
    @Override
    public Userid updateUserid(int id, Userid userid){
        Optional<Userid> wrappedUserid = useridRepository.findById(id);
        if (!wrappedUserid.isPresent()){
            throw new ShippingRouteNotFoundException("No User of this ID found");
        }

        Userid foundUserid = wrappedUserid.get();
        foundUserid.setUserid(userid.getUserid());
        foundUserid.setPassword(encryptString(userid.getPassword()));
        return useridRepository.save(foundUserid);

    }
    @Override
    public void deleteUserid(int id) {
        useridRepository.deleteById(id);
    }

    @Override
    public void verifyPassword(String userid, String password) {
        Optional<Userid> wrappedUserid = ((UseridRepository) useridRepository).findByUserid(userid);
        if (!wrappedUserid.isPresent()){
            throw new ShippingRouteNotFoundException("No User of this ID found");
        }
        Userid foundUserid = wrappedUserid.get();
        String foundPassword = foundUserid.getPassword();
        if (!foundPassword.equals(encryptString(password))){
            throw new ShippingRouteNotFoundException("Wrong Password");
        };


    }

    
    
}