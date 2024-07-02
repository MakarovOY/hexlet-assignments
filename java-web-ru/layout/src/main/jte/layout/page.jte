@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hello!</title>
    </head>
    <body>
    <header>
<a href="/users">users</a>
<a href="/">main page</a>  
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
