@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <h1>user info</h1>
${page.getUser().toString()}
`,
usersLink = @`<a href="/users">list of users</a>`,
mainPageLink = @`<a href="/">main page</a>`)
