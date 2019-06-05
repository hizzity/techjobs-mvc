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

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value="results") //why isn't this post???
    //instructions: 'The method should take in two parameters, specifying the type of search
    // and the search term'
    public String results(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm); //used @RequestParam to get searchTerm
        return ("search"); //
        }

    }


//Instructions:
// Add another results handler method to SearchController, overloading the existing method.
// The method should take in two parameters, specifying the type of search and the search term.
// In order for the parameters to be properly passed in by Spring Boot, you'll need to name them
// appropriately, based on the corresponding form field names. ***You'll also need to use the correct
// annotations for the method and parameters. To configure the correct mapping route, refer to the
// form action in search.html.
//
//After looking up the search results via the JobData class, you'll need to pass them into the
// search.html view via the model. You'll also need to pass ListController.columnChoices to the
// view, as the existing search handler does.