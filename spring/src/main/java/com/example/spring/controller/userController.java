package com.example.spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.spring.common.GlobalVariables;
import com.example.spring.common.R;
import com.example.spring.entity.user;
import com.example.spring.service.userService;
import com.example.spring.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class userController {
    @Autowired
    private userService userService;

    //发送手机短信验证码
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody user user, HttpSession session) {
        //获取手机号
        String phone = user.getUserPhone();
        if (StringUtils.isNotEmpty(phone)) {
            //随机获得四位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            //发送短信
            //SMSUtils.sendMessage("签名","模板code"，“手机号”，“验证码”)  //阿里云
            log.info("code = {}", code);
            //将验证码保存到session
            session.setAttribute(phone, code);  //手机号为key
            return R.success("手机验证码发送成功, 验证码为：" + code);
        }

        return R.error("短信发送失败");
    }

    @PostMapping("/login")
    public R<user> login(@RequestBody Map map, HttpSession session) {
        log.info(map.toString());
        //获取手机号
        String phone = map.get("phone").toString();
        //获取验证码
        //Object code = map.get("code");

        LambdaQueryWrapper<user> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(user::getUserPhone, phone);
        user user = userService.getOne(queryWrapper);
        if (user == null) {
            //比对成功则登录
            user = new user();
            user.setUserPhone(phone);
            userService.save(user);
        }
        //session.setAttribute("user",user.getUserId);  //session中存放id，为了让过滤器检验
        GlobalVariables.setGlobalPhone(phone);
        log.info(GlobalVariables.getInstance().getGlobalPhone());
        return R.success(user);
    }

    @PostMapping("/logout")
    public void logout(){
        GlobalVariables.setGlobalId(0);
        GlobalVariables.setGlobalPhone(null);
    }
}
