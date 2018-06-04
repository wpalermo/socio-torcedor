'use strict'

var express = require('express');
var app = express();
var port = process.env.port || 9090;
var eureka = require('eureka-js-client').Eureka;



var campanhaRoutes = require('./app/routes/campanha.routes.js');
var socioRoutes = require('./app/routes/socioTorcedor.routes.js');


var client = new eureka({
    instance: {
        app: 'node-gateway',
        hostName: 'localhost',
        ipAddr: '127.0.0.1',
        port: 8080,
        vipAddress: 'assinatura.com',
        dataCenterInfo: {
          name: 'wpalermo',
        },
      },

    eureka: {
        host: 'localhost',
        port: 8761
    }
});

client.start();


//ADICINANDO ROTAS NA APLICACAO
app.use(campanhaRoutes);
app.use(socioRoutes);


app.listen(port);

console.log('online @ localhost:' + port);