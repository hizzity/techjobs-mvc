package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

import static org.launchcode.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    private static final String DATA_FILE = "resources/job_data.csv";
    private static Boolean isDataLoaded = false;

    private static ArrayList<HashMap<String, String>> allJobs;

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    //instructions: 'The method should take in two parameters, specifying the type of search
    // and the search term'
    public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("columnName", searchType); //searchType = column
        model.addAttribute("searchTerm", searchTerm); //searchTerm = keyword being searched
                                                                  //need to loop through searchType looking for searchTerm
//TODO if searchType is "all" then call findAll in JobData (refer to line 62 in ListControllers) else run below

    if (searchType == "all") {
        ArrayList<HashMap<String, String>> jobs = new JobData.findAll();
    }else {
        JobData jobs = new JobData();
        jobs.findByValue(searchTerm);
    }

        model.addAttribute("jobs", jobs); //pass ArrayList to search.html

//        System.out.println("*************" + jobs + "******************"); //"search"
        return "search";


//Instructions:
// Add another results handler method to SearchController, overloading the existing method.
// The method should take in two parameters, specifying the type of search and the search term.
// In order for the parameters to be properly passed in by Spring Boot, you'll need to name them
// appropriately, based on the corresponding form field names. You'll also need to use the correct
// annotations for the method and parameters. To configure the correct mapping route, refer to the
// form action in search.html.
//
//After looking up the search results via the JobData class, you'll need to pass them into the
// search.html view via the model. You'll also need to pass ListController.columnChoices to the
// view, as the existing search handler does.
    }
}
