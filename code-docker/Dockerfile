# 镜像源
FROM openjdk:8-jdk-slim
# 元数据
LABEL authors="FengDuo"
# 将项目的JAR文件复制到容器中
COPY target/code-docker-1.0.0-SNAPSHOT.jar app.jar
# 暴露应用运行的端口
EXPOSE 9000
# 指定启动命令
ENTRYPOINT ["java", "-jar", "/app.jar"]