package com.huadiao.service;

import cn.hutool.http.server.HttpServerRequest;
import com.huadiao.entity.Result;
import com.huadiao.entity.dto.note.NoteCommentDto;
import com.huadiao.entity.dto.note.SelfNoteDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 业务层: 处理笔记
 *
 * @author flowerwine
 */
public interface NoteService {

    /**
     * 新增笔记
     *
     * @param uid         用户 uid
     * @param userId      用户 id
     * @param noteTitle   笔记标题
     * @param noteContent 笔记内容
     * @return 返回发布成功与否提示
     */
    String insertNewNote(Integer uid, String userId, String noteTitle, String noteContent);

    /**
     * 获取指定用户的笔记
     *
     * @param uid       读者 uid
     * @param userId    读者 id
     * @param authorUid 作者 uid
     * @param noteId    笔记唯一标识
     * @return 返回含有作者笔记的集合, 里面处理笔记还有是否是本人等信息
     */
    Result<?> getSingleNote(Integer uid, String userId, Integer authorUid, Integer noteId);

    /**
     * 获取用户的笔记, 与上面不同的是该方法是在编辑笔记页面进行的获取自己的笔记请求
     *
     * @param uid    用户 uid
     * @param userId 用户 id
     * @param noteId 笔记 id
     * @return 返回单个笔记, 一定是自己的笔记
     */
    SelfNoteDto getSingleNote(Integer uid, String userId, Integer noteId);

    /**
     * 删除笔记
     *
     * @param uid    用户 uid
     * @param userId 用户 id
     * @param noteId 笔记 id
     * @return 返回删除成功与否提示
     */
    String deleteNote(Integer uid, String userId, Integer noteId);

    /**
     * 修改笔记
     *
     * @param uid         用户 uid
     * @param userId      用户 id
     * @param noteId      笔记 id
     * @param noteTitle   笔记标题
     * @param noteContent 笔记内容
     * @return 返回修改成功提示
     */
    String modifyNote(Integer uid, String userId, Integer noteId, String noteTitle, String noteContent);

    /**
     * 查找作者的所有笔记
     *
     * @param uid       用户 uid
     * @param userId    用户 id
     * @param authorUid 作者 uid
     * @return 返回作者的所有笔记
     */
    Result<?> getAllNote(Integer uid, String userId, Integer authorUid);

    /**
     * 获取笔记评论
     *
     * @param uid       获取笔记评论的用户 uid
     * @param userId    用户 id
     * @param authorUid 作者 uid
     * @param noteId    笔记 id
     * @param offset    偏移量
     * @param row       行数
     * @return 返回评论
     */
    Result<List<NoteCommentDto>> getNoteComment(Integer uid, String userId, Integer authorUid, Integer noteId, Integer offset, Integer row);

}
