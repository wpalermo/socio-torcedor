'use strict'

var exports = module.exports = {};
var express = require('express');
var app = express();


exports.get = function(){
    app.get('/', function(req, res) {
        res.send('Hello exports');
    });
};