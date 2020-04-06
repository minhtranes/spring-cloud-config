FROM java:8u111-jre
ADD target/config-server-build-directory /opt/config-server
WORKDIR /opt/config-server
EXPOSE 8888
ENTRYPOINT ["/bin/bash","run.sh"]