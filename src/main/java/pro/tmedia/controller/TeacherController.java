package pro.tmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pro.tmedia.dao.DictionaryItemDAO;
import pro.tmedia.dao.TeacherDAO;
import pro.tmedia.dao.TeacherDAOImpl;
import pro.tmedia.model.DictionaryItem;
import pro.tmedia.model.Discipline;
import pro.tmedia.model.Teacher;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/12/14
 */
@Controller
public class TeacherController {
    @Autowired
    private TeacherDAO teacherService;

    @RequestMapping(value = "/teacher/create")
    public ModelAndView createTeacherPage() {
        ModelAndView modelAndView = new ModelAndView("create-teacher-form");
        modelAndView.addObject("teacher", new Teacher());
        return modelAndView;
    }

    @RequestMapping(value = "/teacher/create/process")
    public ModelAndView creatingTeacher(@ModelAttribute Teacher teacher) {
        ModelAndView modelAndView = new ModelAndView("home");
        teacherService.create(teacher);
        String message = "Запись о преподавателе успешно добавлена: " + teacher.getName() + ".";
        modelAndView.addObject("message", message );
        return modelAndView;
    }

    @RequestMapping(value = "/teacher/list")
    public ModelAndView listOfTeams() {
        ModelAndView modelAndView = new ModelAndView("list-of-teacher");

        List<Teacher> teachers = teacherService.findItems();
        modelAndView.addObject("teachers", teachers);

        return modelAndView;
    }

    @RequestMapping(value = "/teacher/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDiscipline(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        teacherService.delete(id);
        String message = "Запись о преподавателе успешно удалена.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
