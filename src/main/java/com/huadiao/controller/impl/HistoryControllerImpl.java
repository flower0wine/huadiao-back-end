package com.huadiao.controller.impl;

import com.huadiao.controller.HistoryController;
import com.huadiao.entity.Result;
import com.huadiao.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author flowerwine
 * @date 2023 年 09 月 18 日
 */
@RestController
@RequestMapping("/history")
public class HistoryControllerImpl implements HistoryController {
    private HistoryService historyService;

    @Autowired
    public HistoryControllerImpl(HistoryService historyService) {
        this.historyService = historyService;
    }

    @Override
    @GetMapping("/note")
    public Result<?> getNoteHistory(HttpSession session, Integer row, Integer offset) {
        Integer uid = (Integer) session.getAttribute("uid");
        String userId = (String) session.getAttribute("userId");
        return historyService.getNoteHistory(uid, userId, row, offset);
    }

    @Override
    @GetMapping("/anime")
    public Result<?> getAnimeHistory(HttpSession session, Integer row, Integer offset) {
        Integer uid = (Integer) session.getAttribute("uid");
        String userId = (String) session.getAttribute("userId");
        return historyService.getAnimeHistory(uid, userId, row, offset);
    }

    @Override
    @GetMapping("/note/delete")
    public Result<?> deleteNoteHistory(HttpSession session, Integer uid, Integer noteId) {
        Integer myUid = (Integer) session.getAttribute("uid");
        String userId = (String) session.getAttribute("userId");
        return historyService.deleteNoteHistory(myUid, userId, uid, noteId);
    }

    @Override
    @GetMapping("/anime/delete")
    public Result<?> deleteAnimeHistory(HttpSession session, Integer uid) {
        Integer myUid = (Integer) session.getAttribute("uid");
        String userId = (String) session.getAttribute("userId");
        return historyService.deleteAnimeHistory(myUid, userId, uid);
    }
}
