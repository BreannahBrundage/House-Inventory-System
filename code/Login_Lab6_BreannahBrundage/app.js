//Setup sqlite to manage db connection/query
const sqlite3 = require('sqlite3').verbose();

//Define basic SQL query to fetch all TODO items
const fetchTodoQuery = 'SELECT * FROM TODO ORDER BY Priority ASC';
const insertTodoQuery = 'INSERT INTO TODO (Name, Description, Priority) VALUES (?, ?, ?)';

//Define basic SQL query to verify username and password
const loginQuery = 'SELECT * FROM users WHERE username = ? AND password = ?';

//Define basic SQL query to insert a new user account into the database
const createAccountQuery = 'INSERT INTO users (username, password) VALUES (?, ?)';

//Define basic SQL query to create the user table
const createUserTableQuery = 'CREATE TABLE IF NOT EXISTS users (username TEXT PRIMARY KEY, password TEXT)';

//Define function to connect to DB
const connectToDB = function() {
	return new sqlite3.Database('./todo-store.db', sqlite3.OPEN_READWRITE, 
									(err) => {
									  if (err){
										  console.error('Connection error:', err.message);
										  process.exit(1)
									  }
									  console.log('Connected to the SQLite database.');
									}
								);
}


//Define function to close DB
const closeDB = function(db) {
	db.close((err) => {
	  if (err) {
		  return console.error('Closure error:', err.message);
	  }
	  console.log('Database connection closed.');
	});
}


//Create users table in database
const db = connectToDB();

db.run(createUserTableQuery, function(err) {
	if (err) {
		console.error('Error creating database:', err.message);
	} else {
		console.log('User table is now ready');
	}
	closeDB(db);
});



//Define function to insert into DB - promise supports synchronous resolution
const insertTodo = async (db, sql, params) => {
	return new Promise((resolve, reject) => {
		db.run(sql, params, function(err) {
			if (err) {
			  reject(err);
			}
			console.log('Inserted TODO Item with the following information.');
			console.log('name:', params[0]);
			console.log('description:', params[1]);
			console.log('priority:', params[2]);
			console.log('---');
			resolve();
		});
    });
};


//Define function to retrieve all TODO items in db - promise supports synchronous resolution
const fetchAll = async (db, sql, params) => {
  return new Promise((resolve, reject) => {
    db.all(sql, params, (err, rows) => {
		if (err) { 
			reject(err);
		}

		todoList = []
	  
		// using forEach function: Loop through rows if needed
		rows.forEach((row) => {
			todoList.push({name:row.Name, description:row.Description, priority:row.Priority})
		});
			  
		// using for loop: Loop through todoList to verify items in todoList going to index
		console.log("Retrieved the following TODO Items")
		for (const todoItem of todoList) {
			console.log(todoItem.name, todoItem.description, todoItem.priority)
		}
		console.log("---")
		
		resolve(todoList);
    });
  });
};

//setup express to handle routing and rendering
var express = require('express');
var app = express();
app.set('view engine', 'ejs');

//setup bodyparser to extra data from form posts
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true })); 

//setup static public directory (to link images from view pages)
app.use(express.static('public'))


//Route to login page
app.get('/login', function(req, res) {
	res.render('page/login', {error: ''});
});

//Route to create account page
app.get('/register', function(req, res) {
	res.render('page/register', {error: ''});
});


//Check for username and password when user logs in
app.post('/login', function(req, res) {
	const username = req.body.username;
	const password = req.body.password;
	const db = connectToDB();

	db.get(loginQuery, [username, password], function(err, user) {
		if (err) {
			console.log(err);
			res.send('Error logging in');
		} else if (user) {
			res.redirect('/todo?username=' + encodeURIComponent(username));
		} else {
			res.render('page/login', {
				error: 'Invalid username or password'
		   });
		}
		closeDB(db);
	});
});


//Save new user account creation data
app.post('/register', function(req, res) {
	const username = req.body.username;
	const password = req.body.password;
	const db = connectToDB();

	db.run(createAccountQuery, [username, password], function(err) {
		if (err) {
			console.log(err);
			res.render('page/register', {
				error: 'Error creating account'
			});
		} else {
			res.redirect('/login');
		}
		closeDB(db);
	});
});


//Redirect user from homepage to login page first
app.get('/', function(req, res) {
	res.redirect('/login');
});


// route to index page
app.get('/todo', async function(req, res) {
	
	console.log("Running fetch")
	const db = new connectToDB();
	
	try {
		const todoList = await fetchAll(db, fetchTodoQuery);
		res.render('page/index',  {
			data: todoList,
			username: req.query.username || ''
		});
	} catch (err) {
		console.log(err);
		res.render('page/error');
	} finally {
		closeDB(db);
	}
});

// route to api call for checking a phone number
app.post('/api/add_todo', async function(req, res) {
	//setup params for query from form elements
	var name = req.body.name;
	var description = req.body.description;
	var priority = req.body.priority;
	const params = [name, description, priority]
	
	const db = new connectToDB();
	
	try {
		await insertTodo(db, insertTodoQuery, params);
		const todoList = await fetchAll(db, fetchTodoQuery);
		res.render('page/index', {
			data: todoList,
			username: req.query.username || ''
		});
	} catch (err) {
		console.log(err);
		res.render('page/error');
	} finally {
		closeDB(db);
	}
});

//start the web app
app.listen(8080, function () {
	console.log('App listening on port 8080!');
});

