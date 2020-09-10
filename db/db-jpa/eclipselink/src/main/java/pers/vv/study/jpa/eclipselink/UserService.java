package pers.vv.study.jpa.eclipselink;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.vv.study.jpa.eclipselink.domain.User;
import pers.vv.study.jpa.eclipselink.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements InitializingBean {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setId(1);
        user.setName("vv");
        user.setCreateTime(new Date());
        userRepository.save(user);
        
        List<User> result = userRepository.findAll();
        System.out.println(result);
    }
    
}
