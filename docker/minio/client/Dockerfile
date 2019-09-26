FROM minio/mc:RELEASE.2019-02-20T22-21-50Z

WORKDIR /app

RUN apk add --no-cache bash

ENV MINIO_ACCESS_KEY=minio \
    MINIO_SECRET_KEY=minio123# \
    MINIO_HOST=localhost \
    MINIO_PORT=9000

ENTRYPOINT mc config host add minio http://${MINIO_HOST}:${MINIO_PORT} ${MINIO_ACCESS_KEY} ${MINIO_SECRET_KEY} \
              && mc mb --ignore-existing minio/restaurant \
              && mc policy download minio/restaurant

