@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
page = page,
content = @`

    <div>
        ${page.getFlash()}
    </div>

`)

