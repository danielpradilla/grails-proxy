# grails-proxy

Small grails proxy app for bypassing the same origin policy 

**Note**

Requires the wslite grails plugin http://grails.org/plugin/wslite

## How to use

General ideas:
* For extra security, the url will be fixed within a configuration file. 
* It's better if you use a different controller for each domain you want to query
* You will call the proxy url, pass along the path to the desired resource and the rest of the parameters


### 1. Create the controller
Check DemoController for a working sample

Change 'demo.service.url' accordingly ie: 'service.name.url'


### 2. Configure the url

Create a configuration file at `{USER_HOME}/.grails/grails-proxy-config.groovy`

replace demo.service.url with your own. Example:
``` groovy
service.name.url='http://otherserver/service'
```

Reload the configuration using
`http://server:port/grails-proxy/configReload`

You can add as many services as you want.

You must restart the application when you change the service url... or you can reload the configuration dynamically (see below)

### 3. Deploy the app

### 4. Query your service
`http://server:port/grails-proxy/service`

where 'service' is the name of the controller you chose


## Dynamically reload the configuration
If you want to change your service url without restarting the app, change the grails-proxy-config.groovy file and then

http://server:port/grails-proxy/configReload



### Demo config file
Save this at `{USER_HOME}/.grails/grails-proxy-config.groovy`

``` groovy
demo.service.url='http://echo.jsontest.com/key/value/one/two'
```


