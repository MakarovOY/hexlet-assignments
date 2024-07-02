@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <h1>user info</h1>
${page.getUser().toString()}
`)
