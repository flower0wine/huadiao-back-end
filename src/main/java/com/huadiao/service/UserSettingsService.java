package com.huadiao.service;

import com.huadiao.entity.Result;

import java.util.Set;

/**
 * 业务层: 与账号设置相关的操作的接口
 * @author flowerwine
 */
public interface UserSettingsService {

    /**
     * 根据 uid 获取用户账号设置
     * @param uid 用户 uid
     * @param userId 用户 id
     * @return 返回用户设置
     */
    Result<?> getUserSettings(Integer uid, String userId);

    /**
     * 获取用户消息设置
     * @param uid 用户 uid
     * @param userId 用户 id
     * @return 返回消息设置
     */
    Result<?> getMessageSettings(Integer uid, String userId);

    /**
     * 根据 uid 更新用户账号设置
     * @param uid 用户 uid
     * @param userId 用户 id
     * @param settingsSet 设置集合
     * @return 返回更新成功提示
     * @throws Exception 可能会抛出异常
     */
    Result<?> modifyAccountSettings(Integer uid, String userId, Set<String> settingsSet) throws Exception;
}
