'use strict'

var express = require('express');
var app = express();

app.get('/', function(req, res){
    res.send("Hellow GET");
});

app.listen(3000, function(){
    console.log("Escutando porta 3000");
});