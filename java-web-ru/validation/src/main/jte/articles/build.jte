@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page
@template.layout.page(content = @`
    @if(page == null)

        <form action="/articles" method="post">
            <div>
                <label>
                    Title
                    <input type = "text" required name = "title">
                </label>
            </div>

            <div>
                <label>
                    Content
                    <input type = "text" name="content" >
                </label>
            </div>

            <div>
                <input type = "submit" name="publish">
            </div>
        </form>
    @endif

    @if(page != null)
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
        @endif

    <form action="/articles" method="post">
        <div>
            <label>
                Title
                <input type = "text" required name = "title" value="${page.getTitle()}">
            </label>
        </div>

        <div>
            <label>
                Content
                <input type = "text" name="content" value="${page.getContent()}">
            </label>
        </div>

        <div>
            <input type = "submit" name=" publish">
        </div>
    </form>
        @endif

`
)
