'use strict'

var eureka =  require('eureka-js-client').Eureka;

var client = undefined;

exports.startClient = function(){

    client = new eureka({
        instance: {
            app: 'node-gateway',
            hostName: 'localhost',
            ipAddr: '127.0.0.1',
            port: {
                '$': 9090,
                '@enabled': true,
              },
            vipAddress: 'assinatura.com',
            dataCenterInfo: {
             '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
              name: 'MyOwn',
            },
          },
    
        eureka: {
            host: 'localhost',
            port: 8761,
            servicePath: '/eureka/apps/'
        }
    });

    
    client.logger.level('debug');
    client.start();
    console.log('Eureka client started');

};

exports.getClient = function(){

    if(!client)
        start();
    
    return client;

};

