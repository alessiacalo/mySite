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
    private Page twoPreviousPage;
    private String twoPreviousTitle;
    @Inject
    private Page threePreviousPage;
    private String threePreviousTitle;

    @PostConstruct
    protected void init() throws IOException {
        if (currentPage.getTitle() != null) {
            currentTitle = currentPage.getTitle().toString();
        }
        previousPage = currentPage.getParent();
        if (previousPage.getTitle() != null) {
            previousTitle = previousPage.getTitle().toString();
        }
        twoPreviousPage = currentPage.getParent(2);
        if (twoPreviousPage.getTitle() != null) {
            twoPreviousTitle = twoPreviousPage.getTitle().toString();
        }
        threePreviousPage = currentPage.getParent(3);
        if (threePreviousPage.getTitle() != null) {
            threePreviousTitle = threePreviousPage.getTitle().toString();
        }
        message = "Ciao, ora ti trovi nella " + currentTitle + ". La pagina precedente è " + previousTitle + ". La pagina antecedente ad italian è " + twoPreviousTitle + ". La prima pagina è " + threePreviousTitle;
    }

    public String getCurrentTitle() {
        return currentTitle;
    }

    public String getPreviousTitle() {
        return previousTitle;
    }

    public String getTwoPreviousTitle() {
        return twoPreviousTitle;
    }

    public String getThreePreviousTitle() {
        return threePreviousTitle;
    }

    public String getMessage() {
        return message;
    }


}
