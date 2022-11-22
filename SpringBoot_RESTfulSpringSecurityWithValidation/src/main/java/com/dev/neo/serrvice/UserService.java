package com.dev.neo.serrvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.neo.entity.UserMaster;
import com.dev.neo.repository.UserMasterRepository;
@Service
public class UserService {
	@Autowired
    private UserMasterRepository userMasterRepository;

    public UserMaster saveUserWithDetails(UserMaster user) {
        return userMasterRepository.save(user);
    }


    public UserMaster findUserById(int userMasterId) {
        return userMasterRepository.findById(userMasterId).orElse(null);
    }

    public void deleteUserById(int userId) {
        userMasterRepository.deleteById(userId);
    }

    public UserMaster updateUserMaster(UserMaster userMaster) {
        return userMasterRepository.save(userMaster);
    }
    public List<UserMaster> searchUserMaster(String query) {
        List<UserMaster> userMasters = userMasterRepository.searchUserMaster(query);
        return userMasters;
    }
	
}// end class
