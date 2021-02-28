package com.dailycodebuffer.user.vo;

import com.dailycodebuffer.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVo {

    private User user;
    private Department department;
}
