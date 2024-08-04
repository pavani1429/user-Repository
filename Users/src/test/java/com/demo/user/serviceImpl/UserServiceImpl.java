package com.demo.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.entity.User;
import com.demo.user.model.UserModel;
import com.demo.user.repository.UserRepository;
import com.demo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	
//	 private JdbcTemplate jdbcTemplate;
//     
//	    public JdbcTemplate getJdbcTemplate() {
//	        return jdbcTemplate;
//	    }
//	 
//	    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//	        this.jdbcTemplate = jdbcTemplate;
//	    }
//
//	
//
//		@Override
//		public List<UserModel> getAllUsers() {
//			return jdbcTemplate.query("SELECT * FROM userdata", new BeanPropertyRowMapper<UserModel>());
//		}
//
//		@Override
//		public Optional<UserModel> updateUser(String email, UserModel userDetails) {
//			// TODO Auto-generated method stub
//			return Optional.empty();
//		}
//
//		@Override
//		public boolean deleteUser(String email) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		@Override
//		public UserModel createUser(UserModel user) {
//			// TODO Auto-generated method stub
//			return null;
//		}
	 
	

	
	
	

//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public UserServiceImpl() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public Optional<User> updateUser(String email, User userDetails) {
//        User existingUser = userRepository.findByEmail(email);
//        if (existingUser != null) {
//            existingUser.setName(userDetails.getName());
//            existingUser.setMobile(userDetails.getMobile());
//            userRepository.save(existingUser);
//            return Optional.of(existingUser);
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean deleteUser(String email) {
//    	boolean flag = false ;
//        User existingUser = userRepository.findByEmail(email);
//        if (existingUser != null) {
//            System.out.println("Deleting user with email: " + email);
//            userRepository.delete(existingUser);
//            flag = true ;
//        } else {
//            System.out.println("User not found with email: " + email);
//            throw new RuntimeException("User not found with email: " + email);
//        }
//        return flag;
//		
//    }
//	
	
	
	
	
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public UserModel createUser(UserModel userModel) {
	    	User user = convertUserModelToUser(userModel);
	    	user=userRepository.save(user);
	    	userModel = convertUserToUserModel(user);
	    	return userModel;
	    }

	    private User convertUserModelToUser(UserModel user) {
	    	User userModel = new User();
			userModel.setEmail(user.getEmail());
			userModel.setId(user.getId());
			userModel.setMobile(user.getMobile());
			userModel.setName(user.getName());
			return userModel;
		}

		public UserServiceImpl() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
	    public List<UserModel> getAllUsers() {
			List<User> users = userRepository.findAll();
			List<UserModel> userModels = new ArrayList<UserModel>();
			for(User user : users) {
				userModels.add(convertUserToUserModel(user));
			}
	        return userModels;
	    }

	    @Override
	    public Optional<UserModel> updateUser(String email, UserModel userDetails) {
	        User existingUser = userRepository.findByEmail(email);
	        if (existingUser != null) {
	            existingUser.setName(userDetails.getName());
	            existingUser.setMobile(userDetails.getMobile());
	           User user = userRepository.save(existingUser);
	           userDetails= convertUserToUserModel(user);
	            return Optional.of(userDetails);
	        }
	        return Optional.empty();
	    }

	    private UserModel convertUserToUserModel(User user) {
			UserModel userModel = new UserModel();
			userModel.setEmail(user.getEmail());
			userModel.setId(user.getId());
			userModel.setMobile(user.getMobile());
			userModel.setName(user.getName());
			return userModel;
		}

		@Override
	    public boolean deleteUser(String email) {
	    	boolean flag = false ;
	        User existingUser = userRepository.findByEmail(email);
	        if (existingUser != null) {
	            System.out.println("Deleting user with email: " + email);
	            userRepository.delete(existingUser);
	            flag = true ;
	        } else {
	            System.out.println("User not found with email: " + email);
	            throw new RuntimeException("User not found with email: " + email);
	        }
	        return flag;
			
	    }
		
	
	
	
	
	
	
	
	
	
	
	
	//latest
	
	

}
