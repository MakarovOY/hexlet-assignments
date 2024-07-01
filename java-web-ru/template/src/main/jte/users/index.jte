@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
    <head>
    <meta charset="utf-8" />
    <title>Users</title>
    </head>
    <body>
        <h1>List of users</h1>

            @for(var user : page.getUsers())
                <div>

                    <a href="users/${user.getId()}"><ul>
                                            <li>${user.getFirstName()}
                                           ${user.getLastName()}</li>
                                          </ul></a>

                </div>

            @endfor
    </body>


</html>
