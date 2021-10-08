FROM postgres:14.0
ENV POSTGRES_USER angel
ENV POSTGRES_PASSWORD secret
ENV POSTGRES_DB test
COPY names.sql /docker-entrypoint-initdb.d/