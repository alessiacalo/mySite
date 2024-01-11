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

    @PostConstruct
    protected void init() throws IOException {
        if (currentPage.getTitle() != null) {
            currentTitle = currentPage.getTitle().toString();
        }
        previousPage= currentPage.getParent();
        if (previousPage.getTitle()!=null) {
            previousTitle= previousPage.getTitle().toString();
        }
        message = "Ciao, ora ti trovi " + currentTitle +". La pagina precedente era "+previousTitle;

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
