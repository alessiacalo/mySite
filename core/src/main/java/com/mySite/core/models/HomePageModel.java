package com.mySite.core.models;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import java.io.IOException;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HomePageModel {
    @Inject
    private Page currentPage;
    private String currentTitle;
    private String message;
    @Inject
    private Page previousPage;
    private String previousTitle;

    @Inject
    private Page previousPageTwo;
    private String previousTitleTwo;

    @Inject
    private Page previousPageThree;
    private String previousTitleThree;

    @PostConstruct
    protected void init() throws IOException {
        if (currentPage.getTitle() != null) {
            currentTitle = currentPage.getTitle().toString();
        }

        previousPage = currentPage.getParent();
        if (previousPage.getTitle()!=null) {
            previousTitle= previousPage.getTitle().toString();
        }

        previousPageTwo = currentPage.getParent(2);
        if (previousPageTwo.getTitle()!=null) {
            previousTitleTwo= previousPageTwo.getTitle().toString();
        }

        previousPageThree = currentPage.getParent(3);
        if (previousPageThree.getTitle()!=null) {
            previousTitleThree= previousPageThree.getTitle().toString();
        }

        message = "Ciao, ora ti trovi nella pagina " + currentTitle + ". La pagina precedente era "+previousTitle + ", quella prima "+previousTitleTwo + ". La pagina iniziale è: " + previousTitleThree;
        }

    public String getCurrentTitle() {
        return currentTitle;
    }
    public String getPreviousTitle() {
        return previousTitle;
    }

    public String getMessage() {
        return message;
    }

}