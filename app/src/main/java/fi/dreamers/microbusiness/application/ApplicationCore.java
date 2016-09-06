package fi.dreamers.microbusiness.application;

import android.app.Application;

/**
 * Created by mis on 8/5/2016.
 */
public class ApplicationCore extends Application {
    //property declared in this class can be globally accessible by other classes
    private String name = "Mesbahul Islam";
    private String email = "mesbahul.islam@nls.fi";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
