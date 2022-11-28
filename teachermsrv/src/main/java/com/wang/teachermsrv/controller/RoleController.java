package com.wang.teachermsrv.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {

    @RequestMapping(value="/addteacher", method= RequestMethod.POST)
    public ResponseEntity<?> addTeacher(@RequestBody Object dto) throws Exception {
        return ResponseEntity.ok().body("");
    }

    @RequestMapping(value="/addstudent", method= RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestBody Object dto) throws Exception {
        return ResponseEntity.ok().body("");
    }

}
