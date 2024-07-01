@import exercise.dto.users.UserPage
@param UserPage page
<html>
<head>
    <meta charset="utf-8" />
    <title>Users</title>
</head>
<body>
<h1>user info</h1>
    <div>
            ${page.getUser().toString()}
    </div>
</body>
</html>
