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
public class TeacherController extends DictionaryItemController<Teacher>  {
    @Autowired
    private TeacherDAO teacherService;

    @Override
    protected Teacher getNewDictionaryItem() {
        return new Teacher();
    }

    @Override
    protected String createDictionaryItemDB(Teacher teacher) {
        teacherService.create(teacher);
        String message = "Запись о преподавателе успешно добавлена: " + teacher.getName() + ".";
        return message;
    }

    @Override
    protected List<Teacher> getItems() {
        return teacherService.findItems();
    }

    @Override
    protected String deleteItem(Integer id) {
        teacherService.delete(id);
        String message = "Запись о преподавателе успешно удалена.";
        return message;
    }

    @Override
    protected String getDictionaryTypePath() {
        return "/teacher";
    }
}
