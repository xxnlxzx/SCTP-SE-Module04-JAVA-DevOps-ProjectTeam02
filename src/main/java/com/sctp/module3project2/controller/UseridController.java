package com.sctp.module3project2.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sctp.module3project2.entity.Userid;
import com.sctp.module3project2.services.UseridService;

@RestController
@RequestMapping("/users")
public class UseridController {
    private UseridService useridService;

    public UseridController(UseridService useridService){
        this.useridService = useridService;
    }

    @PostMapping("")
    public ResponseEntity<Userid> saveUserid(@RequestBody Userid userid){
        Userid newUserid = useridService.saveUserid(userid);
        return new ResponseEntity<>(newUserid, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Userid>> getAllUserid() {
        ArrayList<Userid> allUserid = useridService.getAllUserid();
        return new ResponseEntity<>(allUserid, HttpStatus.OK);
    }

    // @GetMapping("/{userid}")
    // public ResponseEntity<Userid> getUseridByUserid(@PathVariable String userid) {
    //     Userid foundUserid = useridService.findUserByUserID(userid);
    //     return new ResponseEntity<>(foundUserid,HttpStatus.OK);
    // }
    @GetMapping("/password/{userid}")
    public ResponseEntity<String> findPassWordByUserID(@PathVariable String userid) {
        String foundPassword = useridService.findPassWordByUserID(userid);
        return new ResponseEntity<>(foundPassword,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Userid> getUseridById(@PathVariable int id){
        Userid getUserid = useridService.findUserIdById(id);
        return new ResponseEntity<>(getUserid, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable int id){
        useridService.deleteUserid(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Userid> updateUserid(@PathVariable int id, @RequestBody Userid userid){
        Userid newUserid = useridService.updateUserid(id, userid);
        return new ResponseEntity<>(newUserid, HttpStatus.OK);
    }
}
