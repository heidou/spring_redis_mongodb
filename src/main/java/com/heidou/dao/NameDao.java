package com.heidou.dao;

import com.heidou.model.StudentDO;
import com.heidou.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * @author: heidou
 * @description:
 * @data2017/5/26.
 */
@Component
public class NameDao {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDO findByName(String name) {
        List<StudentDO> li = studentRepository.findByName(name);
        if (CollectionUtils.isEmpty(li)) {
            return null;
        }
        return li.get(0);
    }

    public void create(StudentDO studentDO) {
        StudentDO existDO = findByName(studentDO.getName());
        if (existDO != null) {
            studentDO.setId(existDO.getId());
        }
        studentRepository.save(studentDO);
    }
}
