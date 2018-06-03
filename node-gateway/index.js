'use strict'

var express = require('express');
var app = express();
var port = process.env.port || 9090;



var campanhaRoutes = require('./app/routes/campanha.routes.js');
var socioRoutes = require('./app/routes/socioTorcedor.routes.js');

app.use(campanhaRoutes);
app.use(socioRoutes);



app.listen(port);

console.log('online @ localhost:' + port);