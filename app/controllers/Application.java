package controllers;

import models.*;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	//formular za dodavanje taskova
	static Form<Task> submitForm = new Form<Task>(Task.class);
	
    public static Result index() {
        return ok(index.render("Welcome to ToDo!", submitForm, Task.all()));
    }
    
    public static Result createTask() {
    	Form<Task> bindForm = submitForm.bindFromRequest();
    	if(bindForm.hasErrors() == false) {
    		Task.create(bindForm.get());
    		submitForm = new Form<Task>(Task.class); //brisanje submitForma
    		return redirect("/");
    	}
    	return ok(index.render("Welcome to ToDo!", bindForm, Task.all()));
    }
    
    public static Result deleteTask(int id) {
    	Task.remove(id);
    	return redirect("/");
    }
    
  

}
