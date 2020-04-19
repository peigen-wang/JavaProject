package com.controller.action;

import com.model.Person;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author peigen
 */
public class PersonAction extends ActionSupport implements ModelDriven<Person> {

    private Person person = new Person();

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public Person getModel() {
        return person;
    }
}
