package com.docsconsole.tutorials.dao;

import com.docsconsole.tutorials.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public String saveCourse(Course course) {
        Long isSuccess = (Long) getSession().save(course);
        if (isSuccess >= 1) {
            return "Success";
        } else {
            return "Error while Saving Person";
        }

    }

    public boolean deleteCourse(Course course) {
        getSession().delete(course);
        return true;
    }

    public boolean updateCourse(Course course) {
        getSession().saveOrUpdate(course);
        return true;
    }

    public List getAllCourses() {
        try {
            return getSession().createQuery("from Course").list();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}