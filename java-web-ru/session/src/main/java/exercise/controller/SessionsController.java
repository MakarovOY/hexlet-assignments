package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import exercise.util.Security;
import exercise.util.NamedRoutes;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
private static final String CURRENT_USER = "currentUser";

    public static void index(Context ctx) {

        var page = new MainPage(ctx.sessionAttribute(CURRENT_USER));
        ctx.render("index.jte", model("page", page));
    }
    public static void build(Context ctx) {

        ctx.render("build.jte");
    }

    public static void create(Context ctx) {

        var name = ctx.formParam("name");
        var password = Security.encrypt(ctx.formParam("password"));
        for (var user: UsersRepository.getEntities()) {
            if(user.getPassword().equals(password) && user.getName().equals(name)) {
                ctx.sessionAttribute(CURRENT_USER, name);
                ctx.redirect(NamedRoutes.rootPath());
                return;
            }
        }
        var page = new LoginPage(name, "Wrong username or password");
        ctx.render("build.jte", model("page", page));

    }
    public static void destroy(Context ctx) {
        ctx.sessionAttribute(CURRENT_USER, null);
        ctx.redirect(NamedRoutes.rootPath());
    }    
    // END
}
