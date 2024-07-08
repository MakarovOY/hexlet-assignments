@template.layout.page(
    content = @`
    <form action="/users" method="post">
        <div>
            <label>First Name<input type="text" name="firstName" /></label>
        </div>
        <div>
            <label>Last Name<input type="text" name="lastName" /></label>
        </div>
        <div>
            <label>Email Adress<input type="email" name="email" /></label>
        </div>
        <div>
            <label>Password<input type="password" name="password" /></label>
        </div>
    <div>
        <label>
            <input type="submit" value="Зарегистрировать" />
        </label>
    </div>


    </form>
`
)
