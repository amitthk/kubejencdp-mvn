# The MIT License
# SPDX short identifier: MIT
# Further resources on the MIT License
# Copyright 2018 Amit Thakur - amitthk - <e.amitthakur@gmail.com>
# Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
# The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
FROM maven:3.3.9-jdk-8

ARG RELEASE_VERSION=1.0.0-SNAPSHOT
ARG API_NAME=blogpost-api
ARG API_BUILD_DIR=/opt/usr/src
ARG APP_HOME_DIR=/var/www/app
ARG SPRING_PROFILES_ACTIVE=dev
ENV RELEASE_VERSION ${RELEASE_VERSION}
ENV API_FULL_NAME ${API_NAME}-${RELEASE_VERSION}
ENV API_BUILD_DIR ${API_BUILD_DIR}
ENV APP_HOME_DIR ${APP_HOME_DIR}
ENV SPRING_PROFILES_ACTIVE ${SPRING_PROFILES_ACTIVE}

EXPOSE 8080 8081

USER root

RUN mkdir -p ${APP_HOME_DIR} \
    && groupadd -g 10000 appuser \
    && useradd --home-dir ${APP_HOME_DIR} -u 10000 -g appuser appuser

COPY . ${API_BUILD_DIR}

RUN cd ${API_BUILD_DIR}/ \
    && mvn clean package -Pjar -Dapi_name=${API_NAME} -Drelease_version=${RELEASE_VERSION} \
    && cp ${API_BUILD_DIR}/target/${API_FULL_NAME}.jar ${APP_HOME_DIR}/ \
    && cp ${API_BUILD_DIR}/files/entrypoint ${APP_HOME_DIR}/ \
    && echo "java -jar -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} ${APP_HOME_DIR}/${API_FULL_NAME}.jar" > ${APP_HOME_DIR}/run \
    && chmod -R 0766 ${APP_HOME_DIR} \
    && chown -R appuser:appuser ${APP_HOME_DIR} \
    && chmod g+w /etc/passwd

WORKDIR ${APP_HOME_DIR}

USER appuser

ENTRYPOINT [ "./entrypoint" ]
CMD ["./run"]