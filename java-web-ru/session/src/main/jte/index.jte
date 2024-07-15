@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(content = @`


    @if(page.getName() == null)
        <div>
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        </div>
    @else
        <p>${page.getName().toString()}</p>
        <p>
        <form action="${NamedRoutes.logoutPath()}" method="post">

            <input type="submit" value="Выйти"/>
        </form>

    @endif
    `)
