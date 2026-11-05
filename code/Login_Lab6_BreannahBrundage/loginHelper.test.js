//Import login helper function
const isValidLogin = require('./loginHelper');

//Test successful login
test('Successful; login', () => {
    const user = {
        username: 'testuser',
        password: 'password123'
    };
    expect(isValidLogin(user, 'testuser', 'password123')).toBe(true);
});

//Test unsuccessful login
test('Unsuccessful login', () => {
    expect(isValidLogin(null, 'testuser', 'password123')).toBe(false);
});

//Test incorrect password
test('Incorrect password', () => {
    const user = {
        username: 'testuser',
        password: 'password123'
    };
    expect(isValidLogin(user, 'testuser', 'wrongpassword123')).toBe(false);
});

//Test incorrect username
test('Incorrect username', () => {
    const user = {
        username: 'testuser',
        password: 'password123'
    };
    expect(isValidLogin(user, 'wronguser', 'password123')).toBe(false);
});