package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN
    public static void create(Context ctx) {
        String name = ctx.formParamAsClass("name", String.class)
                .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                .get();
        String body = ctx.formParam("body");
        var post = new Post(name, body);
        PostRepository.save(post);
        ctx.sessionAttribute("flash", "Пост был успешно создан!");
        ctx.redirect(NamedRoutes.postsPath());

    }
    public static void index (Context ctx) {
        try{
            String flash = ctx.consumeSessionAttribute("flash");
            var posts = PostRepository.getEntities();
            var page = new PostsPage(posts);
            page.setFlash(flash);
            ctx.render("posts/index.jte", model("page", page));
        } catch(ValidationException e) {
            ctx.render(NamedRoutes.buildPostPath());
        }


    }
    
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
