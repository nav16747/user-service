package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepository;
import com.dailycodebuffer.user.vo.Department;
import com.dailycodebuffer.user.vo.ResponseTemplateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User save(User user) {
        log.info("inside user service save method");
        return  userRepository.save(user);
    }

    public ResponseTemplateVo getUserByDepartment(Long userId) {
        log.info("loading user cum department from User Service");
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        responseTemplateVo.setUser(user);
        responseTemplateVo.setDepartment(department);
        return responseTemplateVo;

    }
}
