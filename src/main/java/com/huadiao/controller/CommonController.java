package com.huadiao.controller;

import com.huadiao.entity.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author flowerwine
 * @date 2024 年 02 月 09 日
 */
public interface CommonController {

    /**
     * 或吊用户进行登录
     *
     * @param request 请求
     * @param response 响应
     * @param map 请求体参数集合
     * @return 返回提示信息
     * @throws Exception 可能抛出异常
     */
    Result<String> huadiaoUserLogin(HttpServletRequest request, HttpServletResponse response, Map<String, String> map) throws Exception;

    /**
     * 获取注册账号的验证码
     *
     * @param response 响应
     * @param session session
     * @param jsessionid jsessionid
     * @throws Exception 可能抛出异常
     */
    void getCheckCode(HttpServletResponse response, HttpSession session, String jsessionid) throws Exception;

    /**
     * 注册花凋账号
     *
     * @param map     账号, 密码, 验证码的集合
     * @param session session 对象
     * @param jsessionid jsessionid
     * @return 返回错误或正确标识
     * @throws Exception 可能抛出异常
     */
    Result<?> registerHuadiao(Map<String, String> map, HttpSession session, String jsessionid) throws Exception;

    /**
     * 使用 github 注册
     * @param code 授权码
     * @return 响应结果
     */
    Result<?> githubRegister(String code);
}
