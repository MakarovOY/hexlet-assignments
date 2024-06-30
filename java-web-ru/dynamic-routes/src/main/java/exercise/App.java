package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

// BEGIN
    app.get("/companies/{id}", ctx -> {
        var id = ctx.pathParam("id");
                for(Map<String, String> company : COMPANIES) {
                    var value = company.get("id");
                   if(value.equals(id)) {
                       ctx.json(company);
                   }
                   throw new NotFoundResponse("Company not found");
                }
    });
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
