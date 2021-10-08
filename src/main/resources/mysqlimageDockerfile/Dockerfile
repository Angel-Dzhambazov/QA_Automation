FROM mysql:8
ENV MYSQL_ROOT_PASSWORD secret
ENV MYSQL_DATABASE mysql_schema
COPY listProductsCustomers.sql /docker-entrypoint-initdb.d/