FROM postgres:16.1

ENV POSTGRES_DB library-db
ENV POSTGRES_USER 59e36b5e-f72b-4b27-a58e-7c0c2c2f9e6e
ENV POSTGRES_PASSWORD e4a23b99-ec65-4d71-bc6f-9fb29a14d0e7

COPY schema.sql /docker-entrypoint-initdb./

EXPOSE 5432

CMD ["postgres"]
