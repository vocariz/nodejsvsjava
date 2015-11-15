'use strict';
(function(){
	let nodejsRestCrtl = require('./nodejsRest.js').nodejsRestCrtl;
	let express = require('express');
	let router = express.Router();

	router.get('/nodejsRest',nodejsRestCrtl);
	exports.router100=router;

}());