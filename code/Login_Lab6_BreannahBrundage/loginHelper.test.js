//Import login helper function
const isValidLogin = require('./loginHelper');

//Test successful login
test('Successfu; login', () => {
    expect(isValidLogin({ username: 'testuser'})).toBe(true);
});

//Test unsuccessful login
test('Unsuccessful login', () => {
    expect(isValidLogin(null)).toBe(false);
});