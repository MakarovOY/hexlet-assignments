@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`

       <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
    </form>
   @if(page.getTerm() == null)

       <p>${page.getUsers().toString()}</p>>

       @else

        <p>${page.getUsers().toString()}</p>>
        @endif
`
)
