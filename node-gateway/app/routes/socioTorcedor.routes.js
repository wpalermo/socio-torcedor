'use strict'

var exports = module.exports = {};
var express = require('express');
var router = express.Router();

var service = '/sociotorcedor-service';

router.get(service, function(req, res){
    res.send('get socio torcedor');
});


module.exports = router;

