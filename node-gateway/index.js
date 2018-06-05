'use strict'

var express = require('express');
var app = express();
var port = process.env.port || 9090;
var eureka = require('eureka-js-client').Eureka;



var campanhaRoutes = require('./app/routes/campanha.routes.js');
var socioRoutes = require('./app/routes/socioTorcedor.routes.js');
var eureka = require('./app/config/eureka.js');



//ADICINANDO ROTAS NA APLICACAO
app.use(campanhaRoutes);
app.use(socioRoutes);

eureka.startClient();

app.listen(port);
console.log('online @ localhost:' + port);
