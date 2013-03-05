package grails.proxy

import grails.converters.*

class DemoController {

    def index() {
        //put the following line in an external config file named {USER_HOME}/.grails/grails-proxy-config.groovy
         //demo.service.url='http://echo.jsontest.com/key/value/one/two'
        String url = grailsApplication.config.demo.service.url //change demo.service.url accordingly
        String path = params.path
        renderResponse(url,path,params)

    }
    
    def test(){
        String url = params.url
        renderResponse(url,'/',params)
    }
    
    def renderResponse(url,path,params){
        withRest(url: url) {
            def resp = get(path: path, query: params)
                response.contentType = resp.contentType
                render resp.text
        }

    }
}
