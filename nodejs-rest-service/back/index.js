'use strict';


(function(){

	//Libraries
	let express = require('express');
	let bodyParser = require('body-parser');
	let methodOverride = require('method-override');
	let router100 = require('./controllers/1.0.0/router.js').router100;

	//Configuration
	let port = (process.env.PORT)?Number(process.env.PORT):3000;

	//Middleware
	let app = express();

	app.use(bodyParser.urlencoded({extended: false}));
	app.use(bodyParser.json());
	app.use(methodOverride());

	//CORS Headers
	app.use(function(req, res, next) {
		res.set('Access-Control-Allow-Origin', '*');
		res.set('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
		res.set("Access-Control-Allow-Headers", 'Origin, X-Requested-With,Content-Type, Accept');
		next();
	});
	
	//Router services v1.0.0
	app.use('/1.0.0',router100);

	//Start the server
	app.listen(port, function(){
		console.log('Server is running on http://localhost:'+port);
	});
	
}());