@import gg.jte.Content
@param Content content
@param Content mainPageLink = null
@param Content usersLink = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hello!</title>
    </head>
    <body>
    <header>
        @if (usersLink != null)
        <p>${usersLink} </p>
        @endif
        @if (mainPageLink != null)
            <p> ${mainPageLink} </p>
        @endif
    </header>
    <div>
        <p>
            ${content}
        </p>
    </div>
    <footer>
        <p>Simple string for example</p>
    </footer>
    </body>
    </html>
