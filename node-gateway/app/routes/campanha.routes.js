'use strict'

var exports = module.exports = {};
var express = require('express');
var router = express.Router();

var service = '/CAMPANHA-SERVICE';


router.get(service, function(req, res){
    res.send('get campanha');
});


module.exports = router;