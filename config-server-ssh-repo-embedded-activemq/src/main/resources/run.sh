cd $PWD
java \
    -Dlogging.config=./config/logback.xml \
    -Djavax.net.ssl.trustStore=./config/cacerts \
    -Djavax.net.ssl.trustStorePassword=changeit \
    -jar config-server.jar