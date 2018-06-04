'use strict'

var express = require('express');
var request = require('request');
var router = express.Router();

var service = '/sociotorcedor-service';

router.get(service, function(req, resp){

    request('http://localhost:8081/socio-torcedor/', (err, res, body) => {
        console.log('error', err);
        console.log('statusCode', res && res.statusCode);
        console.log('body', body);
        resp.send('body: ' + body);
    });
    
});


module.exports = router;

