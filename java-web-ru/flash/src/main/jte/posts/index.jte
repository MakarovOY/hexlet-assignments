@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
page = page,
content = @`

    <div>
        ${page.getFlash()}
    </div>
    <table>
    @for(var post: page.getPosts())
        <tr>
            <td>${post.getName()}</td>

            <td>${post.getBody()}</td>
        </tr>
    @endfor
    </table>

`)

