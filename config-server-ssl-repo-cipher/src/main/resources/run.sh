cd $PWD
java \
    -Dlogging.config=./config/logback.xml \
    -Djavax.net.ssl.trustStore=./config/trustStore.jks \
    -Djavax.net.ssl.trustStorePassword=Spsvn@123 \
    -jar config-server.jar