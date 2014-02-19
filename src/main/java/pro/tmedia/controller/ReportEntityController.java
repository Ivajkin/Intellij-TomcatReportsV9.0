package pro.tmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pro.tmedia.model.ReportEntry;
import pro.tmedia.service.ReportEntryService;

import java.util.List;

/**
 * User: Ivaykin Timofey
 */
@Controller
@RequestMapping("/report")
public class ReportEntityController {
    @Autowired
    private ReportEntryService reportEntryService;
    @RequestMapping(value = "/list")
    public final ModelAndView listOfItems() {
        ModelAndView modelAndView = new ModelAndView("list-of-reports");

        List<ReportEntry> reportEntries = reportEntryService.findItems();

        modelAndView.addObject("reportEntries", reportEntries);

        return modelAndView;
    }

    /*@RequestMapping(value = "/actions")
    public final String actionsToolbox() {
    }         */
}
