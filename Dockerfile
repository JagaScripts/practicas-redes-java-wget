FROM openjdk:11
COPY [".","/usr/src/wget"]
WORKDIR /usr/src/wget
CMD ["java", "Main"]