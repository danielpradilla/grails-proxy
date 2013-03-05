package grails.proxy

class ConfigReloadController {

    def index() {
        def config = grailsApplication.config
        def locations = config.grails.config.locations

        locations.each {
            String configFileName = it.split("file:")[1]
            config.merge(new ConfigSlurper().parse(new File(configFileName).text))
            render text:'loading '+configFileName +'<br/>'
        }
        render text:'done'

    }
}
