//setup express to handle routing and rendering
var express = require('express');
var app = express();
app.set('view engine', 'ejs');
app.use(express.static('public'));

//setup bodyparser to extra data from form posts
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true })); 

// route to index page
app.get('/', function(req, res) {
    res.render('page/index');
});

// route to documentation page
app.get('/documentation', function(req, res) {
    res.render('page/documentation');
});

//route to quickstart page
app.get('/quickstart', function(req, res) {
    res.render('page/quickstart');
});

//route to Add Location page
app.get('/add_location', function(req, res) {
    res.render('page/add_location');
});

//route to Add Item page
app.get('/add_item', function(req, res) {
    res.render('page/add_item');
});

//route to View Item page
app.get('/view_item', function(req, res) {
    res.render('page/view_item');
});

//route to Edit Item page
app.get('/edit_item', function(req, res) {
    res.render('page/edit_item');
});

//route to Remove Item page
app.get('/remove_item', function(req, res) {
    res.render('page/remove_item');
});

//route to Remove Item page
app.get('/search_item', function(req, res) {
    res.render('page/search_item');
});

//start the web app
app.listen(8080, function () {
	console.log('App listening on port 8080!');
});

