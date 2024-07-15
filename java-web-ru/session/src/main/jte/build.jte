@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page
@template.layout.page(content =
@`
    @if(page != null && page.getError() != null)
        <p>${page.getError()}</p>
        @endif
    <div>
        <form action="${NamedRoutes.loginPath()}" method="post">
            <input type="text" placeholder="name" name="name">
            <input type="text" placeholder="password" name="password">
            <input type="submit" />
        </form>
    </div>
`)
