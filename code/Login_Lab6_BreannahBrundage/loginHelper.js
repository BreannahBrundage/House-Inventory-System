//Check is the database holds a valid user
function isValidLogin(user, username, password) {
    return user != null && user.username === username && user.password === password;
}

module.exports = isValidLogin;