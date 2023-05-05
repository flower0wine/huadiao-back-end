package com.huadiao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName huadiao-user-back
 * @description 装载有关注的用户或粉丝的信息
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class FollowFan {
    private Integer uid;
    private String userId;
    private String nickname;
    private String userAvatar;
    private String canvases;
    private Integer groupId;
    private Boolean friend;
}