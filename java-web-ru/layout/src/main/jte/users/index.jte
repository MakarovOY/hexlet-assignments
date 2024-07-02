@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(content = @`<h1>List of users</h1>
      @for (var user : page.getUsers())
          <div>
              <a href="users/${user.getId()}"><ul>
                      <li>${user.getFirstName()}
                          ${user.getLastName()}</li>
                  </ul></a>
          </div>
        @endfor
`)
