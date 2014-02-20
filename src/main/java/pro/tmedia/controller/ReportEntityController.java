package pro.tmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pro.tmedia.model.*;
import pro.tmedia.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Ivaykin Timofey
 */
@Controller
@RequestMapping("/report")
public class ReportEntityController {
    @Autowired
    private ReportEntryService reportEntryService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private DisciplineService disciplineService;
    @Autowired
    private FlowService flowService;

    @RequestMapping(value = "/select")
    public final ModelAndView selectReport() {
        ModelAndView modelAndView = new ModelAndView("/report/select");

        modelAndView.addObject("reportSelectForm", new ReportEntry());
        List<ReportEntry> reportEntries = reportEntryService.findItems();
        modelAndView.addObject("reportEntries", reportEntries);


        List<Semester> semesterList = semesterService.findItems();
        modelAndView.addObject("semesterList", semesterList);



        List<Department> departmentList = departmentService.findItems();
        modelAndView.addObject("departmentList", departmentList);
        List<Teacher> teacherList = teacherService.findItems();
        modelAndView.addObject("teacherList", teacherList);

        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public final ModelAndView listOfItems() {
        ModelAndView modelAndView = new ModelAndView("/report/select");

        modelAndView.addObject("reportSelectForm", new ReportEntry());
        List<ReportEntry> reportEntries = reportEntryService.findItems();
        modelAndView.addObject("reportEntries", reportEntries);

        return modelAndView;
    }

    @RequestMapping(value = "/actions")
     public final ModelAndView actionPage(@ModelAttribute ReportEntry reportEntry) {
        ModelAndView modelAndView = new ModelAndView("create-report-entry");

        modelAndView.addObject("newReportEntry", new ReportEntry());

        return modelAndView;
    }

    @RequestMapping(value = "/create")
    public final ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/report/create");
        modelAndView.addObject("reportSelectForm", new ReportEntry());


        List<Semester> semesterList = semesterService.findItems();
        modelAndView.addObject("semesterList", semesterList);

        List<Department> departmentList = departmentService.findItems();
        modelAndView.addObject("departmentList", departmentList);

        List<Teacher> teacherList = teacherService.findItems();
        modelAndView.addObject("teacherList", teacherList);

        List<Discipline> disciplineList = disciplineService.findItems();
        modelAndView.addObject("disciplineList", disciplineList);

        List<Flow> flowList = flowService.findItems();
        modelAndView.addObject("flowList", flowList);


        return modelAndView;
    }

    @RequestMapping(value = "/create/process", method = RequestMethod.POST)
    public final ModelAndView creating(@ModelAttribute ReportEntry reportSelectForm, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("home");

        reportEntryService.create(reportSelectForm);

        if (bindingResult.hasErrors()) {
            String message = "Ошибка bindingResult.hasErrors.";
            modelAndView.addObject("message", message );
        } else {
            String message = "Запись отчета успешно добавлена.";
            modelAndView.addObject("message", message );
        }

        return modelAndView;
    }

    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map referenceData = new HashMap();

        List<Semester> semesterList = semesterService.findItems();
        Map<String,String> semesterMap = new LinkedHashMap<String,String>();
        for(int i = 0; i < semesterList.size(); ++i) {
            semesterMap.put(semesterList.get(i).getName(), semesterList.get(i).getName());
        }
        referenceData.put("semesterList", semesterMap);

        return referenceData;
    }
}
