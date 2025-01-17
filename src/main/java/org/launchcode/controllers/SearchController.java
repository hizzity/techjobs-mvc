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
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    //instructions: 'The method should take in two parameters, specifying the type of search
    // and the search term'
    public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("searchType", searchType); //searchType = column
        model.addAttribute("searchTerm", searchTerm); //searchTerm = keyword that is being searched for

        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();
// I'm pass jobs...should I be passing as key, value sets?
    if (searchType.equals("all")) {
       jobs = JobData.findByValue(searchTerm);
    }else {
       jobs = JobData.findByColumnAndValue(searchType, searchTerm);
    }

        model.addAttribute("jobs", jobs); //pass jobs ArrayList to search.html
//
//        if (searchType.equals("all")) {
//            ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
//            model.addAttribute("jobs", jobs);
//        }else {
//            ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
//            model.addAttribute("jobs", jobs);
//        }


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
