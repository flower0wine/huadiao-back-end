package com.huadiao.controller.impl;

import com.huadiao.controller.NoteController;
import com.huadiao.entity.dto.note.SelfNoteDto;
import com.huadiao.service.FollowFanService;
import com.huadiao.service.NoteService;
import com.huadiao.service.UserService;
import com.huadiao.service.UserSettingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName huadiao-user-back
 * @description 用户笔记控制器实现类
 */
@RestController
@RequestMapping("/note")
public class NoteControllerImpl implements NoteController {

    private UserService userService;
    private FollowFanService followFanService;
    private UserSettingsService userSettingsService;
    private NoteService noteService;

    @Autowired
    public NoteControllerImpl(UserService userService, FollowFanService followFanService, UserSettingsService userSettingsService, NoteService noteService) {
        this.userService = userService;
        this.followFanService = followFanService;
        this.userSettingsService = userSettingsService;
        this.noteService = noteService;
    }

    @Override
    @PostMapping("/publish")
    public String publishNote(HttpSession session, @RequestBody Map<String, String> map) {
        Integer uid = (Integer) session.getAttribute("uid");
        String userId = (String) session.getAttribute("userId");
        String noteTitle = map.get("title");
        String noteContent = map.get("content");
        return noteService.insertNewNote(uid, userId, noteTitle, noteContent);
    }

    @Override
    @GetMapping("/delete")
    public String deleteNote(HttpSession session, Integer noteId) {
        Integer uid = (Integer) session.getAttribute("uid");
        String userId = (String) session.getAttribute("userId");
        return noteService.deleteNote(uid, userId, noteId);
    }

    @Override
    @PostMapping("/modify")
    public String modifyNote(HttpSession session, Integer noteId, @RequestBody Map<String, String> map) {
        Integer uid = (Integer) session.getAttribute("uid");
        String userId = (String) session.getAttribute("userId");
        String noteTitle = map.get("title");
        String noteContent = map.get("content");
        return noteService.modifyNote(uid, userId, noteId, noteTitle, noteContent);
    }

    @Override
    @GetMapping("/search")
    public Map<String, Object> getSingleNote(HttpSession session, Integer uid, Integer noteId) {
        Integer myUid = (Integer) session.getAttribute("uid");
        String userId = (String) session.getAttribute("userId");
        return noteService.getSingleNote(myUid, userId, uid, noteId);
    }

    @Override
    @GetMapping("/myNote")
    public SelfNoteDto getSingleNote(HttpSession session, Integer noteId) {
        Integer uid = (Integer) session.getAttribute("uid");
        String userId = (String) session.getAttribute("userId");
        return noteService.getSingleNote(uid, userId, noteId);
    }

    @Override
    @GetMapping("/all")
    public Map<String, Object> getAllNotes(HttpSession session, Integer authorUid) {
        Integer uid = (Integer) session.getAttribute("uid");
        String userId = (String) session.getAttribute("userId");
        return noteService.getAllNote(uid, userId, authorUid);
    }
}
