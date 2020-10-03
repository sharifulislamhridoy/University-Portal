/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Notice;
import com.mycompany.universityprotal.repository.NoticeRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_NoticeController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shari
 */
@RestController
@RequestMapping(value = "/api/v1")
public class NoticeController implements I_NoticeController{
       @Autowired
       NoticeRepository noticeRepository;

    @Override
    public Notice create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/notice")
    public Notice save(@RequestBody Notice notice) {
    return noticeRepository.save(notice);
    }

    @Override
    public ResponseEntity<Notice> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/notice/{id}")
    public ResponseEntity<Notice> update(@PathVariable("id") Integer id,@RequestBody Notice notice) {
     Notice currentNotice = noticeRepository.getById(id);
        if (currentNotice == null) {
            return new ResponseEntity<Notice>(HttpStatus.NOT_FOUND);
        }
        currentNotice.setId(notice.getId());
        currentNotice.setTitle(notice.getTitle());
        currentNotice.setNotice(notice.getNotice());


        noticeRepository.update(currentNotice);
        return new ResponseEntity<Notice>(currentNotice, HttpStatus.OK);
    }

    @Override
        @GetMapping("/notice")
    public List<Notice> getAll() {
        return noticeRepository.viewAll();
    }

    @Override
    @DeleteMapping("/notice/{id}")
    public ResponseEntity<Notice> delete(@PathVariable("id") Integer id) {
      Notice notice = noticeRepository.getById(id);

        if (notice == null) {
            return new ResponseEntity<Notice>(HttpStatus.NOT_FOUND);
        }
        noticeRepository.delete(id);
        return new ResponseEntity<Notice>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/notice/{id}")
    public ResponseEntity<Notice> getById(@PathVariable("id") Integer id) {
        Notice notice = noticeRepository.getById(id);
        if (notice == null) {
            return new ResponseEntity<Notice>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Notice>(notice, HttpStatus.OK);
        }
    }
}
