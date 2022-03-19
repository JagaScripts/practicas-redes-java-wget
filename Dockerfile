#FROM openjdk:11 AS wget
FROM openjdk:11
COPY ["DownFile.java","HTMLtoAscii.java","wget.java","/usr/src/wget/"]
WORKDIR /usr/src/wget
RUN ["javac","wget.java"]
ENTRYPOINT [ "java","wget"]
CMD [" "]
