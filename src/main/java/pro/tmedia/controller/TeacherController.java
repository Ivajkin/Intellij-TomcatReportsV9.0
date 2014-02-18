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
@RequestMapping("/teacher")
public class TeacherController implements DictionaryItemController<Teacher>  {
    @Autowired
    private TeacherDAO teacherService;

    @RequestMapping(value = "/create")
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView("create-discipline-form");
        modelAndView.addObject("dictionaryItem", new Teacher());
        return modelAndView;
    }

    @RequestMapping(value = "/create/process")
    public ModelAndView creating(@ModelAttribute Teacher teacher) {
        ModelAndView modelAndView = new ModelAndView("home");
        teacherService.create(teacher);
        String message = "Запись о преподавателе успешно добавлена: " + teacher.getName() + ".";
        modelAndView.addObject("message", message );
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public ModelAndView listOfItems() {
        ModelAndView modelAndView = new ModelAndView("list-of-disciplines");

        List<Teacher> dictionaryItems = teacherService.findItems();

        modelAndView.addObject("dictionaryItems", dictionaryItems);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        teacherService.delete(id);
        String message = "Запись о преподавателе успешно удалена.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
