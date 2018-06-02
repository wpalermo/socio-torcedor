'use strict'

var express = require('express');
var app = express();
var port = process.env.port || 9091;



var campanha = require('./app/routes/campanha-routes.js');

//campanha.get();


app.listen(port);


